package es1.biblioteca.CompraLivros;

import es1.biblioteca.Util.Repositorio;
import org.omg.CORBA.RepositoryIdHelper;

import java.util.ArrayList;

public class VerificaOrcamento {


    public static Orcamento verificar(Repositorio repo, String infoLivro){
        float valoraComparar = 0;
        Orcamento orcamentoescolhido = null;
        ArrayList<Orcamento> listaOrcamentos;

        listaOrcamentos = repo.obtemOrcamentosporinfoLivro(infoLivro);

        if(listaOrcamentos.size() == 0)
            return null;



        for(Orcamento o : listaOrcamentos)
        {
            if(valoraComparar == 0) {
                valoraComparar = o.getPreco();
                orcamentoescolhido = o;
            }else if(valoraComparar > o.getPreco())
            {
                valoraComparar = o.getPreco();
                orcamentoescolhido = o;
            }
        }

        return orcamentoescolhido;

    }
}
