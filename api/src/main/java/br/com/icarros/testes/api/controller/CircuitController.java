package br.com.icarros.testes.api.controller;

import br.com.icarros.testes.api.entity.Circuit;
import br.com.icarros.testes.api.service.CircuitService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/circuits")
public class CircuitController {
    private final CircuitService service;

    public CircuitController(CircuitService service) {
        this.service = service;
    }

    @GetMapping
    public Circuit getCircuitInfos() throws JsonProcessingException {
        return this.service.getCircuitInfos();
    }
}
