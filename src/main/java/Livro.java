import java.util.List;

public class Livro implements ILivro{
    private String editora;
    private List<String>autores;
    private int ano_publicacao;
    private String titulo;
    private int edicao;
    private int idLivro;
    
    public Livro(String editora, int ano_publicacao, String titulo, int edicao, int idLivro, List<String>autores){
        this.editora = editora;
        this.ano_publicacao = ano_publicacao;
        this.titulo = titulo;
        this.edicao = edicao;
        this.idLivro = idLivro;
        this.autores = autores;
    }
    
    public String getEditora() {
        return editora;
    }
    
    public List<String> getAutores() {
        return autores;
    }
    
    public int getAnoPublicacao() {
        return ano_publicacao;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public int getEdicao() {
        return edicao;
    }
    
    public int getIdLivro() {
        return idLivro;
    }

}