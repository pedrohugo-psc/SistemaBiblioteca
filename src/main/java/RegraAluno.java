
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
/**
 * Classe que implementa as regras de empréstimo específicas para alunos.
 * Define as condições e restrições para que um aluno possa realizar um empréstimo.
 */
public class RegraAluno implements IRegra{

    public boolean buscaNumeroEmprestimoUsuario(int codigoUsuario, List<IEmprestimo> emprestimos)
    {
        int numEmprestimo = 0;
        boolean resultado = true;

        for (IEmprestimo emprestimo : emprestimos) {
            if ((emprestimo.getIdUsuario() == codigoUsuario)) {
                numEmprestimo++;
            }
        }

        if (numEmprestimo >= 3) {
            resultado = false;
        }

        return resultado;
    } 

    public boolean buscaEmprestimoDataUsuario(LocalDate dataAtual, int codigoUsuario, List<IEmprestimo> emprestimos){
        boolean resultado = true;

        for (IEmprestimo emprestimo : emprestimos) {
            if ((emprestimo.getIdUsuario() == codigoUsuario) && ((ChronoUnit.DAYS.between(emprestimo.getData(),dataAtual)) > 3)) {
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean buscaLivroSemReservaUsuario(int codigoLivro, int codigoUsuario, List<ReservaLivroUsuario> reservas){
        boolean resultado = true;
        
        for(ReservaLivroUsuario reserva : reservas){
            if((reserva.getIdUsarioReserva() == codigoUsuario) && (reserva.getIdLivroReserva() == codigoLivro)){
                resultado = false;
            }
        }
        return resultado;
    }

    public int buscaQtdReservasLivro(int codigoLivro, List<ReservaLivroUsuario> reservas){
        int qtdReservasLivro = 0;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdLivroReserva() == codigoLivro){
                    qtdReservasLivro++;
            }
        }

        return qtdReservasLivro;
    }

    public int buscaQtdExemplarDisponivel(int codigoLivro, Biblioteca biblioteca){
        int qtdExemplarDisponivel = 0;

        for(Exemplar exemplar : biblioteca.getExemplares()){
            if((exemplar.getIdLivro() == codigoLivro) && (exemplar.getStatus() == Status.StatusEnum.DISPONIVEL)){
                qtdExemplarDisponivel++;
            }
        }

        return qtdExemplarDisponivel;
    }

    public boolean buscaQtdReservaLivroMenorDisponivel(int codigoLivro, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca){
        boolean resultado = true;

        int qtdReservasLivro = buscaQtdReservasLivro(codigoLivro, reservas);
        int qtdExemplarLivroDisponivel = buscaQtdExemplarDisponivel(codigoLivro, biblioteca);

        if(qtdReservasLivro > qtdExemplarLivroDisponivel){
            resultado = false;
        }

        return resultado;
    }

    public int buscaQtdExemplaresReservado(int codigoLivro, List<ReservaLivroUsuario> reservas){
        int qtdExemplaresReservado = 0;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdLivroReserva() == codigoLivro){
                qtdExemplaresReservado++;
            }
        }

        return qtdExemplaresReservado;
    }

    public boolean buscaAlgumaReservaUsuario(int codigoUsario, List<ReservaLivroUsuario> reservas){

        boolean resultado = false;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdUsarioReserva() == codigoUsario){
                resultado = true;
            }
        }

        return resultado;
    }

    public boolean buscaEmprestimoUsarioLivro(int codigoLivro, int codigoUsuario, List<IEmprestimo> emprestimos){
            boolean resultado = true;

            for(IEmprestimo emprestimo : emprestimos){
                if(emprestimo.getIdLivro() == codigoLivro && emprestimo.getIdUsuario() == codigoUsuario) resultado = false;
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

    public boolean verficarLimiteEmprestimo(int codigoUsuario, List<IEmprestimo> emprestimos){
        boolean resultado = buscaNumeroEmprestimoUsuario(codigoUsuario, emprestimos);

        return resultado;
    }

    public boolean verificarMenoresExemplaresDisponiveisParaNaoReservantes(int codigoLivro, int codigoUsuario, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca){


        boolean resultado = true;

        if(buscaLivroSemReservaUsuario(codigoLivro, codigoUsuario, reservas)){
            resultado = buscaQtdReservaLivroMenorDisponivel(codigoLivro, reservas, biblioteca);
        }
        
        return resultado;
    }


    public boolean verficarQtdReversasMaiorIgualExemplaresUsarioReservou(int codigoLivro, int codigoUsuario, Biblioteca biblioteca, List<ReservaLivroUsuario> reservas){
        boolean resultado = false;
        
        int qtdExemplares = buscaQtdExemplarDisponivel(codigoLivro, biblioteca);
        int qtdExemplaresReservados = buscaQtdExemplaresReservado(codigoLivro, reservas);

        if(buscaAlgumaReservaUsuario(codigoUsuario, reservas)){
            resultado = (qtdExemplaresReservados >= qtdExemplares);
        }else{
            resultado = true;
        }

        return resultado;
        
    }

    public boolean verificarUsarioEmprestimoIgual(int codigoLivro, int codigoUsuario, List<IEmprestimo> emprestimos){
        boolean resultado = buscaEmprestimoUsarioLivro(codigoLivro, codigoUsuario, emprestimos);

        return resultado;
    }

    public boolean checaEmprestimo(int codigoLivro, int codigoUsuario, LocalDate date, List<IEmprestimo> emprestimos, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca){

        if(!verificaDisponibilidade(codigoLivro, codigoUsuario, biblioteca, reservas)) return false;
        if(!verificaDevedor(date, codigoUsuario, emprestimos)) return false;
        if(!verficarLimiteEmprestimo(codigoUsuario, emprestimos)) return false;
        if(!verificarMenoresExemplaresDisponiveisParaNaoReservantes(codigoLivro, codigoUsuario, reservas, biblioteca)) return false;
        if(!verficarQtdReversasMaiorIgualExemplaresUsarioReservou(codigoLivro, codigoUsuario, biblioteca, reservas)) return false;
        if(!verificarUsarioEmprestimoIgual(codigoLivro, codigoUsuario, emprestimos)) return false;
        return true;
    }

    public IRegra getRegra(){
        return this;
    }
 
}