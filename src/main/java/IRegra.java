import java.time.LocalDate;
import java.util.List;
/**
 * Interface que define o contrato para regras de empréstimo em um sistema de biblioteca.
 * Classes que implementam esta interface devem fornecer métodos para:
 * - Verificar se um empréstimo é permitido, considerando o livro, o usuário, a data, empréstimos existentes, reservas e a biblioteca.
 * - Obter a própria regra (útil para acessar informações específicas da regra).
 * - Calcular a data prevista de devolução com base na data de empréstimo.
 */
public interface IRegra {
    public boolean checaEmprestimo(int codigoLivro, int codigoUsuario, LocalDate date, List<IEmprestimo> emprestimos, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca);
    public IRegra getRegra();
    public LocalDate DataPrevistaDevolucao(LocalDate dataEmprestimo);
}