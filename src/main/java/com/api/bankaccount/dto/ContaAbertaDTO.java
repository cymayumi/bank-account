package com.api.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContaAbertaDTO {
    private long numero;
    private double saldo;
    private ClienteNovoDTO cliente;
}
