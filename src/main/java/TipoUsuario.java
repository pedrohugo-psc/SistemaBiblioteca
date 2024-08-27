import java.time.LocalDate;

public interface TipoUsuario {

    public TipoUsuario obterTipoUsuario();
    public IRegra getRegraTipoUsuario();
    public LocalDate getDataPrevistaDevolucao();
    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo);
    public Observador criaObservador();
    public Observador getObservador();

}