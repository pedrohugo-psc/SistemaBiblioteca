import java.time.LocalDate;
/**
 * Interface que define o contrato para um empréstimo de um exemplar.
 * Classes que implementam esta interface devem fornecer métodos para acessar informações 
 * sobre o livro, o usuário, a data do empréstimo, o exemplar emprestado, 
 * o código do exemplar, o nome do usuário, a data prevista de devolução e o título do livro emprestado
 */
public interface IEmprestimo {

    public int getIdLivro();

    public int getIdUsuario();

    public LocalDate getData();

    public Exemplar getExemplar();

    public int getIdExemplarEmprestimo();

    public String getNomeUsuarioEmprestimo();

    public LocalDate getDataPrevistaEmprestimo();

    public String getTituloEmprestimo();
}