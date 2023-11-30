package Vista;

import Controlador.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class guiEquipo extends JFrame {
    private JPanel panelEquipo;
    public JRadioButton rdoAlemania;
    public JRadioButton rdoAustralia;
    public JRadioButton rdoCamerun;
    public JRadioButton rdoChile;
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

        // ===== AGREGAR ITEM LISTENER A LOS RADIOBUTTONS =====
        rdoAlemania.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cargarBanderaSegunEquipo("Alemania");
                }
            }
        });

        rdoAustralia.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cargarBanderaSegunEquipo("Australia");
                }
            }
        });

        rdoCamerun.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cargarBanderaSegunEquipo("Camerun");
                }
            }
        });

        rdoChile.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    cargarBanderaSegunEquipo("Chile");
                }
            }
        });

    }



    // ===== OBTENER EQUIPO SELECCIONADO =====
    public String obtenerEquipoSeleccionado() {
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

    private void cargarBanderaSegunEquipo(String equipo) {
        String nombreArchivo    = "bandera" + equipo + ".png";
        String rutaImagen       = nombreArchivo;

        try {
            InputStream inputStream = getClass().getResourceAsStream(rutaImagen);
            if (inputStream != null) {
                ImageIcon icono = new ImageIcon(ImageIO.read(inputStream));
                lblImagen.setIcon(icono);
            } else {
                System.err.println("No se pudo encontrar el archivo: " + rutaImagen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public JRadioButton getRdoAlemania() {
        return rdoAlemania;
    }

    public void setRdoAlemania(JRadioButton rdoAlemania) {
        this.rdoAlemania = rdoAlemania;
    }

    public JRadioButton getRdoAustralia() {
        return rdoAustralia;
    }

    public void setRdoAustralia(JRadioButton rdoAustralia) {
        this.rdoAustralia = rdoAustralia;
    }

    public JRadioButton getRdoCamerun() {
        return rdoCamerun;
    }

    public void setRdoCamerun(JRadioButton rdoCamerun) {
        this.rdoCamerun = rdoCamerun;
    }

    public JRadioButton getRdoChile() {
        return rdoChile;
    }

    public void setRdoChile(JRadioButton rdoChile) {
        this.rdoChile = rdoChile;
    }
}