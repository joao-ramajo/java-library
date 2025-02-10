import models.Biblioteca;
import models.Livro;
import models.Controller;

public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("PHP & MySQL: Novice to Ninja", "Tecnologia", "Tom Butler", "Britânica", 500);
        Livro livro2 = new Livro("Clean Code", "Programação", "Robert C. Martin", "Alta Books", 460);
        Livro livro3 = new Livro("Java: Como Programar", "Tecnologia", "Deitel & Deitel", "Pearson", 1200);
        Livro livro4 = new Livro("JavaScript: O Guia Definitivo", "Tecnologia", "David Flanagan", "O'Reilly Media", 704);
        Livro livro5 = new Livro("Design Patterns: Elementos de Software Orientado a Objetos Reusáveis", "Design", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "Addison-Wesley", 395);
        Livro livro6 = new Livro("Aprenda PHP", "Tecnologia", "Diego S. G.", "Novatec", 400);
        Livro livro7 = new Livro("Introdução ao Desenvolvimento Web com HTML5, CSS3 e JavaScript", "Desenvolvimento Web", "Jon Duckett", "Bookman", 464);
        Livro livro8 = new Livro("The Pragmatic Programmer", "Programação", "Andrew Hunt, David Thomas", "Addison-Wesley", 352);
        Livro livro9 = new Livro("C# 7.0 - O Guia Completo", "Tecnologia", "Herbert Schildt", "McGraw-Hill", 978);
        Livro livro10 = new Livro("Design de Interfaces", "Design", "Jenifer Tidwell", "Bookman", 480);

        Livro python = new Livro("Automate the Boring Stuff with Python", "Tecnologia", "Al Sweigart", "Americana", 450);
        //Livro php = new Livro("PHP & MySQL: Novice to Ninja", "Tecnologia", "Tom Butler", "Britânica", 500);
        Livro[] livros = {python, livro1, livro2, livro3, livro4, livro5,livro6,livro7,livro8,livro9,livro10};


        Biblioteca acervo = new Biblioteca("Pública" , livros);

        Controller controller = new Controller(acervo);

        controller.index();


    }
}