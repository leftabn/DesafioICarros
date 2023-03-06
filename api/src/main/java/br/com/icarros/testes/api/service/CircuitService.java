package br.com.icarros.testes.api.service;

import br.com.icarros.testes.api.entity.Circuit;
import br.com.icarros.testes.api.utils.ConstantsUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CircuitService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final JsonService jsonService;

    public CircuitService(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @Cacheable(cacheNames = "Circuit", key="#root.method.name")
    public Circuit getCircuitInfos() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String circuitInfos = buildCircuitInfosString();
        Circuit circuit = objectMapper.readValue(circuitInfos, Circuit.class);
        this.logger.info("[getCircuitInfos] - getCircuitInfos request");
        return circuit;
    }

    private String buildCircuitInfosString() {
        return this.jsonService.getAllResults()
                .get(ConstantsUtil.MR_DATA).getAsJsonObject()
                .get(ConstantsUtil.RACE_TABLE).getAsJsonObject()
                .get(ConstantsUtil.RACES).getAsJsonArray()
                .get(ConstantsUtil.INDEX_ZERO).getAsJsonObject()
                .get("Circuit").getAsJsonObject()
                .toString();
    }
}
