package Vista;

import Controlador.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class guiEquipo extends JFrame {
    private JPanel panelEquipo;
    private JRadioButton rdoAlemania;
    private JRadioButton rdoAustralia;
    private JRadioButton rdoCamerun;
    private JRadioButton rdoChile;
    private JLabel lblSeleccioneEquipo;
    private JLabel lblRanking;
    private JLabel lblImagen;
    private JButton btnJugadores;
    private JButton btnSalir;
    private ButtonGroup grupoBotonesSeleccion;

    // ===== CONSTRUCTOR =====
    public guiEquipo() {
        // ===== GRUPO DE BOTONES =====
        grupoBotonesSeleccion = new ButtonGroup();
        ButtonGroup grupoBotonesGenero = new ButtonGroup();
        grupoBotonesGenero.add(rdoAlemania);
        grupoBotonesGenero.add(rdoAustralia);
        grupoBotonesGenero.add(rdoCamerun);
        grupoBotonesGenero.add(rdoChile);

        // ===== PROPIEDADES =====
        setTitle("SELECCIONES");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setContentPane(panelEquipo);

        // ===== BOTÓN SALIR =====
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // ===== BOTÓN JUGADORES =====
        btnJugadores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipoSeleccionado = obtenerEquipoSeleccionado();

                if (equipoSeleccionado != null) {
                    // Obtener jugadores según el equipo seleccionado
                    List<Object[]> jugadores = obtenerJugadoresSegunEquipo(equipoSeleccionado);

                    // Crear y mostrar la ventana de jugadores
                    guiJugadores ventanaJugadores = new guiJugadores(jugadores);
                    ventanaJugadores.setSize(800, 600);
                    ventanaJugadores.setLocationRelativeTo(null);
                    ventanaJugadores.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona un equipo.");
                }
            }
        });
    }



    // ===== OBTENER EQUIPO SELECCIONADO =====
    private String obtenerEquipoSeleccionado() {
        if (rdoAlemania.isSelected()) {
            return "Alemania";
        } else if (rdoAustralia.isSelected()) {
            return "Australia";
        } else if (rdoCamerun.isSelected()) {
            return "Camerun";
        } else if (rdoChile.isSelected()) {
            return "Chile";
        } else {
            return null;
        }
    }


    // ===== OBTENER JUGADORES SEGUN EQUIPO =====
    private List<Object[]> obtenerJugadoresSegunEquipo(String equipo) {
        switch (equipo) {
            case "Alemania":
                return csvAlemania.listadoAlemania();
            case "Australia":
                return csvAustralia.listadoAustralia();
            case "Camerun":
                return csvCamerun.listadoCamerun();
            case "Chile":
                return csvChile.listadoChile();
            default:
                return new ArrayList<>();
        }
    }
}