package challengeone.conversordemoneda.modelos;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.*;

public class InfoMonedas {
        UsarApi api = new UsarApi();
        private MonedasAdmitidasAPI monedas;
        // Mapa de solo códigos de las monedas admitidas
        private Map<Integer, String> codigosMonedas = new HashMap<>();
        // Mapa de nombre completo de las monedas admitidas
        private Map<Integer, String> menuMonedas = new HashMap<>();

        public Map<Integer, String> getCodigosMonedas() {
                return codigosMonedas;
        }

        public Map<Integer, String> consultarInfoMonedas(String direccion) throws NullPointerException, JsonSyntaxException {
                String json = api.obtenerDatos(direccion);
                // Deserializar el json en una instancia de clase
                Gson gson = new Gson();
                monedas = gson.fromJson(json, MonedasAdmitidasAPI.class);
                // Acceder añ atributo "supported_codes"
                List<List<String>> supportedCodes = monedas.supported_codes();
                int idMoneda = 0;
                for (List<String> listaNombreMoneda : supportedCodes) {
                        // Combinar el nombre y el código de la moneda en un único string
                        String nombreMoneda = supportedCodes.get(idMoneda).get(1) + " [" + supportedCodes.get(idMoneda).get(0) + "]";
                        // Agregar id y código de las monedas a mapa de códigos
                        codigosMonedas.put(idMoneda + 1, supportedCodes.get(idMoneda).get(0));
                        idMoneda++;
                        // Agregar id y nombre completo de las monedas a mapa de monedas
                        menuMonedas.put(idMoneda, nombreMoneda);
                }
                return menuMonedas;
        }
}