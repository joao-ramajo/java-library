package src.models;
import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import src.models.Biblioteca;

import src.models.Livro;
public class jsonDoc {
    public static void main(String[] args) {
        Livro livro = new Livro("Refatoração", "Engenharia de Software", "Americana", "Martin Fowler", 431);
        Livro livro2 = new Livro("Refatoração", "Engenharia de Software", "Americana", "Martin Fowler", 431);
        List<Livro> livros = new ArrayList<>();

        livros.add(livro);
        livros.add(livro2);



        Gson gson = new Gson();


        try {
            FileWriter writer = new FileWriter("livros.json");
            gson.toJson(livros, writer);

            writer.close();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
