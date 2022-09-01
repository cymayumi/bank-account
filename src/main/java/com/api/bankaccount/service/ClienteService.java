package com.api.bankaccount.service;

import com.api.bankaccount.dto.ClienteNovoDTO;
import com.api.bankaccount.dto.ContaAbertaDTO;
import com.api.bankaccount.model.Cliente;
import com.api.bankaccount.model.Conta;
import com.api.bankaccount.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ContaService contaService;

    public ContaAbertaDTO abrirConta(ClienteNovoDTO clienteDTO) {
        Cliente clienteModel = new Cliente();
        BeanUtils.copyProperties(clienteDTO, clienteModel);

        Cliente clienteNovo = clienteRepository.save(clienteModel);

        ContaAbertaDTO contaNova = contaService.novaConta(clienteNovo);
        return contaNova;
    }
}
