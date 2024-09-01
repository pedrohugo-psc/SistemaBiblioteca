import java.time.LocalDate;

/**
 * Classe que implementa a interface IDataPrevista para calcular a data prevista de devolução para professores.
 * A data prevista é calculada adicionando 7 dias à data de empréstimo.
 */
public class DataPrevistaProfessor implements IDataPrevista{
  private LocalDate dataPrevista;
  
  public void setDataPrevista(LocalDate dataEmprestimo){
    this.dataPrevista = dataEmprestimo.plusDays(7);
  }
  
  public LocalDate getDataPrevista(){
    return dataPrevista;
  }
}