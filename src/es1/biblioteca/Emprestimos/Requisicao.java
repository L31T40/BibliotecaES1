package es1.biblioteca.Emprestimos;

import java.time.LocalDate;
import es1.biblioteca.Utilizadores.Utilizador;
import es1.biblioteca.Livros.Copia;


public class Requisicao {
    private LocalDate data;
    private Utilizador utilizador;
    private Copia copia;

    public Requisicao(LocalDate data, Utilizador utilizador, Copia copia) {
        this.data = data;
        this.utilizador = utilizador;
        this.copia = copia;
    }

    public LocalDate getData() {
        return data;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public Copia getCopia() {
        return copia;
    }
}
