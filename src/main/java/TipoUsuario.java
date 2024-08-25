import java.time.LocalDate;

public interface TipoUsuario {

    public TipoUsuario obterTipoUsuario();
    public IRegra getRegraTipoUsuario();
    public int getTipoUsuario();
    public LocalDate getDataPrevistaDevolucao();
    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo);

}