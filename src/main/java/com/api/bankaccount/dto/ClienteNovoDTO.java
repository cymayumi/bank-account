package com.api.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteNovoDTO {
    @NotBlank
    @Size(max=11, min=11)
    private String cpf;

    @NotBlank
    private String nome;
}
