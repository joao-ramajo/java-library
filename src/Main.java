package src;

import src.models.Livro;
import src.models.Biblioteca;
import src.models.Controller;
public class Main {
    public static void main(String[] args) {
        Biblioteca acervo = new Biblioteca("Pública");
        Controller controller = new Controller(acervo);
        controller.injectData();
        controller.index();

    }
}
