package es1.biblioteca.CompraLivros;

import java.time.LocalDate;

public abstract class RequisicaoCompra {
    private String estado;
    private LocalDate data;
    private String oficio;


    public RequisicaoCompra(String estado, LocalDate data, String oficio) {
        this.estado = estado;
        this.data = data;
        this.oficio = oficio;
    }



    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }
}
