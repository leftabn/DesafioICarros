package br.com.icarros.testes.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record Circuit(
        String circuitId,
        String url,
        String circuitName,
        @JsonProperty(value = "Location")
        Location location
) implements Serializable {}
