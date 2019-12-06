package es1.biblioteca;

import es1.biblioteca.CompraLivros.*;
import es1.biblioteca.Livros.*;
import es1.biblioteca.LugarSala.LugarSala;
import es1.biblioteca.LugarSala.NaoHaLugaresExcepcao;
import es1.biblioteca.LugarSala.Sala;
import es1.biblioteca.Util.repositorioLivroVazioExcepcao;
import es1.biblioteca.Utilizadores.UtilizadorNaoAutorizadoExcepcao;
import es1.biblioteca.Util.Repositorio;
import es1.biblioteca.Util.RepositorioMem;
import es1.biblioteca.Utilizadores.TipoUtilizador;
import es1.biblioteca.Utilizadores.Utilizador;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class Main {
private static final int ALUNO = 0;
private static final int DOCENTE = 1;
private static final int FUNCIONARIO = 2;
private static final int RESPONSAVEL = 3;
private static final int ADMINISTRATIVO = 4;



    public static void main(String args[]) throws PropostaCompraNaoAutorizada {

        Repositorio repo = new RepositorioMem();

        int idLivro=0;

        //Livros já existentes na Biblioteca - para servir de exemplo.
        System.out.println("-------------A adicionar livros-------------");
        Livro livro1 = new Livro("Programar em Java", "FCA");
        System.out.println("Livro adicionado:");
        System.out.println("    " + livro1.getTitulo() + "; Editora: " + livro1.getEditora());
        //Adição do Livro ao Repositorio
        repo.adicionaLivro(livro1);
        System.out.println("-------------Livro adicionado ao repositório-------------");
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("-------------A adicionar copias do livro criado-------------");
        Copia c0 = new Copia(idLivro++, livro1);//Adiciona uma copia de cada vez
        System.out.println("Copia c0 com id: " + c0.getId() + "; Livro: " + c0.getLivro().getTitulo() + "; Editora: " + c0.getLivro().getEditora());
        Copia c1 = new Copia(idLivro++, livro1);
        System.out.println("Copia c1 com id: " + c1.getId() + "; Livro: " + c1.getLivro().getTitulo() + "; Editora: " + c1.getLivro().getEditora());
        repo.adicionaCopia(c0);
        repo.adicionaCopia(c1);

        System.out.println("-------------Cópias adicionadas ao repositorio-------------");
        Livro livro2 = new Livro("Programar em C", "Porto Editora");
        repo.adicionaLivro(livro2);
        Copia c2 = new Copia(idLivro++, livro2);
        Copia c3= new Copia(idLivro++, livro2);
        repo.adicionaCopia(c2);
        repo.adicionaCopia(c3);


        Livro livro3 = new Livro("O Livro Vermelho das Vendas", "Editora Esquina");
        repo.adicionaLivro(livro3);
        Copia c4 = new Copia(idLivro++, livro3);
        Copia c5= new Copia(idLivro++, livro3);
        repo.adicionaCopia(c4);
        repo.adicionaCopia(c5);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------Foram criados mais livros e cópias em Background-------------");



        // Tipo de utilizador
        TipoUtilizador aluno = new TipoUtilizador(ALUNO,10);
        TipoUtilizador docente = new TipoUtilizador(DOCENTE,20);
        TipoUtilizador funcionario = new TipoUtilizador(ALUNO,0);
        TipoUtilizador responsavel = new TipoUtilizador(RESPONSAVEL,0);

        //Criação de Utilizadores

        Utilizador oAluno = new Utilizador("Jorge","Ativo", aluno);
        oAluno.setAutorizacao(true);
        Utilizador oDocente = new Utilizador("Tiago","Ativo", docente);
        Utilizador oFuncionario = new Utilizador("Gil","Ativo", funcionario);
        Utilizador oResponsavel = new Utilizador("Pedro Martins","Ativo", responsavel);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------------Utilizadores existentes:-------------");

        System.out.println("Aluno: " + oAluno.getNome());
        System.out.println("Docente: " + oDocente.getNome());
        System.out.println("Funcionário: " + oFuncionario.getNome());
        System.out.println("Responsável: " + oResponsavel.getNome());

        System.out.println();
        System.out.println();
        System.out.println();
        //Proposta de Aquisição
        try {
            PropostaAquisicao propostaAquisicao = new PropostaAquisicao(LocalDate.now(),oFuncionario,"Alice no Pais das Maravilhas", new AutorizacaoPropostaCompra(oResponsavel,"Alice no Pais das Maravilhas"));
        } catch (PropostaCompraNaoAutorizada propostaCompraNaoAutorizada) {
            propostaCompraNaoAutorizada.printStackTrace();
        }






        /* Atribuir lugares */
        System.out.println("-------------Vamos atribuir lugares a utilizadores:-------------");
        Sala s = new Sala(1,100);

        System.out.println("Sala: " + s.getNroSala() + "; lugares disponiveis: " + s.getNroLugares());

        try {
            LugarSala ls = s.addUtilizador(oAluno);
            System.out.println("    Utilizador " + ls.getUtilizador().getNome() + " adicionado à sala " + s.getNroSala());
        }
        catch(UtilizadorNaoAutorizadoExcepcao|NaoHaLugaresExcepcao e)
        {
            e.printStackTrace();
        }

        System.out.println("Sala: " + s.getNroSala() + "; lugares disponiveis: " + s.getNroLugares());


        Copia paraEliminar = repo.obtemCopiaByTitulo("O Livro Vermelho das Vendas");

        if(paraEliminar != null) {
            try {
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println("---------Vamos fazer quebra do livro : " + paraEliminar.getLivro().getTitulo() + "---------");
                AutorizacaoQuebraLivro autorizacaoQuebraLivro = new AutorizacaoQuebraLivro(oResponsavel, paraEliminar);
                QuebraLivro q = new QuebraLivro(paraEliminar,"Capa completamente descolada",autorizacaoQuebraLivro,oFuncionario);

                System.out.println("Quebra Registada!");
                System.out.println("Motivo: " +  q.getMotivoQuebra());


                repo.adicionaQuebraLivro(q);
                repo.retiraCopiaRepositorio(paraEliminar);
            } catch (QuebraLivroNaoAutorizada quebraLivroNaoAutorizada) {
                quebraLivroNaoAutorizada.printStackTrace();
            } catch (es1.biblioteca.Livros.livroNaoEncontrado livroNaoEncontrado) {
                livroNaoEncontrado.printStackTrace();
            } catch (es1.biblioteca.Util.repositorioLivroVazioExcepcao repositorioLivroVazioExcepcao) {
                repositorioLivroVazioExcepcao.printStackTrace();
            }


        }

        /* Fazer proposta de aquisição */



        AutorizacaoPropostaCompra autoriz = new AutorizacaoPropostaCompra(oResponsavel,"O Livro da Selva");

        PropostaAquisicao proposta = new PropostaAquisicao(LocalDate.parse("2019-07-09"),oFuncionario,"O Livro da Selva",autoriz);

        System.out.println("----------Proposta de compra----------");
        System.out.println("Informacao do livro: " + proposta.getInfoLivro());
        System.out.println("Data da proposta: "  + proposta.getData());
        System.out.println("Utilizador: " + proposta.getUtilizador().getNome());

        System.out.println("");
        System.out.println("----------Análise dos orçamentos----------");


        Orcamento o1 = new Orcamento(1,proposta,oFuncionario,234.00F);
        Orcamento o2 = new Orcamento(2,proposta,oFuncionario,456.00F);
        Orcamento o3 = new Orcamento(3,proposta,oFuncionario,567.00F);

        System.out.println("Orcamento 1: " + o1.getPreco());
        System.out.println("Orcamento 2: " + o2.getPreco());
        System.out.println("Orcamento 3: " + o3.getPreco());

        repo.adicionaOrcamento(o1);
        repo.adicionaOrcamento(o2);
        repo.adicionaOrcamento(o3);

        Orcamento orcamentoescolhido = VerificaOrcamento.verificar(repo,"O Livro da Selva");

        System.out.print("Orcamento escolhido: " + orcamentoescolhido.getPreco());


        /* Fazer requisicao de compra */
        RequisicaoCompraCopia requisicaoCompraCopia = new RequisicaoCompraCopia("pendente", LocalDate.now(), "Oficio",livro1,oFuncionario);
        Encomenda encomenda = new Encomenda(LocalDate.now(),requisicaoCompraCopia);


        /* Dar entrada do livro */



        //CompraLivros de NOVO LIVRO
        Livro livrocompra1= new Livro("Portugal à Rasca", "Lisboa Editora");
        Copia lc0= new Copia(idLivro++,livrocompra1);
        EntradaNovoLivro entradaNovoLivro = new EntradaNovoLivro(LocalDate.now(),encomenda,lc0);





        //... adicionar ao repositório

        repo.adicionaLivro(livrocompra1);
        repo.adicionaCopia(lc0);

        repo.adicionaEntradaNovoLivro(entradaNovoLivro);




    }
}

