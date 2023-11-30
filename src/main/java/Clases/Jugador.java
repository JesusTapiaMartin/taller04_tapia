package Clases;

public class Jugador {

    // ===== ATRIBUTOS =====
    private String nombre, numero, posicion;


    // ===== CONSTRUCTOR =====
    public Jugador(String nombreJugador, String numeroJugador, String posicionJugador) {
        this.nombre      = nombreJugador;
        this.numero      = numeroJugador;
        this.posicion    = posicionJugador;
    }


    // ===== GETTER Y SETTER =====
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreJugador) {
        this.nombre = nombreJugador;
    }

    public String getNumeroJugador() {
        return numero;
    }

    public void setNumeroJugador(String numeroJugador) {
        this.numero = numeroJugador;
    }

    public String getPosicionJugador() {
        return posicion;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicion = posicionJugador;
    }
}
