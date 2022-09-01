package com.api.bankaccount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CONTA")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numero;

    @Column(nullable = false, columnDefinition = "double default 0")
    private double saldo;

    @OneToOne
    private Cliente cliente;
}
