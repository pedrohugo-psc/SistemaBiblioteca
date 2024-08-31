import java.util.List;
/**
 * Interface que define o contrato para um livro.
 * Classes que implementam esta interface devem fornecer métodos para acessar e modificar
 * informações sobre a editora, os autores, o ano de publicação, o título, a edição e o ID do livro.
 */
public interface ILivro {

    public String getEditora();

    public List<String> getAutores();

    public int getAnoPublicacao();

    public String getTitulo();

    public void setTitulo(String titulo);

    public int getEdicao();

    public int getIdLivro();
}