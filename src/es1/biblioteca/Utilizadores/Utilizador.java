package es1.biblioteca.Utilizadores;

public class Utilizador{
  String nome;
  String estado;
  TipoUtilizador tipoUtilizador;
  boolean autorizadoLeituraPresencial;

    public Utilizador(String nome, String estado,TipoUtilizador tipoUtilizador) {
        this.nome = nome;
        this.estado = estado;
        this.tipoUtilizador=tipoUtilizador;
    }

    public String getNome() {
        return nome;
    }

    public String getEstado() {
        return estado;
    }

    public TipoUtilizador getTipoUtilizador(){
        return tipoUtilizador;
    }

    public void setAutorizacao(boolean aut)
    {
        this.autorizadoLeituraPresencial = aut;
    }

    public boolean AutorizadoLeituraPresencial()
    {
        return autorizadoLeituraPresencial;
    }
}
