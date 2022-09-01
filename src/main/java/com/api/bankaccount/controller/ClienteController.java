package com.api.bankaccount.controller;

import com.api.bankaccount.dto.ClienteNovoDTO;
import com.api.bankaccount.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping()
    public ResponseEntity abrirConta(@RequestBody @Valid ClienteNovoDTO clienteDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.abrirConta(clienteDTO));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível abrir sua conta!");
        }
    }
}
