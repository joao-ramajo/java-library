import models.Biblioteca;
import models.Livro;
import models.Controller;

public class Main {
    public static void main(String[] args) {
        // Livro machado = new Livro("Memorias postumas", "Machado de Assis", "Brasileira", 200);
        // Livro marcel = new Livro("Laravel off PHP", "Marcel Gonçalves dos Santos", "Brasileira", 400);
        // Livro harry = new Livro("Harry Potter e a Pedra Filosofal", "J.K. Rowling", "Britânica", 350);
        // Livro clean = new Livro("Clean Code", "Robert C. Martin", "Americana", 500);
        // Livro javascript = new Livro("JavaScript: The Good Parts", "Douglas Crockford", "Americana", 250);
        // Livro react = new Livro("Learning React", "Alex Banks", "Americana", 350);
        // Livro nodejs = new Livro("Node.js Design Patterns", "Mario Casciaro", "Italiana", 400);
        // Livro war_and_peace = new Livro("War and Peace", "Leo Tolstoy", "Russiana", 1200);
        // Livro game_of_thrones = new Livro("Game of Thrones", "George R. R. Martin", "Americana", 800);
        // Livro book_thief = new Livro("The Book Thief", "Markus Zusak", "Australiana", 600);
        // Livro algorithm = new Livro("Introduction to Algorithms", "Thomas H. Cormen", "Americana", 1200);
        // Livro deep_learning = new Livro("Deep Learning", "Ian Goodfellow", "Canadense", 700);
        // Livro python = new Livro("Automate the Boring Stuff with Python", "Al Sweigart", "Americana", 450);
        // Livro html_css = new Livro("HTML and CSS: Design and Build Websites", "Jon Duckett", "Britânica", 350);
        // Livro php = new Livro("PHP & MySQL: Novice to Ninja", "Tom Butler", "Britânica", 500);
        Livro python = new Livro("Automate the Boring Stuff with Python", "Tecnologia", "Al Sweigart", "Americana", 450);
        Livro php = new Livro("PHP & MySQL: Novice to Ninja", "Tecnologia", "Tom Butler", "Britânica", 500);
        Livro[] livros = {python, php};


        Biblioteca acervo = new Biblioteca("Pública" , livros);

        Controller controller = new Controller(acervo);

        controller.index();

    }
}