import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HistoricoEmprestimos{

  private List<IEmprestimo> historico_emprestimos;
  private List<LocalDate>data_emprestimos;
  private List<Status.StatusEnum>status_emprestimos;

  public HistoricoEmprestimos(){
    this.historico_emprestimos = new ArrayList<>();
    this.data_emprestimos = new ArrayList<>();
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

  public void informaHistoricoEmprestimoUsuario(int codigoUsuario){
    for(int i = 0; i < historico_emprestimos.size(); i++){
      if(historico_emprestimos.get(i).getIdUsuario() == codigoUsuario){
        System.out.println("Titulo: " + historico_emprestimos.get(i).getTituloEmprestimo());
        System.out.println("Data de Emprestimo: " + historico_emprestimos.get(i).getData());
        System.out.println("Data de Devolucao: " + historico_emprestimos.get(i).getDataPrevistaEmprestimo());
        System.out.println("Status: " + status_emprestimos.get(i));
      }
    }
  }
  
}