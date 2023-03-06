package br.com.icarros.testes.api.controller;

import br.com.icarros.testes.api.entity.Result;
import br.com.icarros.testes.api.service.ResultService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/result")
public class ResultController {
    private final ResultService service;

    public ResultController(ResultService service) {
        this.service = service;
    }

    @GetMapping
    public Result getFinalResultInfo(@RequestParam(defaultValue = "0", value = "index") int index) throws JsonProcessingException {
        return this.service.getFinalResultInfo(index);
    }

}
