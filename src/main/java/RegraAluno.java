
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class RegraAluno implements IRegra{

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

    public boolean buscaNumeroEmprestimoUsuario(int codigoUsuario)
    {
        int numEmprestimo = 0;
        boolean resultado = true;

        for (IEmprestimo emprestimo : emprestimos) {
            if ((emprestimo.getIdUsuario() == codigoUsuario)) {
                numEmprestimo++;
            }
        }

        if (numEmprestimo > 2) {
            resultado = false;
        }

        return resultado;
    } 

    public boolean buscaEmprestimoDataUsuario(LocalDate dataAtual, int codigoUsuario){
        boolean resultado = true;

        for (IEmprestimo emprestimo : emprestimos) {
            if ((emprestimo.getIdUsuario() == codigoUsuario) && ((ChronoUnit.DAYS.between(emprestimo.getData(),dataAtual)) > 3)) {
                resultado = false;
            }
        }
        return resultado;
    }

    public boolean buscaLivroSemReservaUsuario(int codigoLivro, int codigoUsuario){
        boolean resultado = true;
        
        for(ReservaLivroUsuario reserva : reservas){
            if((reserva.getIdUsarioReserva() == codigoUsuario) && (reserva.getIdLivroReserva() == codigoLivro)){
                resultado = false;
            }
        }
        return resultado;
    }

    public int buscaQtdReservasLivro(int codigoLivro){
        int qtdReservasLivro = 0;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdLivroReserva() == codigoLivro){
                    qtdReservasLivro++;
            }
        }

        return qtdReservasLivro;
    }

    public int buscaQtdExemplarDisponivel(int codigoLivro){
        int qtdExemplarDisponivel = 0;

        for(Exemplar exemplar : biblioteca.getExemplares()){
            if((exemplar.getIdLivro() == codigoLivro) && (exemplar.getStatus() == Status.StatusEnum.DISPONIVEL)){
                qtdExemplarDisponivel++;
            }
        }

        return qtdExemplarDisponivel;
    }

    public boolean buscaQtdReservaLivroMenorDisponivel(int codigoLivro){
        boolean resultado = true;

        int qtdReservasLivro = buscaQtdReservasLivro(codigoLivro);
        int qtdExemplarLivroDisponivel = buscaQtdExemplarDisponivel(codigoLivro);

        if(qtdReservasLivro > qtdExemplarLivroDisponivel){
            resultado = false;
        }

        return resultado;
    }

    public int buscaQtdExemplaresReservado(int codigoLivro){
        int qtdExemplaresReservado = 0;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdLivroReserva() == codigoLivro){
                qtdExemplaresReservado++;
            }
        }

        return qtdExemplaresReservado;
    }

    public boolean buscaAlgumaReservaUsuario(int codigoUsario){
        boolean resultado = false;

        for(ReservaLivroUsuario reserva : reservas){
            if(reserva.getIdUsarioReserva() == codigoUsario){
                resultado = true;
            }
        }

        return resultado;
    }

    public boolean buscaEmprestimoUsarioLivro(int codigoLivro, int codigoUsuario){
            boolean resultado = true;

            for(IEmprestimo emprestimo : emprestimos){
                if(emprestimo.getIdLivro() == codigoLivro && emprestimo.getIdUsuario() == codigoUsuario) resultado = false;
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

    public boolean verficarLimiteEmprestimo(int codigoUsuario){
        boolean resultado = buscaNumeroEmprestimoUsuario(codigoUsuario);

        return resultado;
    }

    public boolean verificarMenoresExemplaresDisponiveisParaNaoReservantes(int codigoLivro, int codigoUsuario){

        boolean resultado = true;

        if(buscaLivroSemReservaUsuario(codigoLivro, codigoUsuario)){
            resultado = buscaQtdReservaLivroMenorDisponivel(codigoLivro);
        }
        
        return resultado;
    }


    public boolean verficarQtdReversasMaiorIgualExemplaresUsarioReservou(int codigoLivro, int codigoUsuario){
        boolean resultado = false;
        
        int qtdExemplares = buscaQtdExemplarDisponivel(codigoLivro);
        int qtdExemplaresReservados = buscaQtdExemplaresReservado(codigoLivro);

        if(buscaAlgumaReservaUsuario(codigoUsuario)){
            resultado = (qtdExemplaresReservados >= qtdExemplares);
        }else{
            resultado = true;
        }

        return resultado;
        
    }

    public boolean verificarUsarioEmprestimoIgual(int codigoLivro, int codigoUsuario){
        boolean resultado = buscaEmprestimoUsarioLivro(codigoLivro, codigoUsuario);

        return resultado;
    }

    public boolean checaEmprestimo(int codigoLivro, int codigoUsuario, LocalDate date, List<IEmprestimo> emprestimos, List<ReservaLivroUsuario> reservas, Biblioteca biblioteca){

        setListaEmprestimo(emprestimos);
        setBiblioteca(biblioteca);
        setListaReserva(reservas);

        if(!verificaDisponibilidade(codigoLivro, codigoUsuario)) return false;
        if(!verificaDevedor(date, codigoUsuario)) return false;
        if(!verficarLimiteEmprestimo(codigoUsuario)) return false;
        if(!verificarMenoresExemplaresDisponiveisParaNaoReservantes(codigoLivro, codigoUsuario)) return false;
        if(!verficarQtdReversasMaiorIgualExemplaresUsarioReservou(codigoLivro, codigoUsuario)) return false;
        if(!verificarUsarioEmprestimoIgual(codigoLivro, codigoUsuario)) return false;
        return true;
    }

    public IRegra getRegra(){
        return this;
    }

}