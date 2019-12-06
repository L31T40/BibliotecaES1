package es1.biblioteca.CompraLivros;

import java.time.LocalDate;

public class Encomenda {
    private  LocalDate data;
    private RequisicaoCompra requisicao;

    public Encomenda(LocalDate data, RequisicaoCompra requisicao) {
        this.data = data;
        this.requisicao = requisicao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public RequisicaoCompra getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(RequisicaoCompra requisicao) {
        this.requisicao = requisicao;
    }
}
