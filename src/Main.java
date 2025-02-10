import models.Biblioteca;
import models.Livro;

public class Main {
    public static void main(String[] args) {

        Livro machado = new Livro("Memorias postumas", "Machado de assis", "Brasileira", 200);
        Livro marcel = new Livro("Laravel off PHP", "Marcel gonçalves dos santos", "Brasileira", 400);

        Livro[] livros = {machado, marcel};

        Biblioteca acervo = new Biblioteca("Pública" , livros);

        acervo.getLivros();
    }
}