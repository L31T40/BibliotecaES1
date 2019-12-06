package es1.biblioteca.Livros;

import es1.biblioteca.Livros.Livro;

public class Copia{
    private  int id;
    private Livro livro;

    public Copia(int id, Livro livro) {
        this.id = id;
        this.livro = livro;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }
}
