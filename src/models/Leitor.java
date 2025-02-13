package src.models;

import java.util.HashSet;
import java.util.Set;

public class Leitor extends User{
    private Set<Livro> livros_alugados = new HashSet<>();

    public Leitor(String nome, String email, String senha) {
        super(nome,email,senha);
    }

    public void alugarLivro(Livro livro){
        this.livros_alugados.add(livro);
    }

    public void devolverLivro(Livro livro){
        this.getLivrosAlugados().remove(livro);
        System.out.println("Livro devolvido com sucesso");
    }

    public Set<Livro> getLivrosAlugados() {
        return this.livros_alugados;
    }

    public void getInfo() {
        System.out.println("----- DADOS DO USUARIO ------");
        this.info();
        System.out.print("Livros alugados: ");
        for(Livro livro : this.getLivrosAlugados()) {
            System.out.print(livro.getTitulo()+",");
        }
        System.out.println("");
        System.out.println("------------------------------");
    }
}
