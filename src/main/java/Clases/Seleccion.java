package Clases;

public class Seleccion {

    // ===== ATRIBUTOS =====
    private String nombreOrigen, ranking;


    // ===== CONSTRUCTOR =====
    public Seleccion(String nombreOrigen, String ranking) {
        this.nombreOrigen   = nombreOrigen;
        this.ranking        = ranking;
    }


    // ===== GETTER Y SETTER =====
    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
}
