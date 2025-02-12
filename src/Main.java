package src;

import src.models.Biblioteca;
import src.controllers.Controller;
import src.models.Leitor;
import src.models.Livro;

public class Main {
    public static void main(String[] args) {
        Biblioteca acervo = new Biblioteca("Pública");
        Controller controller = new Controller(acervo);
        controller.index();

//        Leitor leitor = new Leitor("João ramajo", "joao@gmail.com", "123456");
//        Livro livro = new Livro("PHP WITH JAVA", "Paulo gustavo", "Brasileiroa", "Eu", 200);
//        Livro livro2 = new Livro("JAVA WITH PHP", "Paulo gustavo", "Brasileiroa", "Eu", 200);
//
//        leitor.alugarLivro(livro);
//
//        leitor.alugarLivro(livro2);
//        leitor.getInfo();
//        leitor.devolverLivro(livro);
//        leitor.getInfo();
    }
}
