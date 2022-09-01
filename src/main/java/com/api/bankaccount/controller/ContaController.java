package com.api.bankaccount.controller;

import com.api.bankaccount.dto.ClienteNovoDTO;
import com.api.bankaccount.dto.DepositoDTO;
import com.api.bankaccount.dto.TransferenciaDTO;
import com.api.bankaccount.exceptionHandler.InsufficientCashException;
import com.api.bankaccount.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/conta")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @PostMapping(value = "depositar")
    public ResponseEntity depositar(@RequestBody @Valid DepositoDTO depositoDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contaService.depositar(depositoDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar depósito!!");
        }
    }

    @PostMapping(value = "transferir")
    public ResponseEntity transferir(@RequestBody @Valid TransferenciaDTO transferenciaDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(contaService.transferir(transferenciaDTO));
        } catch (InsufficientCashException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar transferência!");
        }
    }
}
