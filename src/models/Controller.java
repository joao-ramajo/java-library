package models;
import models.Biblioteca;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Controller { 
    private boolean status;
    private Biblioteca biblioteca;
    private Scanner scanner = new Scanner(System.in);
    private String separador = "--------------";

    public Controller(Biblioteca biblioteca){
        setStatus(true);
        setBiblioteca(biblioteca);
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() { return this.status; }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void getBiblioteca() { 
        this.biblioteca.getInfo(); 
    }

    public void menuAutor(){
        br();
        System.out.println("----- Autores -----");
        Set<String> autores = this.biblioteca.getAllAutores();
        int qtd_autores = 0;
        for(String autor : autores) {
            qtd_autores++;
            System.out.println("["+qtd_autores+"] "+autor);
        }

        System.out.print("Escolha um autor: ");
        int esc = scanner.nextInt();
        ArrayList<String> autores_final = new ArrayList<>(autores);
        this.biblioteca.getByAutor(autores_final.get(esc-1));




    }

    public void menuCategorias(){
        br();
        System.out.println("----- Categorias -----");
        ArrayList<String> categorias = this.biblioteca.getAllCategorias();

        Set<String> categorias_unicas = new HashSet<>(categorias);

        ArrayList<String> categorias_final = new ArrayList<>(categorias_unicas);

        int qtd_categorias = 0;
        for(String categoria : categorias_unicas) {
            qtd_categorias++;
            System.out.println("["+qtd_categorias+"]"+categoria);
        }

        System.out.print("Procurar na categoria: ");
        int esc = scanner.nextInt();

        this.biblioteca.getByCategoria(categorias_final.get(esc-1));

        this.index();
    }

    public void br(){
        for(int i = 0; i < 5; i++) {
            System.out.println("");
            }
    }

    public void index(){
         br();
        System.out.println(separador + this.biblioteca.getNome() + separador);
        System.out.println("Bem vindo a biblioteca "+this.biblioteca.getNome()+" Escolha a opção que deseja");
        while(status) {
            
            System.out.println("\n------ MENU ----------\n[1] Informações sobre a biblioteca \n[2] Livros cadastrados \n[3] Sair\n[4] Buscar por categoria \n[5] Buscar por autor");


            System.out.print("Sua opção: ");
            int esc = scanner.nextInt();


            switch(esc) {
                case 1:
                    for(int i = 0; i < 5; i++) {
                    System.out.println("");
                    }
                    this.getBiblioteca();
                    for(int i = 0; i < 5; i++) {
                    System.out.println("");
                    }
                    break;
                case 2:
                    for(int i = 0; i < 5; i++) {
                    System.out.println("");
                    }
                    this.biblioteca.getLivros();
                    for(int i = 0; i < 5; i++) {
                    System.out.println("");
                    }
                    break;
                case 3:
                    this.setStatus(false);
                    break;
                case 4:
                    this.menuCategorias();
                    break;
                case 5:
                    this.menuAutor();
                    break;
                default:
                    System.out.println("OPÇÂO INVÁLIDA");
                    break;

            }
            for(int i = 0; i < 5; i++) {
                System.out.println("");
            }
        }
        

    }

    
}