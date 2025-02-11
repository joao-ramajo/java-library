package src.models;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String categoria;
    private int paginas;

    public Livro(String titulo,  String categoria, String editora, String autor, int paginas) {
       this.setTitulo(titulo);
       this.setCategoria(categoria);
       this.setEditora(editora);
       this.setAutor(autor);
       this.setPaginas(paginas);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }



    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public String getEditora() {
        return this.editora;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public int getPaginas() {
        return this.paginas;
    }

    public void getInfo(){
        System.out.println("Titulo : " + getTitulo() + "\nPaginas: " + getPaginas() + "\nEditora: " + getEditora() + "\nAutor: " + getAutor());
    }
}
