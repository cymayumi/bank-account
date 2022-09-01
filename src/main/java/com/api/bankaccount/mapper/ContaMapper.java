package com.api.bankaccount.mapper;

import com.api.bankaccount.dto.ClienteNovoDTO;
import com.api.bankaccount.dto.ContaAbertaDTO;
import com.api.bankaccount.model.Cliente;
import com.api.bankaccount.model.Conta;
import org.springframework.beans.BeanUtils;

public class ContaMapper {

    public static ContaAbertaDTO converterContaDTO(Conta novaConta) {
        Cliente novoCliente = novaConta.getCliente();

        ContaAbertaDTO conta = new ContaAbertaDTO();
        ClienteNovoDTO clienteNovoDTO = new ClienteNovoDTO();

        BeanUtils.copyProperties(novaConta,conta);
        BeanUtils.copyProperties(novoCliente,clienteNovoDTO);
        conta.setCliente(clienteNovoDTO);

        return conta;
    }
}
