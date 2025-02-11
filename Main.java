import src.models.Livro;
import src.models.Biblioteca;
import src.models.Controller;
public class Main {
    public static void main(String[] args) {

        Livro livro1 = new Livro("Php with Java", "Tecnologia", "Brasileira", "Paulo Gustavo", 200);
        Livro livro2 = new Livro("Clean Code", "Programação", "Americana", "Robert C. Martin", 464);
        Livro livro3 = new Livro("Estruturas de Dados com Java", "Tecnologia", "Brasileira", "Loiane Groner", 400);
        Livro livro4 = new Livro("O Programador Pragmático", "Desenvolvimento", "Americana", "Andrew Hunt", 352);
        Livro livro5 = new Livro("Padrões de Projetos", "Engenharia de Software", "Americana", "Erich Gamma", 416);
        Livro livro6 = new Livro("Java: Como Programar", "Tecnologia", "Americana", "Deitel & Deitel", 1200);
        Livro livro7 = new Livro("Java Efetivo", "Programação", "Americana", "Joshua Bloch", 416);
        Livro livro8 = new Livro("Banco de Dados para Desenvolvedores", "Banco de Dados", "Brasileira", "Carlos Azevedo", 380);
        Livro livro9 = new Livro("Design de Interfaces Modernas", "UI/UX", "Brasileira", "João Souza", 320);
        Livro livro10 = new Livro("Refatoração", "Engenharia de Software", "Americana", "Martin Fowler", 431);

        Livro[] livros = {livro1,livro2,livro3,livro4,livro5,livro6,livro7,livro8,livro9,livro10};

        Biblioteca acervo = new Biblioteca("Pública" , livros);

        Controller controller = new Controller(acervo);

        controller.index();


    }
}
