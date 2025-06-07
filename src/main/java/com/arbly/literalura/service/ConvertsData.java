package com.arbly.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvertsData implements IConvertsData {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T jsonToClass(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao processar a resposta do servidor");
            System.out.println(json);
//            throw new RuntimeException(e);
//            e.printStackTrace();
//            return Collections.emptyList();
            return null;
        }
    }

    @Override
    public <T> List<T> jsonToListClass(String json, Class<T> tClass) {
        try {
//            return mapper.readValue(json,
//                    mapper.getTypeFactory().constructCollectionType(List.class, tClass)
//            );
            return mapper.readerForListOf(tClass).readValue(json);
        } catch (JsonProcessingException e) {
            System.out.println("Erro ao processar a resposta do servidor");
            System.out.println(json);
//            throw new RuntimeException(e);
//            e.printStackTrace();
//            return Collections.emptyList();
            return null;
        }
    }
}
