package src.models;
import src.models.Biblioteca;
import src.models.Livro;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class Controller {
    private boolean status;
    private Biblioteca biblioteca;
    private Scanner scanner = new Scanner(System.in);
    private String separador = "----------";
    private void br(){
        for(int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }

    public Controller(Biblioteca biblioteca) {
        setStatus(true);
        setBiblioteca(biblioteca);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
    public boolean getStatus() {
        return this.status;
    }

    public Biblioteca getBiblioteca() {
        return this.biblioteca;
    }

    public void fim() {
        System.out.print("Digite ok para continuar: ");
        scanner.next();
    }
    public void index() {
        br();

        while(status) {
            System.out.println(separador+this.biblioteca.getNome()+separador);

            System.out.println("[0] Sair\n[1] Informações sobre a biblioteca \n[2] Livros Cadastrados \n[3] Buscar por Categoria \n[4] Buscar por autor \n[5] Adicionar Livro \n[6] gerar .JSON de todos os livros");

            System.out.print("Escolha uma opção: ");
            int esc = scanner.nextInt();


            while(esc < 0 || esc >= 7){
                System.out.print("Escolha uma opção válida: ");
                esc = scanner.nextInt();
            }

            br();
            switch(esc) {
                case 0:
                    this.setStatus(false);
                    System.out.println("Sistema desenvolvido por LacamJC");
                    System.out.println("Documentação: https://github.com/LacamJC/Bookshelf_with_java");
                    break;
                case 1:
                    this.getBiblioteca().menuBiblioteca();
                    fim();
                    br();
                    break;

                case 2:
                    this.getBiblioteca().getAllLivros();
                    fim();
                    br();
                    break;

                case 3:
                    this.menuCategoria();
                    fim();
                    br();
                    break;

                case 4:
                    this.menuAutor();
                    fim();
                    br();
                    break;

                case 5:
                    this.menuAdicionarLivro();
                    fim();
                    br();
                    break;

                case 6:
                    this.getJsonAllLivros();
                    System.out.println("O arquivo 'livros.json' sera gerado ao finalizar esta aplicação.");
                    fim();
                    br();
                    break;

            }

        }
    }

    public void menuCategoria() {
        br();
        System.out.println(separador+" CATEGORIAS "+separador);
        int qtd_categorias = 0;

        for(String categoria : this.getBiblioteca().getCategorias()) {
            System.out.println("["+qtd_categorias+"] "+categoria);
            qtd_categorias++;
        }
        System.out.print("Selecione uma categoria: ");
        int categoria = scanner.nextInt();
        while(categoria < 0 || categoria >= 6){
            System.out.print("Selecione uma opção válida: ");
            categoria = scanner.nextInt();
        }
        ArrayList<String> array_categorias = new ArrayList<>(this.getBiblioteca().getCategorias());

        br();
        this.getBiblioteca().getByCategoria(array_categorias.get(categoria));

    }

    public void menuAutor() {
        br();

        System.out.println(separador+" AUTORES "+separador);

        int qtd_autores = 0;

        for(String autor : this.getBiblioteca().getAllAutores()) {
            System.out.println("["+qtd_autores+"] "+autor);
            qtd_autores++;
        }

        System.out.println("Escolha o autor: ");
        int autor = scanner.nextInt();
        while(autor < 0 || autor >= 10){
            System.out.print("Escolha uma opção válida: ");
            autor = scanner.nextInt();
        }

        ArrayList<String> autores = new ArrayList<>(this.getBiblioteca().getAllAutores());
        this.getBiblioteca().getByAutor(autores.get(autor));
    }

    public void menuAdicionarLivro(){


        System.out.println(separador+" Adicionar Livro "+separador);
        System.out.println("======= Exemplo =======");
        System.out.println("Titulo: Clean Code");
        System.out.println("Categoria: Programação");
        System.out.println("Editora: Brasileira");
        System.out.println("Autor: Carlos Azevedo");
        System.out.println("========================");

        String titulo;

        System.out.print("Titulo: ");
        do {
            titulo = scanner.nextLine();
        }while(titulo.isEmpty());


        String categoria;
        System.out.print("Categoria: ");
        do{
            categoria = scanner.nextLine();
        }while(categoria.isEmpty());



        System.out.print("Editora: ");
        String editora;
        do{
            editora = scanner.nextLine();
        }while(editora.isEmpty());




        System.out.print("Autor: ");
        String autor;
        do{
            autor = scanner.nextLine();
        }while(autor.isEmpty());


        System.out.print("Quantidade de paginas: ");
        int paginas;
        do{
            paginas = scanner.nextInt();
        }while(paginas < 0);




        System.out.println(separador+" Verifique os dados "+separador);
        Livro novo_livro = new Livro(titulo, categoria, editora, autor, paginas);
//
        novo_livro.getInfo();

        System.out.println("[0] As informações estão corretas");
        System.out.println("[1] As informações não estão corretas");
        System.out.print("Selecione uma opção: ");
        int input = scanner.nextInt();

        switch(input) {
            case 0:
                this.getBiblioteca().addLivro(novo_livro);
                return;
            case 1:
                return;
            default:
                return;
        }
    }

    public void getJsonAllLivros() {
        List<Livro> livros = new ArrayList<>();

        for(Livro livro : this.getBiblioteca().getLivros()) {
            livros.add(livro);
        }

        Gson gson = new Gson();

        try{
            FileWriter writer = new FileWriter("livrosAll.json");
            gson.toJson(livros, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
