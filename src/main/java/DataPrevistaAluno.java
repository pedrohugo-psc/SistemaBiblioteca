import java.time.LocalDate;

public class DataPrevistaAluno implements IDataPrevista{
  private LocalDate dataPrevista;
  
  public DataPrevistaAluno(LocalDate dataEmprestimo){
    this.dataPrevista = dataEmprestimo.plusDays(3);
  }
  
  public LocalDate getDataPrevista(){
    return dataPrevista;
  }
}