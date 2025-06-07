package com.arbly.literalura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RequestApi {
    private Integer statusCode;

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getApi(String requestUrl) {
        //HttpClient client = HttpClient.newHttpClient();
        HttpClient client = HttpClient.newBuilder()
                .followRedirects(HttpClient.Redirect.ALWAYS)
                .build();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(requestUrl))
                /*.header("X-Subscription-Token", System.getenv("FIPE_KEY"))*/
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        statusCode = response.statusCode();
        if (response.statusCode() != 200) {
            System.out.println("Erro....: " + response.statusCode());
            System.out.println("Mensagem: " + response.body());
        }
        return response.body();
    }
}