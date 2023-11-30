package Vista;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class GuiEquipoTest {

    @Test
    public void testObtenerEquipoSeleccionado() {
        guiEquipo ventana = new guiEquipo();

        ventana.getRdoAlemania().setSelected(true);
        assertEquals("Alemania", ventana.obtenerEquipoSeleccionado());

        ventana.getRdoAustralia().setSelected(true);
        assertEquals("Australia", ventana.obtenerEquipoSeleccionado());

        assertFalse(ventana.getRdoCamerun().isSelected() || ventana.getRdoChile().isSelected());
        assertNull(ventana.obtenerEquipoSeleccionado());
    }


    @Test
    public void testObtenerJugadoresSegunEquipo() {
        guiEquipo ventana = new guiEquipo();

        List<Object[]> jugadoresAlemania = ventana.obtenerJugadoresSegunEquipo("Alemania");
        assertNotNull(jugadoresAlemania);
        assertFalse(jugadoresAlemania.isEmpty());

        List<Object[]> jugadoresNoExistente = ventana.obtenerJugadoresSegunEquipo("NoExistente");
        assertNotNull(jugadoresNoExistente);
        assertTrue(jugadoresNoExistente.isEmpty());
        }
    }
