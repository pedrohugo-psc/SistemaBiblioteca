import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class RegraProfessor implements IRegra{

    List<IEmprestimo> emprestimos;
    List<ReservaLivroUsuario> reservas;
    Biblioteca biblioteca;

    public void setListaEmprestimo(List<IEmprestimo> emprestimos){
        this.emprestimos = emprestimos;
    }

    public void setBiblioteca(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    public void setListaReserva(List<ReservaLivroUsuario> reservas){
        this.reservas = reservas;
    }

    public boolean buscaEmprestimoDataUsuario(LocalDate dataAtual, int codigoUsuario){
        boolean resultado = true;

        for (IEmprestimo emprestimo : emprestimos) {
            if ((emprestimo.getIdUsuario() == codigoUsuario) && ((ChronoUnit.DAYS.between(emprestimo.getData(),dataAtual)) > 7)) {
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean buscaReservaUsarioLivro(int codigoLivro, int codigoUsuario){
        boolean resultado = false;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdLivroReserva() == codigoLivro && reserva.getIdUsarioReserva() == codigoUsuario) resultado = true;
        }

        return resultado;
    }

    public boolean verificaDisponibilidade(int codigoLivro, int codigoUsuario){

        boolean resultado = (biblioteca.buscaStatusDisponivel(codigoLivro) || buscaReservaUsarioLivro(codigoLivro, codigoUsuario));

        return resultado;
    }

    public boolean verificaDevedor(LocalDate date, int codigoUsuario){

        boolean resultado = buscaEmprestimoDataUsuario(date, codigoUsuario);

        return resultado;

    }

    public boolean checaEmprestimo(int codigoLivro, int codigoUsuario, LocalDate date, List<IEmprestimo> emprestimos, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca) {
        setListaEmprestimo(emprestimos);
        setBiblioteca(biblioteca);
        setListaReserva(reservas);

        if(!verificaDisponibilidade(codigoLivro, codigoUsuario)) return false;

        if(!verificaDevedor(date, codigoUsuario)) return false;
        
        
        return true;
    }

    public IRegra getRegra(){
        return this;
    }

    public LocalDate DataPrevistaDevolucao(LocalDate dataEmprestimo){
        LocalDate dataPrevistaDevolucao = dataEmprestimo.plusDays(7);

        return dataPrevistaDevolucao;
    }

    
	

}