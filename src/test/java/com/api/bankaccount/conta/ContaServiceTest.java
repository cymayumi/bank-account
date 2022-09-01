package com.api.bankaccount.conta;

import com.api.bankaccount.dto.ClienteNovoDTO;
import com.api.bankaccount.dto.ContaAbertaDTO;
import com.api.bankaccount.dto.DepositoDTO;
import com.api.bankaccount.model.Cliente;
import com.api.bankaccount.model.Conta;
import com.api.bankaccount.repository.ClienteRepository;
import com.api.bankaccount.repository.ContaRepository;
import com.api.bankaccount.service.ClienteService;
import com.api.bankaccount.service.ContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ContaServiceTest {
    @InjectMocks
    ClienteService clienteService;

    @InjectMocks
    ContaService contaService;

    @Mock
    ClienteRepository clienteRepository;

    @Mock
    ContaRepository contaRepository;

    Cliente cliente;
    Conta conta;

    @BeforeEach
    public void initialize() {
        MockitoAnnotations.openMocks(this);

        this.cliente = new Cliente();
        cliente.setNome("Maria");
        cliente.setCpf("12345678999");

        this.conta = new Conta();
        conta.setNumero(1);
        conta.setSaldo(0.0);
        conta.setCliente(cliente);

    }

    @Test
    public void testeNovaConta() {
        Cliente cliente = new Cliente();
        cliente.setNome("Maria");
        cliente.setCpf("12345678999");

        when(contaRepository.save(any(Conta.class))).thenReturn(this.conta);
        ContaAbertaDTO result = contaService.novaConta(cliente);

        assertNotNull(result);
        assertEquals("Maria", result.getCliente().getNome());
        assertEquals("12345678999", result.getCliente().getCpf());
        assertEquals(0.0, result.getSaldo());
    }

}
