package com.arbly.literalura;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.Array;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Livro(
        String titulo,
        String author,
        List<String> idioma,
        Integer numeroDownloads

) {
}
