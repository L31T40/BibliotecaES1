package es1.biblioteca.Livros;

public class Livro{
    private  String titulo;
    private String editora;



    public Livro(String titulo, String editora) {
        this.titulo = titulo;
        this.editora = editora;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getTitulo() {

        return titulo;
    }

    public String getEditora() {

        return editora;
    }
}
