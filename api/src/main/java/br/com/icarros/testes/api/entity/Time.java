package br.com.icarros.testes.api.entity;

import java.io.Serializable;

public record Time(
        String millis,
        String time
) implements Serializable {}
