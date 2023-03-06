package br.com.icarros.testes.api.entity;

import java.io.Serializable;

public record Driver(
        String driverId,
        int permanentNumber,
        String code,
        String url,
        String givenName,
        String familyName,
        String dateOfBirth,
        String nationality
) implements Serializable {}
