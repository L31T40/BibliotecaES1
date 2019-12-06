package es1.biblioteca.Util;

import es1.biblioteca.CompraLivros.*;
import es1.biblioteca.Emprestimos.*;
import es1.biblioteca.Livros.Copia;
import es1.biblioteca.Livros.Livro;
import es1.biblioteca.Livros.livroNaoEncontrado;
import es1.biblioteca.Livros.QuebraLivro;
import es1.biblioteca.Utilizadores.TipoUtilizador;
import es1.biblioteca.Utilizadores.Utilizador;

import java.util.ArrayList;

/*interface public para aceder fora do package*/
public interface Repositorio {

    public void adicionaCoima(Coima coima);

    public void adicionaCopia(Copia copia);

    public void adicionaDevolucao(Devolucao devolucao);

    public void adicionaEncomenda(Encomenda encomenda);

    public void adicionaEmprestimo(Emprestimo emprestimo);

    public void adicionaEntradaNovoLivro(EntradaNovoLivro entradanovolivro);

    public void adicionaLivro(Livro livro);

    public void adicionaNotificacao(Notificacao notificacao);

    public void adicionaPropostaRequisicao(PropostaAquisicao proposta);

    public void adicionaRequisicao(Requisicao requisicao);

    public void adicionaRequisicaoCompra(RequisicaoCompra requisicaoCompra);

    public void adicionaUtilizador(Utilizador utilizador);

    public void adicionaTipoUtilizador(TipoUtilizador tipo);

    public Emprestimo devolveEmprestimoDaRequisicao(Requisicao r);

    public void adicionaQuebraLivro(QuebraLivro ql);

    public void retiraCopiaRepositorio(Copia l) throws repositorioLivroVazioExcepcao, livroNaoEncontrado;

    public void adicionaOrcamento(Orcamento orcamento);

    public ArrayList<Orcamento> obtemOrcamentosporinfoLivro(String infolivro);

    public Copia obtemCopiaByTitulo(String titulo);

}
