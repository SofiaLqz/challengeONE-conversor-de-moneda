package challengeone.conversordemoneda.modelos;

import java.util.Map;

public class Menu {
    public static void imprimirMenu(Map<Integer, String> menuOpciones, String mensajeBienvenida){
        System.out.printf("""
                        ************************************************************
                                ********************************************
                                %s
                                ********************************************
                                        
                        --------------------------Opciones--------------------------
                        """, mensajeBienvenida);
        for (Integer clave : menuOpciones.keySet()) {
            String valor = menuOpciones.get(clave);
            System.out.println(clave + ") " + valor);
        }
        System.out.println("0)  Salir");
        System.out.println("""
                                
                        ------------------------------------------------------------
                        ************************************************************
                                
                        """);
    }
}
