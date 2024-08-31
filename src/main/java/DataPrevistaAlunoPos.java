import java.time.LocalDate;

/**
 * Classe que implementa a interface IDataPrevista para calcular a data prevista de devolução para alunos de pós-graduação.
 * A data prevista é calculada adicionando 5 dias à data de empréstimo.
 */
public class DataPrevistaAlunoPos implements IDataPrevista{
  private LocalDate dataPrevista;

  public DataPrevistaAlunoPos(LocalDate dataEmprestimo){
    this.dataPrevista = dataEmprestimo.plusDays(5);
  }

  public LocalDate getDataPrevista(){
    return dataPrevista;
  }
}