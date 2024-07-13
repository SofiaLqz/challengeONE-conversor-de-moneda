package challengeone.conversordemoneda.modelos;

import com.google.gson.annotations.SerializedName;

public class ConversorDeMoneda {
    @SerializedName("base_code")
    private String monedaBase;
    @SerializedName("target_code")
    private String monedaDestino;
    @SerializedName("conversion_rate")
    private double tasaDeConversion;
    private double cantidad;
    private double valorFinal;

    public ConversorDeMoneda(String monedaBase, String monedaDestino, double tasaDeConversion) {
        this.monedaBase = monedaBase;
        this.monedaDestino = monedaDestino;
        this.tasaDeConversion = tasaDeConversion;
    }

    public String calcularConversion(Double cantidad){
        this.cantidad = cantidad;
        valorFinal = cantidad * tasaDeConversion;
        return "El valor " + cantidad + " [" + monedaBase + "] " +
                "corresponde al valor final de =>>> " + valorFinal +
                " [" + monedaDestino + "]";
    }
}
