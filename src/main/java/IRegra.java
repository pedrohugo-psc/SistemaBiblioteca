import java.time.LocalDate;
import java.util.List;


public interface IRegra {
    public boolean checaEmprestimo(int codigoLivro, int codigoUsuario, LocalDate date, List<IEmprestimo> emprestimos, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca);
    public IRegra getRegra();
}