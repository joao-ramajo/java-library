package models;
import models.Livro;
import java.util.ArrayList;

public class Biblioteca {
    private String nome;
    private ArrayList<String> categorias = new ArrayList<>();
    private Livro[] livros;

    public Biblioteca(String nome, Livro[] livros) {
        setLivros(livros);
        setNome(nome);
        setCategoria(livros);
    };

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    public void setCategoria(Livro[] livros) {
        for (Livro livro : livros) {
            categorias.add(livro.getCategoria());
        }

    }

    public void getAllCategorias(){
        System.out.println(this.categorias);
    }

    public void getLivros() {
        for (Livro livro : this.livros) {
            info(livro);
        }
    }


    public void getByCategoria(String categoria) {
       System.out.println("Buscando livro pela categoria: " + categoria);
       boolean existe;
       for (Livro livro : this.livros) {
            if(livro.getCategoria().equals(categoria)) {
                info(livro);
                
            }
       }
    }


    public static void info(Livro livro) { // Metodo utilizado para pegar as informaçoes completas de um livro
           System.out.println("-------------"+ livro.getTitulo() + "------------------");
            System.out.println("Titulo: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Editora: " + livro.getEditora());
            System.out.println("Paginas: " + livro.getPaginas());
            System.out.println("Categoria: " + livro.getCategoria());
            System.out.println("-------------------------------");
    }

}