import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaEmprestimo {

    private static SistemaEmprestimo instancia;
    private Biblioteca biblioteca;
    private IRegra regra;
    private Historico historico;
    private List<IEmprestimo> emprestimos;
    private List<ReservaLivroUsuario> reservas;
    private List<Usuario> usuarios;
    ObservaLivro observaLivro;

    private SistemaEmprestimo(){
        this.historico = new Historico();
        this.emprestimos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public static SistemaEmprestimo getInstancia() { 
		
        if(instancia == null) instancia = new SistemaEmprestimo();
		
		return instancia;
	}

    public void insereDadosIniciais(Biblioteca biblioteca, List<Usuario> usuarios){
        this.biblioteca = biblioteca;
        this.usuarios = usuarios;
    }

    private Usuario buscaUsario(int idUsuario){
        
        Usuario usuarioEncontrado = null;
        for(Usuario usuario: usuarios){
            if(usuario.getIdUsuario() == idUsuario){
                usuarioEncontrado = usuario;
            }
        }
        return usuarioEncontrado;
    }
    
    private void buscaRegra(int codigoUsuario){

        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario() == codigoUsuario) {
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

    private IEmprestimo buscaEmprestimoLivro(Exemplar exemplar){
        IEmprestimo emprestimo = null;

        for(IEmprestimo emprestimoAtual: emprestimos){
            if(emprestimoAtual.getIdExemplarEmprestimo() == exemplar.getCodigoExemplar()){
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

    private List<ReservaLivroUsuario> buscaReservasLivro(int codigoLivro)
    {
        List<ReservaLivroUsuario> reservasLivro = new ArrayList<>();

        for(ReservaLivroUsuario reserva: reservas){

            if(reserva.getIdLivroReserva() == codigoLivro){
                reservasLivro.add(reserva);
            }
        }

        return reservasLivro;
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
            IEmprestimo emprestimo = null;

            if(exemplarDisponivel == null){
                ReservaLivroUsuario reserva = buscaReserva(codigoLivro, codigoUsuario);
                Exemplar exemplarReserva = reserva.getExemplar();
                emprestimo = new Emprestimo( exemplarReserva, buscaUsario(codigoUsuario));
                emprestimos.add(emprestimo);
                reservas.remove(reserva);
                biblioteca.setExemplarBibliotecaEmprestado(exemplarReserva);
            }else{
                emprestimo = new Emprestimo(exemplarDisponivel, buscaUsario(codigoUsuario));
                emprestimos.add(emprestimo);
                biblioteca.setExemplarBibliotecaEmprestado(exemplarDisponivel);
            }
            historico.setRegistroEmprestimos(emprestimo);
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
            historico.setRegistroDevolucao(emprestimo);
            System.out.println("Devolução realizada com sucesso!");
        }else{
            System.out.println("Devolução não realizada!");
        }
    }

    public void processaReserva(int codigoLivro, int codigoUsuario){
        if(buscaQtdReserva(codigoUsuario) <= 2){
            Exemplar exemplar = biblioteca.getExemplarDisponivel(codigoLivro);
            Usuario usuario = buscaUsario(codigoUsuario);
            if(exemplar != null && usuario != null){
                ReservaLivroUsuario reserva = new ReservaLivroUsuario(exemplar, usuario);
                reservas.add(reserva);
                historico.setRegistroReserva(reserva);
                System.out.println("Reserva realizada com sucesso!");
            }else{
                System.out.println("Reserva não realizada!");
            }
        }else{
            System.out.println("Reserva não realizada!");
        }
    }

    public void processaObervador(int codigoLivro, int codigoUsuario){
        Usuario usuario = buscaUsario(codigoUsuario);
        Observador observadorAtual = usuario.criaObservadorUsario();
        if(observadorAtual != null){
            observaLivro = new ObservaLivro(reservas);
            observaLivro.registraObservador(observadorAtual);
            observaLivro.verificaReservaSimultaneas(codigoLivro);
        }
    }

    public void consultaLivro(int codigoLivro){

        List<Exemplar> exemplaresLivro = biblioteca.getExemplaresLivro(codigoLivro);
        List<ReservaLivroUsuario> reservasLivro = buscaReservasLivro(codigoLivro);

        for(Exemplar exemplar: exemplaresLivro){
            System.out.println("Título: " + exemplar.getTituloExemplar() + ", Codigo Exemplar: " + exemplar.getCodigoExemplar() + ", Status: " + exemplar.getNomeStatus());
            if(exemplar.getStatus() == Status.StatusEnum.EMPRESTADO){
                IEmprestimo emprestimo = buscaEmprestimoLivro(exemplar);

                System.out.println("Emprestado para: " + emprestimo.getNomeUsuarioEmprestimo() + ", Data Emprestimo: " + emprestimo.getData() + ", Data Prevista de Devolucao " + emprestimo.getDataPrevistaEmprestimo());
            }
        }
        if(!reservasLivro.isEmpty()){
            for(ReservaLivroUsuario reserva: reservasLivro){
                if(reserva.getIdLivroReserva() == codigoLivro){
                    System.out.println("Nome do Usario da Reserva: " + reserva.getNomeReserva());
                }
            }
        }
        
    }

    public void consultaHistorico(int codigoUsuario){

        historico.getInformaHistoricoEmprestimoUsuario(codigoUsuario);
        historico.getInformaHistoricoReservaUsuario(codigoUsuario);
        
    }

    public void consultaQtdNotificacao(int codigoUsuario){
        Usuario usuario = buscaUsario(codigoUsuario);
        Observador observadorAtual = usuario.getObservadorUsuario();
        
        if(observadorAtual != null){
            observadorAtual.display();
        } 
    }

    public void sairDoSistema() {
		System.out.println("Saindo do sistema de biblioteca");
		System.exit(0);
	}

}