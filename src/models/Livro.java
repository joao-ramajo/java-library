package models;

public class Livro {

    private String titulo;
    private String autor;
    private String editora;
    private String categoria;
    private int paginas;

    public Livro(String titulo, String categoria, String autor, String editora, int paginas) {
        setTitulo(titulo);
        setCategoria(categoria);
        setAutor(autor);
        setEditora(editora);
        setPaginas(paginas);
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getTitulo(){ return this.titulo;}
    public String getAutor(){ return this.autor;}
    public int getPaginas(){ return this.paginas;}
    public String getEditora(){ return this.editora;}
    public String getCategoria(){ return this.categoria;}

    public void getInfo(){
        System.out.println("Titulo : " + getTitulo() + "\nPaginas: " + getPaginas() + "\nEditora: " + getEditora() + "\nAutor: " + getAutor());
    }

 


}