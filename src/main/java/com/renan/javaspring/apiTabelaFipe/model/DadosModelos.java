package com.renan.javaspring.apiTabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelos(@JsonAlias("modelos") String modelo,
                           @JsonAlias("anos") String ano) {
}
