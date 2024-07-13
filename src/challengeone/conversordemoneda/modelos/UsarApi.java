package challengeone.conversordemoneda.modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UsarApi {
    private HttpClient client = HttpClient.newHttpClient();
    private HttpRequest request;
    private HttpResponse<String> response;

    public String obtenerDatos(String direccion) {
        try {
            // Solicitud
            request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            // Respuesta
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            return "Error al consultar a la API: " + e.getMessage();
        }
    }
}