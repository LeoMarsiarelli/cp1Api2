package br.com.fiap.cp1Api2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @GetMapping
    public String listarVeiculos() {
        return "Veículos na oficina: Civic, Renegade, Onix, T-Cross, Gol, Uno";
    }

    @GetMapping("/status")
    public String statusReparo() {
        return "Status: 2 veículos em manutenção e 1 aguardando peças";
    }
}