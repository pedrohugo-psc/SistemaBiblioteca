import java.time.LocalDate;

/**
 * Classe que implementa a interface IDataPrevista para calcular a data prevista de devolução para alunos.
 * A data prevista é calculada adicionando 3 dias à data de empréstimo.
 */
public class DataPrevistaAluno implements IDataPrevista{
  private LocalDate dataPrevista;
  
  public void setDataPrevista(LocalDate dataEmprestimo){
    this.dataPrevista = dataEmprestimo.plusDays(3);
  }
  
  public LocalDate getDataPrevista(){
    return dataPrevista;
  }
}