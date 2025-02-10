package models;
import models.Livro;

public class Biblioteca {
    private String nome;
    private Livro[] livros;

    public Biblioteca(String nome, Livro[] livros) {
        setLivros(livros);
        setNome(nome);
    };

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    public void getLivros() {
        for (Livro livro : this.livros) {
            // System.out.println(livro.getTitulo());
            System.out.println("-------------"+ livro.getTitulo() + "------------------");
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Paginas: " + livro.getPaginas());
            System.out.println("-------------------------------");
        }
    }

}