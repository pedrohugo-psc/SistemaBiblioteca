import java.time.LocalDate;

public class DataPrevistaProfessor implements IDataPrevista{
  private LocalDate dataPrevista;

  public DataPrevistaProfessor(LocalDate dataEmprestimo){
    this.dataPrevista = dataEmprestimo.plusDays(7);
  }

  public LocalDate getDataPrevista(){
    return dataPrevista;
  }
}