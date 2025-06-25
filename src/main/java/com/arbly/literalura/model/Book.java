package com.arbly.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Book(
        String title,
        List<Author> authors,
        /*List<String> summaries,*/
        /*List<Translator> translators,*/
        /*List<String> subjects,*/
        /*List<String> bookshelves,*/
        List<String> languages,
        /*boolean copyright,*/
        /*String mediaType,*/
        /*Map<String, String> formats,*/
        @JsonAlias("download_count") int downloadCount
) {
}
