package br.com.icarros.testes.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record Result(
        int number,
        int position,
        String positionText,
        int points,
        @JsonProperty(value = "Driver")
        Driver driver,
        @JsonProperty(value = "Constructor")
        Constructor constructor,
        int grid,
        int laps,
        String status,
        @JsonProperty(value = "Time")
        Time time,
        @JsonProperty(value = "FastestLap")
        FastestLap fastestLap
) implements Serializable {}
