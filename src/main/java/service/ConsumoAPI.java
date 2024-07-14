package service;

import com.google.gson.Gson;
import modelos.dto.ResponseApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoAPI {

    public static String URL = "https://v6.exchangerate-api.com/v6/76c3f7b52372f0219ba20d93/pair/";

    public ResponseApi obtenerConversion(String monedaInicial, String monedaConvertida, String monto ) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL+monedaInicial + "/" + monedaConvertida + "/" + monto))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), ResponseApi.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
