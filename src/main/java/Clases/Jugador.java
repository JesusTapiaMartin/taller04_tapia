package Clases;

public class Jugador {

    // ===== ATRIBUTOS =====
    private String numero,nombre, posicion;


    // ===== CONSTRUCTOR =====
    public Jugador(String numero, String nombre, String posicion) {
        this.numero     = numero;
        this.nombre     = nombre;
        this.posicion   = posicion;
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
