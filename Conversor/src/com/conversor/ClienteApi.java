package com.conversor;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ClienteApi {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/3f146d6ca354f9b8c88d6787/latest/USD";
    private HttpClient cliente;

    public ClienteApi() {
        cliente = HttpClient.newHttpClient();
    }

    public JSONObject obtenerTasasCambio() throws Exception {
        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        if (respuesta.statusCode() != 200) {
            throw new RuntimeException("Error al obtener las tasas de cambio: " + respuesta.statusCode());
        }

        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(respuesta.body());
    }
}
