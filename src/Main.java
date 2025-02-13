package src;

import src.factories.LivroFactory;
import src.models.Biblioteca;
import src.controllers.Controller;
import src.models.Leitor;
import src.models.Livro;

public class Main {
    public static void main(String[] args) {
        Biblioteca acervo = new Biblioteca("Pública");
        Controller controller = new Controller(acervo);

        controller.index();

    }
}
