import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
/**
 * Classe que implementa as regras de empréstimo específicas para professores.
 * Define as condições e restrições para que um professor possa realizar um empréstimo.
 * As principais diferenças em relação à regra de alunos são:
 * - Não há limite de empréstimos simultâneos.
 * - Prazo de devolução: 7 dias (em vez de 3 para alunos de graduação ou 5 para pós-graduação).
 */
public class RegraProfessor implements IRegra{


    public boolean buscaEmprestimoDataUsuario(LocalDate dataAtual, int codigoUsuario, List<IEmprestimo> emprestimos){
        boolean resultado = true;

        for (IEmprestimo emprestimo : emprestimos) {
            if ((emprestimo.getIdUsuario() == codigoUsuario) && ((ChronoUnit.DAYS.between(emprestimo.getData(),dataAtual)) > 7)) {
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean buscaReservaUsarioLivro(int codigoLivro, int codigoUsuario, List<ReservaLivroUsuario> reservas){
        boolean resultado = false;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdLivroReserva() == codigoLivro && reserva.getIdUsarioReserva() == codigoUsuario) resultado = true;
        }

        return resultado;
    }

    public boolean verificaDisponibilidade(int codigoLivro, int codigoUsuario, Biblioteca biblioteca, List<ReservaLivroUsuario> reservas){

        boolean resultado = (biblioteca.buscaStatusDisponivel(codigoLivro) || buscaReservaUsarioLivro(codigoLivro, codigoUsuario, reservas));

        return resultado;
    }

    public boolean verificaDevedor(LocalDate date, int codigoUsuario, List<IEmprestimo> emprestimos){

        boolean resultado = buscaEmprestimoDataUsuario(date, codigoUsuario, emprestimos);

        return resultado;
    }

    public boolean checaEmprestimo(int codigoLivro, int codigoUsuario, LocalDate date, List<IEmprestimo> emprestimos, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca) {

        if(!verificaDisponibilidade(codigoLivro, codigoUsuario, biblioteca, reservas)) return false;

        if(!verificaDevedor(date, codigoUsuario, emprestimos)) return false;
        
        
        return true;
    }

    public IRegra getRegra(){
        return this;
    }

}