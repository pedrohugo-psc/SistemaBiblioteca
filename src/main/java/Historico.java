import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Historico{
  
  private List<IEmprestimo> historico_emprestimos;
  private List<ReservaLivroUsuario> historico_reservas;
  private List<LocalDate>data_emprestimos;
  private List<LocalDate>data_reservas;
  private List<Status.StatusEnum>status_emprestimos;

  public Historico(){
    this.historico_emprestimos = new ArrayList<>();
    this.historico_reservas = new ArrayList<>();
    this.data_emprestimos = new ArrayList<>();
    this.data_reservas = new ArrayList<>();
    this.status_emprestimos = new ArrayList<>();
  }

  public void setHistoricoEmprestimo(IEmprestimo emprestimo){
    Status.StatusEnum status = Status.StatusEnum.EM_CURSO;
    this.historico_emprestimos.add(emprestimo);
    this.data_emprestimos.add(emprestimo.getData());
    this.status_emprestimos.add(status);
  }

  public void setHistoricoDevolucao(IEmprestimo emprestimo){
    LocalDate data_devolucao = LocalDate.now();
    Status.StatusEnum status = Status.StatusEnum.FINALIZADO;
    this.historico_emprestimos.add(emprestimo);
    this.data_emprestimos.add(data_devolucao);
    this.status_emprestimos.add(status);
  }

  public void setHistoricoReserva(ReservaLivroUsuario reserva){
    LocalDate data_reserva = LocalDate.now();
    this.historico_reservas.add(reserva);
    this.data_reservas.add(data_reserva);
  }
  
  
}