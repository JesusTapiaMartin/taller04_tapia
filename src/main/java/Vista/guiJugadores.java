package Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class guiJugadores extends JDialog {
    private JPanel  panelJugadores;
    private JTable  tblListado;
    private JButton btnEditar;
    private JButton btnGuardar;
    private JButton btnVolver;
    private JLabel  lblFormacion;


    // ===== CONSTRUCTOR =====
    public guiJugadores(List<Object[]> jugadores){
        setModal(true);
        setTitle("JUGADORES");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setContentPane(panelJugadores);
        cargarListadoJugadores(jugadores);


        // ===== BOTÓN SALIR =====
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }



    // ========== CARGAR LISTADO JUGADORES ==========
    private void cargarListadoJugadores(List<Object[]> jugadoresData) {
        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        // Definir las columnas
        String[] columnas = {"Número", "Nombre", "Posición"};
        modelo.setColumnIdentifiers(columnas);

        // Agregar los datos al modelo
        for (Object[] rowData : jugadoresData) {
            modelo.addRow(rowData);
        }

        // Establecer el modelo en la tabla
        tblListado.setModel(modelo);
    }
}
