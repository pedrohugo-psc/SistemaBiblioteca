import java.time.LocalDate;

public class AlunoPosGraduacao implements TipoUsuario{

    private static IRegra regra = new RegraAlunoPosGraduacao();
    private LocalDate dataPrevistaDevolucao;

    public AlunoPosGraduacao(){
        this.dataPrevistaDevolucao = null;
    }
    
    public TipoUsuario obterTipoUsuario() {
        return new AlunoPosGraduacao();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

    public LocalDate getDataPrevistaDevolucao(){
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo){
        IDataPrevista dataPrevista = new DataPrevistaAlunoPos(dataEmprestimo);
        this.dataPrevistaDevolucao = dataPrevista.getDataPrevista();
    }

    public Observador criaObservador(){
        System.out.println("Nao eh possivel criar observador para um aluno pos graduacao");

        return null;
    }

    public Observador getObservador(){
        return null;
    }
    
}
