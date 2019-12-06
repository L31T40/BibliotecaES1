package es1.biblioteca.CompraLivros;

import es1.biblioteca.Utilizadores.Utilizador;

import java.time.LocalDate;

public class PropostaAquisicao {
    private LocalDate data;
    private Utilizador utilizador;
    private String infoLivro;
    private AutorizacaoPropostaCompra autorizacao;

    public PropostaAquisicao(LocalDate data_, Utilizador utilizador, String infoLivro_, AutorizacaoPropostaCompra autorizacao_) throws PropostaCompraNaoAutorizada {
        if(autorizacao_.getInfolivro().equals(infoLivro_)) {
            this.data = data_;
            this.utilizador = utilizador;
            this.infoLivro = infoLivro_;
        }
        else
            throw new PropostaCompraNaoAutorizada();
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public void setUtilizador(Utilizador utilizador) {
        this.utilizador = utilizador;
    }

    public String getInfoLivro() {
        return infoLivro;
    }

    public void setInfoLivro(String infoLivro) {
        this.infoLivro = infoLivro;
    }
}
