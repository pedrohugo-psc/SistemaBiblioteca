import java.time.LocalDate;

public class Aluno implements TipoUsuario{

    private static IRegra regra = new RegraAluno();
    private int idTipoUsario;
    private LocalDate dataPrevistaDevolucao;

    public Aluno(){
        this.idTipoUsario = 1;
    }

    public TipoUsuario obterTipoUsuario() {
        return new Aluno();
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
        IDataPrevista dataPrevista = new DataPrevistaAluno(dataEmprestimo);
        this.dataPrevistaDevolucao = dataPrevista.getDataPrevista();
    }

}