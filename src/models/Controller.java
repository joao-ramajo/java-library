package src.models;
import src.models.Biblioteca;
import java.util.Scanner;
import java.util.ArrayList;
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

            System.out.println("[0] Sair\n[1] Informações sobre a biblioteca \n[2] Livros Cadastrados \n[3] Buscar por Categoria \n[4] Buscar por autor");

            System.out.print("Escolha uma opção: ");
            int esc = scanner.nextInt();

            while(esc < 0 || esc >= 5){
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
}
