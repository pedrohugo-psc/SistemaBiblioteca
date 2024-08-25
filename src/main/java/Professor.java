import java.time.LocalDate;

public class Professor implements TipoUsuario{

    private static IRegra regra = new RegraProfessor();
    private int idTipoUsario;
    private LocalDate dataPrevistaDevolucao;

    public Professor(){
        this.idTipoUsario = 3;
        this.dataPrevistaDevolucao = null;
    }
    
    public TipoUsuario obterTipoUsuario() {
        return new Professor();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

    public int getTipoUsuario(){
        return idTipoUsario;
    }

    public LocalDate getDataPrevistaDevolucao(){
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo){
        IDataPrevista dataPrevista = new DataPrevistaProfessor(dataEmprestimo);
        this.dataPrevistaDevolucao = dataPrevista.getDataPrevista();
    }

}
