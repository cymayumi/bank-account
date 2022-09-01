package com.api.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositoDTO {
    private long numero;
    @DecimalMax("2000.0")
    @DecimalMin("0.0")
    private double deposito;
}
