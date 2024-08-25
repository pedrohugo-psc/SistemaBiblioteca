import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class SistemaEmprestimo {

    private Biblioteca biblioteca;
    private IRegra regra;
    private List<IEmprestimo> emprestimos;
    private List<ReservaLivroUsuario> reservas;
    private List<Usuario> usuarios;

    public SistemaEmprestimo(Biblioteca biblioteca, List<Usuario> usuarios){
        this.biblioteca = biblioteca;
        this.usuarios = usuarios;
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
        
    }

    private Usuario buscaUsario(int idUsuario){
        
        Usuario usuarioEncontrado = null;
        for(Usuario usuario: usuarios){
            if(usuario.getidUsuario() == idUsuario){
                usuarioEncontrado = usuario;
            }
        }
        return usuarioEncontrado;
    }
    
    private void buscaRegra(int codigoUsuario){

        for (Usuario usuario : usuarios) {
            if (usuario.getidUsuario() == codigoUsuario) {
                regra = usuario.getRegraUsuario();
            }
        }
    }

    private IEmprestimo buscaEmprestimo(int codigoLivro, int codigoUsuario){
        IEmprestimo emprestimo = null;
        
        for(IEmprestimo emprestimoAtual: emprestimos){
            if(emprestimoAtual.getIdLivro() == codigoLivro && emprestimoAtual.getIdUsuario() == codigoUsuario){
                emprestimo = emprestimoAtual;
            }
        }

        return emprestimo;
    }

    private ReservaLivroUsuario buscaReserva (int codigoLivro, int codigoUsuario){
    
        ReservaLivroUsuario reserva = null;

        for(ReservaLivroUsuario reservaAutal: reservas){
            if(reservaAutal.getIdLivroReserva() == codigoLivro && reservaAutal.getIdUsarioReserva() == codigoUsuario){
                reserva = reservaAutal;
            }
        }

        return reserva;
        
    }

    private int buscaQtdReserva(int codigoUsuario){
        int resultado = 0;
        
        for(ReservaLivroUsuario reservaAtual: reservas){
            if(reservaAtual.getIdUsarioReserva() == codigoUsuario) resultado++;
        }

        return resultado;
        
    }

    public void setEmprestimo(boolean resultado, int codigoLivro, int codigoUsuario){

        if(resultado == true){
            Exemplar exemplarDisponivel = biblioteca.getExemplarDisponivel(codigoLivro);

            if(exemplarDisponivel == null){
                ReservaLivroUsuario reserva = buscaReserva(codigoLivro, codigoUsuario);
                Exemplar exemplarReserva = reserva.getExemplar();
                 
                IEmprestimo emprestimo = new Emprestimo(codigoLivro, codigoUsuario, exemplarReserva);
                emprestimos.add(emprestimo);
                reservas.remove(reserva);
                biblioteca.setExemplarBibliotecaEmprestado(exemplarReserva);
            }else{
                IEmprestimo emprestimo = new Emprestimo(codigoLivro, codigoUsuario, exemplarDisponivel);
                emprestimos.add(emprestimo);
                biblioteca.setExemplarBibliotecaEmprestado(exemplarDisponivel);
            }
            
            System.out.println("Emprestimo realizado com sucesso!");
        }else{
            
            System.out.println("Emprestismo não realizado!");
        }

    }

    public void processaEmprestimo(int codigoLivro, int codigoUsuario){

        buscaRegra(codigoUsuario);
        
        boolean resultado = regra.checaEmprestimo(codigoLivro,codigoUsuario, LocalDate.now(), emprestimos, reservas, biblioteca);

        setEmprestimo(resultado, codigoLivro, codigoUsuario);
            
    }

    public void processaDevolucao(int codigoLivro, int codigoUsuario){
        IEmprestimo emprestimo = buscaEmprestimo(codigoLivro, codigoUsuario);
        
        if(emprestimo != null){
            biblioteca.setExemplarBibliotecaDisponivel(emprestimo.getExemplar());
            emprestimos.remove(emprestimo);
            System.out.println("Devolução realizada com sucesso!");
        }else{
            System.out.println("Devolução não realizada!");
        }
    }

    public void processaReserva(int codigoLivro, int codigoUsuario){
        if(buscaQtdReserva(codigoUsuario) <= 3){
            Exemplar exemplar = biblioteca.getExemplarDisponivel(codigoLivro);
            Usuario usuario = buscaUsario(codigoUsuario);
            if(exemplar != null && usuario != null){
                ReservaLivroUsuario reserva = new ReservaLivroUsuario(exemplar, usuario);
                reservas.add(reserva);
                System.out.println("Reserva realizada com sucesso!");
            }else{
                System.out.println("Reserva não realizada!");
            }
        }else{
            System.out.println("Reserva não realizada!");
        }
    }


    public Biblioteca getBiblioteca(){

        return biblioteca;

    }

    public List<IEmprestimo> getEmprestimos(){
        return emprestimos;
    }

}