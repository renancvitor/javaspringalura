package com.renan.javaspring.apiTabelaFipe.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDadosFipe implements IConverteDadosFipe {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDadosFipe(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
