package es1.biblioteca.CompraLivros;

import es1.biblioteca.Livros.Livro;
import es1.biblioteca.Utilizadores.Utilizador;

import java.time.LocalDate;

public class RequisicaoCompraCopia extends RequisicaoCompra{

    private String estado;
    private LocalDate data;
    private String oficio;
    private Livro livro;
    private Utilizador utilizador;

    public RequisicaoCompraCopia(String estado, LocalDate data, String oficio, Livro livro, Utilizador utilizador) {
        super(estado,data,oficio);

        this.estado = estado;
        this.data = data;
        this.oficio = oficio;
        this.livro=livro;
        this.utilizador=utilizador;
    }


}
