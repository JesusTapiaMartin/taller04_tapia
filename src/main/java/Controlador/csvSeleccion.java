package Controlador;

import Clases.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csvSeleccion {

    // ========== ATRIBUTOS ==========
    public static final String nombreArchivo = "Chile.csv";



    // ===== LISTADO SELECCIONES =====
    public static List<Object[]> listadoSelecciones() {
        List<Object[]> seleccionesData = new ArrayList<>();

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
                    String nombreSeleccion  = campos[0].trim();
                    String rankingSeleccion = campos[1].trim();
                }
            }
            lector.close();

        } catch (IOException e) {
            System.err.println("Hubo un error al leer el archivo: " + e.getMessage());
        }

        return seleccionesData;
    }
}
