package es1.biblioteca.CompraLivros;

import es1.biblioteca.Livros.QuebraLivroNaoAutorizada;
import es1.biblioteca.Utilizadores.Utilizador;

import java.time.LocalDateTime;

public class AutorizacaoPropostaCompra {
    Utilizador aprovador;
    LocalDateTime data;
    String infolivro;


    public AutorizacaoPropostaCompra(Utilizador aprovador_, String infolivro) throws PropostaCompraNaoAutorizada {

        if(aprovador_.getTipoUtilizador().getTipo() == 3)
            this.aprovador = aprovador_;
        else
            throw new PropostaCompraNaoAutorizada();

        this.infolivro = infolivro;
        this.data = LocalDateTime.now();
    }

    public String getInfolivro() {
        return infolivro;
    }
}
