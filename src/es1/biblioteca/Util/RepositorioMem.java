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

public class RepositorioMem implements Repositorio {

    private ArrayList<Utilizador> utilizador_ = new ArrayList<Utilizador>();
    private ArrayList<TipoUtilizador> tipoutilizador_ = new ArrayList<TipoUtilizador>();
    private ArrayList<Requisicao> requisicao_ = new ArrayList<Requisicao>();
    private ArrayList<Copia> copia_ = new ArrayList<Copia>();
    private ArrayList<Livro> livro_ = new ArrayList<Livro>();
    private ArrayList<Emprestimo> emprestimo_ = new ArrayList<Emprestimo>();
    private ArrayList<Notificacao> notificacao_ = new ArrayList<Notificacao>();
    private ArrayList<Devolucao> devolucao_ = new ArrayList<Devolucao>();
    private ArrayList<Coima> coima_ = new ArrayList<Coima>();
    private ArrayList<Encomenda> encomenda_ = new ArrayList<Encomenda>();
    private ArrayList<EntradaNovoLivro> entradanovolivro_ = new ArrayList<EntradaNovoLivro>();
    private ArrayList<PropostaAquisicao> proposta_ = new ArrayList<PropostaAquisicao>();
    private ArrayList<RequisicaoCompra> requisicaocompra_ = new ArrayList<RequisicaoCompra>();
    private ArrayList<QuebraLivro> quebralivro_ = new ArrayList<QuebraLivro>();
    private ArrayList<Orcamento> orcamento_ = new ArrayList<Orcamento>();

    public RepositorioMem() {
    }

    public void adicionaCoima(Coima coima) {
        this.coima_.add(coima);
    }

    public void adicionaCopia(Copia copia) {
        this.copia_.add(copia);
    }

    public void adicionaDevolucao(Devolucao devolucao) {
        this.devolucao_.add(devolucao);
    }

    public void adicionaEmprestimo(Emprestimo emprestimo) {
        this.emprestimo_.add(emprestimo);
    }

    public void adicionaEncomenda(Encomenda encomenda) {
        this.encomenda_.add(encomenda);
    }

    public void adicionaEntradaNovoLivro(EntradaNovoLivro entradanovolivro) {
        this.entradanovolivro_.add(entradanovolivro);
    }

    public void adicionaLivro(Livro livro) {
        this.livro_.add(livro);
    }

    public void adicionaNotificacao(Notificacao notificacao) {
        this.notificacao_.add(notificacao);
    }

    public void adicionaPropostaRequisicao(PropostaAquisicao proposta) {
        this.proposta_.add(proposta);
    }

    public void adicionaRequisicao(Requisicao requisicao) {
        this.requisicao_.add(requisicao);
    }

    public void adicionaRequisicaoCompra(RequisicaoCompra requisicaoCompra) {
        this.requisicaocompra_.add(requisicaoCompra);
    }


    public void adicionaUtilizador(Utilizador utilizador) {
        this.utilizador_.add(utilizador);
    }

    public void adicionaTipoUtilizador(TipoUtilizador tipo) {
        this.tipoutilizador_.add(tipo);
    }

    public void adicionaOrcamento(Orcamento orcamento)
    {
        orcamento_.add(orcamento);
    }


    public Emprestimo devolveEmprestimoDaRequisicao(Requisicao r) {


        for (Emprestimo e : this.emprestimo_) {
            if (e.getRequisicao() == r)
                return e;
        }
        return null;
    }

    public void adicionaQuebraLivro(QuebraLivro ql) {


        quebralivro_.add(ql);
    }

    public void retiraCopiaRepositorio(Copia l) throws repositorioLivroVazioExcepcao, livroNaoEncontrado {
        if(livro_.isEmpty())
            throw new repositorioLivroVazioExcepcao();

        for(Livro livro: this.livro_){
            if(livro.getTitulo()== l.getLivro().getTitulo()){
                livro_.remove(livro);
                return ;//livro removido com sucesso
            }
        }
        throw new livroNaoEncontrado();
    }

/* Devolve os orçamentos para um determinado infoLivro,
ou um ArrayList vazio, se nao existirem */
public ArrayList<Orcamento> obtemOrcamentosporinfoLivro(String infolivro)
{
    ArrayList<Orcamento> listOrcamentos = new ArrayList<Orcamento>();

    for(Orcamento o : this.orcamento_)
    {
        if(o.getPropostaAquisicao().getInfoLivro() == infolivro)
            listOrcamentos.add(o);
    }

    return listOrcamentos;
}

/* Devolve a primeira cópia que encontrar, através do nome do livro */
public Copia obtemCopiaByTitulo(String titulo) {

    for(Copia c : copia_)
    {
        if(c.getLivro().getTitulo() == titulo)
            return c;
    }

    return null;
}
}