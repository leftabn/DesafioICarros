package br.com.icarros.testes.api.service;

import br.com.icarros.testes.api.client.ErgastClient;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JsonService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final ErgastClient client;

    public JsonService(ErgastClient client) {
        this.client = client;
    }
    public JsonObject getAllResults() {
        this.logger.info("[getAllResults] - getAllResults request");
        return client.getAllResults();
    }
}
