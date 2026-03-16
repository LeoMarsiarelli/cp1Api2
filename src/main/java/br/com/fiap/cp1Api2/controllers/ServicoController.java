package br.com.fiap.cp1Api2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @GetMapping
    public String tabelaPrecos() {
        return "Serviços disponíveis: Troca de óleo, Alinhamento, Revisão de Freios";
    }
}