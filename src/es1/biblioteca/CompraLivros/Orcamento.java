package es1.biblioteca.CompraLivros;

import es1.biblioteca.Utilizadores.Utilizador;

public class Orcamento {
    int idOrcamento;
    PropostaAquisicao propostaAquisicao;
    Utilizador utilizador;
    float preco;

    // Utilizador tem que ser do tipo funcionario


    public Orcamento(int id, PropostaAquisicao propostaAquisicao, Utilizador utilizador, float preco) {
        this.idOrcamento = id;
        this.propostaAquisicao = propostaAquisicao;
        this.utilizador = utilizador;
        this.preco = preco;
    }

    public PropostaAquisicao getPropostaAquisicao() {
        return propostaAquisicao;
    }

    public Utilizador getUtilizador() {
        return utilizador;
    }

    public float getPreco() {
        return this.preco;
    }

    public int getIdOrcamento() {
        return idOrcamento;
    }
}
