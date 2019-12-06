package es1.biblioteca.LugarSala;

import es1.biblioteca.Utilizadores.Utilizador;
import es1.biblioteca.Utilizadores.UtilizadorNaoAutorizadoExcepcao;
import es1.biblioteca.Utilizadores.UtilizadorNaoEncontradoExcepcao;

import java.util.ArrayList;
import java.util.Random;

public class Sala {
    private  int nroSala;
    private int nroLugares;

    private ArrayList<LugarSala> lugaresSala = new ArrayList<>(); // pode ter 0 lugares ( Ligação entre Lugar Sala e Sala)
    private ArrayList<Integer> lugaresDisponiveis = new ArrayList<>();
    private Random r = new Random();

    //Utilizador,

    public Sala(int nroSala, int nroLugares) {
        this.nroSala = nroSala;
        for (int i=1; i<=nroLugares;i++){
            lugaresDisponiveis.add(i);
        }
    }

    public int getNroSala() {
        return nroSala;
    }

    public void setNroSala(int nroSala) {
        this.nroSala = nroSala;
    }

    public int getNroLugares() {
        return lugaresDisponiveis.size();
    }

    public void setNroLugares(int nroLugares) {
        this.nroLugares = nroLugares;
    }

    public LugarSala addUtilizador(Utilizador utilizador) throws NaoHaLugaresExcepcao, UtilizadorNaoAutorizadoExcepcao {
        if(!utilizador.AutorizadoLeituraPresencial())//if(utilizador.AutorizadoLeituraPresencial() == false)
        {
            throw new UtilizadorNaoAutorizadoExcepcao();
        }

        if(lugaresDisponiveis.size() == 0)
            throw new NaoHaLugaresExcepcao();

        //atribui lugares de forma aleatoria ao utilizador
        int lugarAtribuir = lugaresDisponiveis.get(r.nextInt(lugaresDisponiveis.size()));

        System.out.println("Lugar atribuido:" + lugarAtribuir);
        //int lugarAtribuir = lugaresDisponiveis.get(0);

        LugarSala ls = new LugarSala(lugarAtribuir,utilizador);

        lugaresSala.add(ls);
        lugaresDisponiveis.remove(0);

        return ls;
    }

    public void delUtilizador(Utilizador utilizador) throws UtilizadorNaoEncontradoExcepcao {

        LugarSala lugarocupado = null;

        for(LugarSala l : lugaresSala)
        {
            if(l.getUtilizador() == utilizador)
            {
                lugarocupado = l;
            }
        }

        if(lugarocupado == null)
        {
            throw new UtilizadorNaoEncontradoExcepcao();
        }

        lugaresSala.remove(lugarocupado);
        lugaresDisponiveis.add(lugarocupado.getNroLugar());
    }
}
