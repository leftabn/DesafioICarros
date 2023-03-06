package br.com.icarros.testes.api.entity;

import java.io.Serializable;

public record Constructor(
        String constructorId,
        String url,
        String name,
        String nationality
) implements Serializable {}
