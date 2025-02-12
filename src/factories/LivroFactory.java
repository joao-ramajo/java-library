package src.factories;

import src.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroFactory {
    public Livro[] data(){
        Livro livro1 = new Livro("Clean Code", "Programação", "Prentice Hall", "Robert C. Martin", 464);
        Livro livro2 = new Livro("The Pragmatic Programmer", "Programação", "Addison-Wesley", "Andrew Hunt e David Thomas", 352);
        Livro livro3 = new Livro("Don't Make Me Think", "UI/UX", "New Riders", "Steve Krug", 216);
        Livro livro4 = new Livro("Refactoring", "Programação", "Addison-Wesley", "Martin Fowler", 448);
        Livro livro5 = new Livro("Design for Hackers", "Design", "Wiley", "David Kadavy", 352);
        Livro livro6 = new Livro("Sprint", "Design Thinking", "Simon & Schuster", "Jake Knapp", 288);
        Livro livro7 = new Livro("Hooked: How to Build Habit-Forming Products", "UX", "Portfolio", "Nir Eyal", 256);
        Livro livro8 = new Livro("The Design of Everyday Things", "Design", "Basic Books", "Don Norman", 368);
        Livro livro9 = new Livro("Lean UX", "UX", "O'Reilly Media", "Jeff Gothelf", 200);
        Livro livro10 = new Livro("Thinking, Fast and Slow", "Psicologia Cognitiva", "Farrar, Straus and Giroux", "Daniel Kahneman", 499);

        return new Livro[]{livro1,livro2,livro3, livro4,livro5,livro6,livro7,livro8,livro9,livro10};

    }
}
