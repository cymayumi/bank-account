package com.api.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteContaDTO {
    private long cpf;
    private String nome;
    private ContaDTO contaDTO;
}
