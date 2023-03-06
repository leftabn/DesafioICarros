package br.com.icarros.testes.api.controller;

import br.com.icarros.testes.api.service.JsonService;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/results")
public class JsonController {
    private final JsonService service;

    public JsonController(JsonService service) {
        this.service = service;
    }
    @GetMapping
    public JsonObject getAll() {
        return service.getAllResults();
    }
}
