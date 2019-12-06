package es1.biblioteca.Livros;

import es1.biblioteca.Livros.Livro;
import es1.biblioteca.Utilizadores.Utilizador;

import java.time.LocalDateTime;

public class QuebraLivro{

    private Copia copia;
    private LocalDateTime dataQuebra;
    private String motivoQuebra;
    private AutorizacaoQuebraLivro autorizacaoQuebraLivro;
    private Utilizador utilizador;

    public QuebraLivro(Copia copia, String motivoQuebra, AutorizacaoQuebraLivro autorizacaoQuebraLivro, Utilizador utilizador) throws QuebraLivroNaoAutorizada {
        if(autorizacaoQuebraLivro.getCopia() != copia)
            throw new QuebraLivroNaoAutorizada();

        this.copia = copia;
        this.dataQuebra = LocalDateTime.now();
        this.motivoQuebra = motivoQuebra;
        this.autorizacaoQuebraLivro = autorizacaoQuebraLivro;
        this.utilizador = utilizador;
    }

    public Copia getCopia() {
        return this.copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public LocalDateTime getDataQuebra() {
        return dataQuebra;
    }

    public void setDataQuebra(LocalDateTime dataQuebra) {
        this.dataQuebra = dataQuebra;
    }

    public String getMotivoQuebra() {
        return motivoQuebra;
    }

    public void setMotivoQuebra(String motivoQuebra) {
        this.motivoQuebra = motivoQuebra;
    }



}
