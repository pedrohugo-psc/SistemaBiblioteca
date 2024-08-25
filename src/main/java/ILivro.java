import java.util.List;

public interface ILivro {

    public String getEditora();

    public List<String> getAutores();

    public int getAnoPublicacao();

    public String getTitulo();

    public void setTitulo(String titulo);

    public int getEdicao();

    public int getIdLivro();
}