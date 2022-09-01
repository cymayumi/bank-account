package com.api.bankaccount.service;

import com.api.bankaccount.dto.ContaAbertaDTO;
import com.api.bankaccount.dto.DepositoDTO;
import com.api.bankaccount.dto.TransferenciaDTO;
import com.api.bankaccount.exceptionHandler.InsufficientCashException;
import com.api.bankaccount.mapper.ContaMapper;
import com.api.bankaccount.model.Cliente;
import com.api.bankaccount.model.Conta;
import com.api.bankaccount.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public ContaAbertaDTO novaConta(Cliente cliente) {
        Conta contaNova = new Conta();
        contaNova.setCliente(cliente);
        contaNova.setSaldo(0L);

        Conta novaConta = contaRepository.save(contaNova);
        return ContaMapper.converterContaDTO(novaConta);
    }

    public ContaAbertaDTO depositar(DepositoDTO depositoDTO) {
        Conta conta = contaRepository.findById(depositoDTO.getNumero()).get();
        Double somaSaldo = conta.getSaldo() + depositoDTO.getDeposito();
        conta.setSaldo(somaSaldo);
        contaRepository.save(conta);
        return ContaMapper.converterContaDTO(conta);
    }

    public ContaAbertaDTO transferir(TransferenciaDTO transferenciaDTO) throws InsufficientCashException {
        Conta contaDe = contaRepository.findById(transferenciaDTO.getNumeroDe()).get();
        Conta contaPara = contaRepository.findById(transferenciaDTO.getNumeroPara()).get();

        double saldo = contaDe.getSaldo() - transferenciaDTO.getValor();
        if(saldo < 0.0){
            throw new InsufficientCashException("Saldo insuficiente para a transação!");
        }
        contaDe.setSaldo(saldo);
        contaPara.setSaldo(contaPara.getSaldo() + transferenciaDTO.getValor());
        contaRepository.save(contaDe);
        contaRepository.save(contaPara);
        return ContaMapper.converterContaDTO(contaDe);
    }
}
