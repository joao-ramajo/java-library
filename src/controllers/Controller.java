package src.controllers;
import src.factories.LivroFactory;
import src.models.Biblioteca;
import src.models.Livro;
import src.controllers.UserController;
import src.models.User;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;
import java.io.FileWriter;

public class Controller {
    private boolean status;
    private Biblioteca biblioteca;
    private Scanner scanner = new Scanner(System.in);
    private String separador = "----------";
    private UserController userController = new UserController();
    private LivroFactory livroFactory = new LivroFactory();
    private void br(){
        for(int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }

    public Controller(Biblioteca biblioteca) {
        this.setStatus(true);
        this.setBiblioteca(biblioteca);
        this.injectData();
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
            System.out.println("TESTE");

//            System.out.println("[0] Sair\n[1] Informações sobre a biblioteca \n[2] Livros Cadastrados \n[3] Buscar por Categoria \n[4] Buscar por autor \n[5] Adicionar Livro \n[6] gerar .JSON de todos os livros \n[7] Menu do usuario");
            String[] opcoes = {"[0] Sair ","[1] Informações sobre a biblioteca ","[2] Livros Cadastrados ","[3] Buscar por Categoria ","[4] Buscar por autor ","[5] Adicionar Livro ","[6] gerar .JSON de todos os livros ","[7] Menu do usuario", "[8] Gerar Factory"};
            for(String opcao : opcoes) {
                System.out.println(opcao);
            }
            int esc;

            do{
                System.out.print("Escolha uma opção: ");
                try {
                    esc = scanner.nextInt();
                    while(esc < 0 || esc >= opcoes.length){
                        System.out.print("Escolha uma opção válida: ");
                        esc = scanner.nextInt();
                    }
                    break;
                } catch(InputMismatchException e) {
                    System.out.println("Entrada inválida, digite um valor válido");
                    scanner.nextLine();
                }
            }while(true);



            br();
            switch(esc) {
                case 0:
                    this.setStatus(false);
                    System.out.println("Sistema desenvolvido por LacamJC");
                    System.out.println("Documentação: https://github.com/LacamJC/Bookshelf_with_java");
                    break;
                case 1:
                    this.getBiblioteca().infoBiblioteca();
                    System.out.println("Usuarios cadastrados: "+this.userController.getUsuarios().size());
                    fim();
                    br();
                    break;

                case 2:
                    if(this.getBiblioteca().hasEmpty()){
                        System.out.println("Sem livros para ver");
                    }else{
                        this.getBiblioteca().getAllLivros();
                    }
                    fim();
                    br();
                    break;

                case 3:
                    if(this.getBiblioteca().hasEmpty())
                    {
                        System.out.println("Sem livros para ver");
                    }else {
                        this.menuCategoria();
                    }

                    fim();
                    br();
                    break;

                case 4:
                    if(this.getBiblioteca().hasEmpty())
                    {
                        System.out.println("Sem livros para ver");
                    }else {
                        this.menuAutor();
                    }
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

                case 7:
                    System.out.println("===== Função em desenvolvimento =====");
                    fim();
                    br();
                    break;

                case 8:
                    System.out.println("------ Gerando Factory Livros -------");
                    Livro[] livros = this.livroFactory.data();
                    for(Livro livro : livros){
                        this.getBiblioteca().addLivro(livro, this.getBiblioteca().getNome());
                    }
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
//        int categoria = scanner.nextInt();
//        while(categoria < 0 || categoria >= qtd_categorias){
//            System.out.print("Selecione uma opção válida: ");
//            categoria = scanner.nextInt();
//        }
        int esc;
        do{
            System.out.println("Selecione uma categoria: ");
            try {
                esc = scanner.nextInt();
                while(esc < 0 || esc >= qtd_categorias) {
                    System.out.println("Escolha uma opção válida");
                    esc = scanner.nextInt();
                }
                break;
            } catch(InputMismatchException e) {
                System.out.println("Entrada inválida, digite um valor válido");
                scanner.nextLine();
            }
        }while(true);

//        do{
//            System.out.print("Escolha uma opção: ");
//            try {
//                esc = scanner.nextInt();
//                while(esc < 0 || esc >= opcoes.length){
//                    System.out.print("Escolha uma opção válida: ");
//                    esc = scanner.nextInt();
//                }
//                break;
//            } catch(InputMismatchException e) {
//                System.out.println("Entrada inválida, digite um valor válido");
//                scanner.nextLine();
//            }
//        }while(true);




        List<String> array_categorias = new ArrayList<>(this.getBiblioteca().getCategorias());

        br();
//        this.getBiblioteca().getByCategoria(array_categorias.get(categoria));
        this.getBiblioteca().getByCategoria(array_categorias.get(esc));
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

    public void backToMenu(String string, int number){
        if(string.equalsIgnoreCase("0")){
            this.index();
        }
        if(number == 0){
            this.index();
        }
    }

    public void menuAdicionarLivro(){


        System.out.println(separador+" Adicionar Livro "+separador);
        System.out.println("======= Exemplo =======");
        System.out.println("Titulo: Clean Code");
        System.out.println("Categoria: Programação");
        System.out.println("Editora: Brasileira");
        System.out.println("Autor: Carlos Azevedo");
        System.out.println("Coloque 0 para voltar ao menu");
        System.out.println("========================");

        String titulo;



        System.out.print("Titulo: ");
        do {
            titulo = scanner.nextLine();
            this.backToMenu(titulo, 1);

        }while(titulo.isEmpty());


        String categoria;
        System.out.print("Categoria: ");
        do{
            categoria = scanner.nextLine();
            this.backToMenu(categoria, 1);
        }while(categoria.isEmpty());



        System.out.print("Editora: ");
        String editora;
        do{
            editora = scanner.nextLine();
            this.backToMenu(editora, 1);
        }while(editora.isEmpty());




        System.out.print("Autor: ");
        String autor;
        do{
            autor = scanner.nextLine();
            this.backToMenu(autor, 1);
        }while(autor.isEmpty());


        System.out.print("Quantidade de paginas: ");
        int paginas;
        do{
            paginas = scanner.nextInt();
            this.backToMenu("", paginas);
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
                this.getBiblioteca().addLivro(novo_livro, this.getBiblioteca().getNome());
                this.getJsonAllLivros();
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
            FileWriter writer = new FileWriter("src/database/livros.json");
            gson.toJson(livros, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void injectData(){
        Gson gson = new Gson();
        try{
            FileReader reader = new FileReader("src/database/livros.json");
            Livro[] livros_json = gson.fromJson(reader, Livro[].class);

            if(livros_json.length >= 1 ) {
                System.out.println("Existe pelo menos um livro aqui");
                for(Livro livro : livros_json) {
                    this.getBiblioteca().setLivros(livro);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        try{
//            FileReader reader = new FileReader("src/database/users.json");
//            Livro[] livros_json = gson.fromJson(reader, Livro[].class);
//
//            for(Livro livro : livros_json) {
//                this.getBiblioteca().setLivros(livro);
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }
}
