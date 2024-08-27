import java.time.LocalDate;

public class Professor implements TipoUsuario{

    private static IRegra regra = new RegraProfessor();
    private LocalDate dataPrevistaDevolucao;
    Observador observadorProfessor;

    public Professor(){
        this.dataPrevistaDevolucao = null;
    }
    
    public TipoUsuario obterTipoUsuario() {
        return new Professor();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

    public LocalDate getDataPrevistaDevolucao(){
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo){
        IDataPrevista dataPrevista = new DataPrevistaProfessor(dataEmprestimo);
        this.dataPrevistaDevolucao = dataPrevista.getDataPrevista();
    }

    public Observador criaObservador(){
        this.observadorProfessor = new ObservadorProfessor();

        return observadorProfessor;
    }

    public Observador getObservador(){
        return observadorProfessor;
    }

}
