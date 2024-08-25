import java.time.LocalDate;

public interface IEmprestimo {

    public int getIdLivro();

    public int getIdUsuario();

    public LocalDate getData();

    public Exemplar getExemplar();
}