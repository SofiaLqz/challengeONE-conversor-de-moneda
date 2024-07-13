package challengeone.conversordemoneda.modelos;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ProcesarEntradaUsuario {
    private Scanner scanner = new Scanner(System.in);

    public int validarOpcion(Map<Integer, String> menu, String mensaje) {
        System.out.println(mensaje);
        int opcion = -1; // Inicializar opción con -1 para entrar en el bucle
        while (opcion != 0) {
            try {
                opcion = scanner.nextInt();
                if (opcion == 0) { // Si el usuario ingresa 0, se sale del bucle
                    break;
                }
                if (!menu.containsKey(opcion)) {
                    System.out.println("Opción no válida. Intente nuevamente:");
                } else {
                    break; // Si la opción es válida, se sale del bucle
                }
            } catch (InputMismatchException e) {
                System.out.println("El valor ingresado no es válido. Intente nuevamente:");
                scanner.next(); // Avanza el scanner para ignorar la entrada inválida
            }
        }
        return opcion;
    }

    public double validarDato(String mensaje) {
        System.out.println(mensaje);
        double valor = -1;
        while (valor != 0) {
        try {
            valor  = scanner.nextDouble();
            if (valor < 0){
                System.out.println("El valor ingresado no es válido. Intente nuevamente:");
            } else {
                break;
            }
        } catch (InputMismatchException e) {
            System.out.println("El valor ingresado no es válido. Intente nuevamente:");
            scanner.next();
        }
        }
        return valor;
    }
}