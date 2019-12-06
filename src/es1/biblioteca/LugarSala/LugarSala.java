package es1.biblioteca.LugarSala;

import es1.biblioteca.Utilizadores.Utilizador;

public class LugarSala {
    private int nroLugar;
    private Utilizador utilizador;

    public LugarSala(int nroLugar, Utilizador utilizador) {
        this.nroLugar = nroLugar;
        this.utilizador = utilizador;
    }

    public int getNroLugar() {
        return nroLugar;
    }

    public void setNroLugar(int nroLugar) {
        this.nroLugar = nroLugar;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }
}
