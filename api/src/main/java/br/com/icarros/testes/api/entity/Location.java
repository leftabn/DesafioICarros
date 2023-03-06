package br.com.icarros.testes.api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public record Location(
        String lat,
        @JsonProperty(value = "long")
        String lon,
        String locality,
        String country
) implements Serializable {}
