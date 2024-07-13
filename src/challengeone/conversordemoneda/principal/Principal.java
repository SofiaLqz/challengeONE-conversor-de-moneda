package challengeone.conversordemoneda.principal;

import challengeone.conversordemoneda.configuracion.Configuracion;
import challengeone.conversordemoneda.modelos.*;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.Map;


public class Principal {
    public static void main(String[] args) {
        try {
            String direccionBase = Configuracion.URL_BASE;
            String apiKey = Configuracion.API_KEY;
            // Obtener información de las monedas admitidas por la api
            InfoMonedas infoMonedas = new InfoMonedas();
            Map<Integer, String> menuMonedas = infoMonedas.consultarInfoMonedas(direccionBase + apiKey + "/codes");
            Map<Integer, String> codigosMonedas = infoMonedas.getCodigosMonedas();
            // Inicializar variables
            String codigoMonedaOrigen;
            String codigoMonedaDestino;
            double cantidad;
            while (true) {
                // Imprimir menú de opciones
                Menu.imprimirMenu(menuMonedas,
                        "   ¡Bienvenido/a al Conversor de Monedas!   ");
                // Validar las entradas del usuario
                var procesarEntradaUsuario = new ProcesarEntradaUsuario();
                // Elección de moneda de origen
                int monedaOrigenValidada = procesarEntradaUsuario.validarOpcion(menuMonedas,
                        "Elija la opción correspondiente a su moneda de origen:");
                if (monedaOrigenValidada == 0){
                    break; // Salir del bucle actual
                } else {
                    // Obtener código de la moneda elegida
                    codigoMonedaOrigen = codigosMonedas.get(monedaOrigenValidada);
                }
                // Elección de moneda de destino
                int monedaDestinoValidada = procesarEntradaUsuario.validarOpcion(menuMonedas,
                        "Elija la opción correspondiente a su moneda de destino:");
                if (monedaDestinoValidada == 0){
                    break; // Salir del bucle actual
                } else {
                    // Obtener código de la moneda elegida
                    codigoMonedaDestino = codigosMonedas.get(monedaDestinoValidada);
                }
                // Ingreso de valor a convertir
                cantidad = procesarEntradaUsuario.validarDato(
                        "Ingrese el valor que desea convertir:");
                if (cantidad == 0) {
                    break; // Salir del bucle actual
                }
                // Consultar a la api
                String direccion = direccionBase + apiKey + "/pair/" + codigoMonedaOrigen + "/" + codigoMonedaDestino;
                UsarApi api = new UsarApi();
                String json = api.obtenerDatos(direccion);
                // Deserializar el json en una instancia de clase
                Gson gson = new Gson();
                ConversorDeMoneda conversorDeMoneda = gson.fromJson(json, ConversorDeMoneda.class);
                // Mostrar resultado de la conversión solicitada por el usuario
                System.out.println(conversorDeMoneda.calcularConversion(cantidad));
            }
        } catch (NullPointerException | JsonSyntaxException e) {
            System.out.println("No se recibió la información en el formato esperado: " + e.getMessage());
        }
    }
}
