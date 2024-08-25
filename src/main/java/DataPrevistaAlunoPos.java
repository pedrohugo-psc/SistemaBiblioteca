import java.time.LocalDate;

public class DataPrevistaAlunoPos implements IDataPrevista{
  private LocalDate dataPrevista;

  public DataPrevistaAlunoPos(LocalDate dataEmprestimo){
    this.dataPrevista = dataEmprestimo.plusDays(5);
  }

  public LocalDate getDataPrevista(){
    return dataPrevista;
  }
}