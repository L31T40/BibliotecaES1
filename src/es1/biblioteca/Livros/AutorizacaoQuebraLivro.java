package es1.biblioteca.Livros;

import es1.biblioteca.Utilizadores.Utilizador;

import java.time.LocalDateTime;

public class AutorizacaoQuebraLivro {
    Utilizador utilizador;
    Copia copia;
    LocalDateTime data;

    public AutorizacaoQuebraLivro(Utilizador utilizador, Copia copia) throws QuebraLivroNaoAutorizada {
        if(utilizador.getTipoUtilizador().getTipo() == 3)
            this.utilizador = utilizador;
        else
            throw new QuebraLivroNaoAutorizada();

        this.copia = copia;
        this.data = LocalDateTime.now();
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public Copia getCopia() {
        return copia;
    }
}
