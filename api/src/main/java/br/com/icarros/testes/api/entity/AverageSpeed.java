package br.com.icarros.testes.api.entity;

import java.io.Serializable;

public record AverageSpeed(
        String units,
        float speed
) implements Serializable {}
