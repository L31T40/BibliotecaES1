package es1.biblioteca.Utilizadores;

public class TipoUtilizador {
    int tipo;
    int prazoEmprestimo;

    public TipoUtilizador(int tipo, int prazoEmprestimo) {
        this.tipo = tipo;
        this.prazoEmprestimo = prazoEmprestimo;
    }

    public int getTipo() {
        return tipo;
    }

    public int getPrazoEmprestimo() {
        return prazoEmprestimo;
    }
}
