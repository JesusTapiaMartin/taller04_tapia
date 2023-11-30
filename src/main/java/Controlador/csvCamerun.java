package Controlador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvCamerun {

    // ========== ATRIBUTOS ==========
    public static final String nombreArchivo = "Camerun.csv";


    // ===== LISTADO JUGADORES =====
    public static List<Object[]> listadoCamerun() {
        List<Object[]> camerunData = new ArrayList<>();

        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo));
            String linea;

            boolean primeraLinea = true;

            while ((linea = lector.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] campos = linea.split(",");

                if (campos.length >= 2) {
                    String numeroJugador    = campos[0].trim();
                    String nombreJugador    = campos[1].trim();
                    String posicionJugador  = campos[2].trim();

                    Object[] jugador = {numeroJugador, nombreJugador, posicionJugador};

                    camerunData.add(jugador);
                }
            }
            lector.close();

        } catch (IOException e) {
            System.err.println("Hubo un error al leer el archivo: " + e.getMessage());
        }

        return camerunData;
    }
}
