package br.com.icarros.testes.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record FastestLap(
        int rank,
        int lap,
        @JsonProperty(value = "Time")
        Time time,
        @JsonProperty(value = "AverageSpeed")
        AverageSpeed averageSpeed
) implements Serializable {}
