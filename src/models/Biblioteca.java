package src.models;
import src.models.Livro;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    private String nome;
    private Set<String> categorias = new HashSet<>();
    private List<Livro> livros = new ArrayList<>();
    private int quantidade_livros;

    public Biblioteca(String nome) {
        this.setNome(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setLivros(Livro livro) {
        this.livros.add(livro);
    }

    public void setCategorias(Livro livro) {
        this.categorias.add(livro.getCategoria());
    }

    public void addLivro(Livro livro) {
        this.setLivros(livro);
        this.setCategorias(livro);
    }

    public String getNome(){
        return this.nome;
    }

    public Set<String> getCategorias() {
        return this.categorias;
    }

    public List<Livro> getLivros() {
        return this.livros;
    }

    public int getQuantidadeLivros() {
        return this.quantidade_livros;
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

    public void getInfo() {
        System.out.println("------------- "+this.getNome()+" -------------");
        System.out.println("Quantidade de livros cadastrados: " + this.getLivros().size());
        System.out.println("Autores cadastrados: " + this.getAllAutores());
    }

    public void menuBiblioteca() {
        System.out.println("------------- "+this.getNome()+" -------------");
        System.out.println("Livros Cadastrados: " + this.getLivros().size());
        System.out.println("Autores Cadastrados: " + this.getAllAutores().size());
        System.out.println("Categorias: " + this.getCategorias());
    }



}
