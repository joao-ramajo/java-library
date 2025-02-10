package models;
import models.Biblioteca;
import java.util.Scanner;

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


    public void index(){
         for(int i = 0; i < 5; i++) {
            System.out.println("");
        }
        System.out.println(separador + this.biblioteca.getNome() + separador);

        while(this.getStatus()) {
            System.out.println("Bem vindo a biblioteca "+this.biblioteca.getNome()+" Escolha a opção que deseja");
            System.out.println("\n[1] Informações sobre a biblioteca \n[2] Livros cadastrados");


            System.out.print("Sua opção: ");
            int esc = scanner.nextInt();


            switch(esc) {
                case 1:
                    this.getBiblioteca();
                    break;
                case 2:
                    this.biblioteca.getLivros();
                    break;
            }
            for(int i = 0; i < 5; i++) {
                System.out.println("");
            }
        }
        

    }

    
}