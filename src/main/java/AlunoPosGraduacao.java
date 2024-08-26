import java.time.LocalDate;

public class AlunoPosGraduacao implements TipoUsuario{

    private static IRegra regra = new RegraAlunoPosGraduacao();
    private int idTipoUsario;
    private LocalDate dataPrevistaDevolucao;

    public AlunoPosGraduacao(){
        this.idTipoUsario = 2;
    }
    
    public TipoUsuario obterTipoUsuario() {
        return new AlunoPosGraduacao();
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
