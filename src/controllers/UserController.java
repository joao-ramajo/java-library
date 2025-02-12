package src.controllers;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import com.google.gson.Gson;
import src.models.Biblioteca;
import src.models.User;
public class UserController {
    private boolean status;
    private String separador = "----------";
    private Scanner scanner = new Scanner(System.in);
    private Set<User> usuarios = new HashSet<>();
    public void fim() {
        System.out.print("Digite ok para continuar: ");
        scanner.next();
    }

    public UserController() {
        this.setStatus(true);
    }



    public void setStatus(boolean status){
        this.status = status;
    }

    public void setUsuarios(User usuario) {
        this.usuarios.add(usuario);
    }

    public Set<User> getUsuarios() {
        return this.usuarios;
    }


    public boolean continuar() {
        System.out.println("[0] Para sair do menu de usuario");
        System.out.println("[1] Para continuar");
        System.out.print("Selecione sua opção: ");
        int esc = scanner.nextInt();

        return esc==0?false:true;
    }

    public void index() {
        while(status) {
            System.out.println(separador+" Menu do usuario "+separador);
            String[] opcoes = {"[0] Ir para biblioteca", "[1] Cadastra usuario", "[2] Informações gerais", "[3] Gerar json de usuarios"};

            for(String opcao : opcoes) {
                System.out.println(opcao);
            }
            System.out.print("Selecione uma opção: ");
            int esc = scanner.nextInt();
            while(esc < 0 || esc > opcoes.length-1) {
                for(String opcao : opcoes) {
                    System.out.println(opcao);
                }
                System.out.print("Selecione uma opção válida: ");
                esc = scanner.nextInt();
            }

            switch(esc) {
                case 0:
                    this.setStatus(false);
                    break;

                case 1:
                    this.createUser();
                    break;

                case 2:
                    this.getInfo();
                    break;

                case 3:
                    this.getJsonUsers();
                    break;
            }

        }
    }

    public void getInfo() {
        System.out.println("------ Informações -----");
        System.out.println("Usuarios cadastrados : " + this.getUsuarios().size());
        fim();
    }

    public void createUser() {
        String usuario_nome;
        String usuario_email;
        String usuario_senha;

        System.out.println("----- Cadastrar Usuario ------");
        System.out.print("Nome: ");
        do{
            usuario_nome = scanner.nextLine();
        }while(usuario_nome.isEmpty());

        System.out.print("Email: ");
        do{
            usuario_email = scanner.nextLine();
        }while(usuario_email.isEmpty());


        System.out.print("Senha: ");
        do{
            usuario_senha = scanner.nextLine();
        }while(usuario_senha.isEmpty());

        User novo_usuario = new User(usuario_nome, usuario_email, usuario_senha);

        this.setUsuarios(novo_usuario);


    }

    public void getJsonUsers() {
        List<User> users = new ArrayList<>();

        for(User user : this.getUsuarios()) {
            users.add(user);
        }

        Gson gson = new Gson();

        try{
            FileWriter writer = new FileWriter("src/database/users.json");
            gson.toJson(users, writer);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
