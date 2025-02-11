package src.models;
import src.models.Livro;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    private String nome;
    private Set<String> categorias = new HashSet<>();
    private Livro[] livros;
    private int quantidade_livros;

    public Biblioteca(String nome, Livro[] livros) {
        this.setNome(nome);
        this.setLivros(livros);
        this.setCategorias(livros);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLivros(Livro[] livros) {
        this.livros = livros;

        for(Livro livro : livros) {
            this.quantidade_livros++;
        }
    }

    public void setCategorias(Livro[] livros) {
        for(Livro livro : livros) {
            categorias.add(livro.getCategoria());
        }
    }

    public String getNome(){
        return this.nome;
    }

    public Set<String> getCategorias() {
        return this.categorias;
    }

    public Livro[] getLivros() {
        return this.livros;
    }

    public int getQuantidadeLivros() {
        return this.quantidade_livros;
    }

    public void getInfo() {
        System.out.println("Editora: " + this.getNome());
        System.out.println("Quantidade de livros cadastrados: " + this.getQuantidadeLivros());
    }



    public void getByCategoria(String categoria) {

        for(Livro livro : this.getLivros()) {
            if(livro.getCategoria().equals(categoria)) {
                this.info(livro);
            }
        }
    }

    public void getByAutor(String autor) {
        for(Livro livro : this.getLivros()) {
            if(livro.getAutor().equals(autor)) {
                this.info(livro);
            }
        }
    }

    public void getAllLivros() {
        for (Livro livro : this.getLivros()) {
            info(livro);
        }
    }

    public Set<String> getAllAutores() {
        Set<String> autores = new HashSet<>();

        for(Livro livro : this.getLivros()) {
            autores.add(livro.getAutor());
        }

        return autores;
    }

    public void info(Livro livro) { // Metodo utilizado para pegar as informaçoes completas de um livro
        System.out.println("-------------"+ livro.getTitulo() + "------------------");
        System.out.println("Titulo: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor());
        System.out.println("Editora: " + livro.getEditora());
        System.out.println("Paginas: " + livro.getPaginas());
        System.out.println("Categoria: " + livro.getCategoria());
        System.out.println("-------------------------------");
    }




}
