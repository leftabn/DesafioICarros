package br.com.icarros.testes.api.service;

import br.com.icarros.testes.api.entity.Result;
import br.com.icarros.testes.api.utils.ConstantsUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ResultService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final JsonService jsonService;

    public ResultService(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    @Cacheable(cacheNames = "Result", key="#index")
    public Result getFinalResultInfo(int index) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String finalResultInfo = buildFinalResultInfoString(index);
        Result result = objectMapper.readValue(finalResultInfo, Result.class);
        this.logger.info("[getFinalResultInfo] - getFinalResultInfo request");
        return result;
    }

    private String buildFinalResultInfoString(int index) {
        return this.jsonService.getAllResults()
                .get(ConstantsUtil.MR_DATA).getAsJsonObject()
                .get(ConstantsUtil.RACE_TABLE).getAsJsonObject()
                .get(ConstantsUtil.RACES).getAsJsonArray()
                .get(ConstantsUtil.INDEX_ZERO).getAsJsonObject()
                .get("Results").getAsJsonArray()
                .get(index).toString();
    }
}
