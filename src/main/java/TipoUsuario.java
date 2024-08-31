import java.time.LocalDate;
/**
 * Interface que define o comportamento básico de um tipo de usuário no sistema de biblioteca.
 * Classes que implementam esta interface devem fornecer métodos para:
 * - Obter o tipo de usuário.
 * - Obter a regra de empréstimo associada ao tipo de usuário.
 * - Obter e definir a data prevista de devolução de um empréstimo.
 * - Criar e obter um observador, se aplicável ao tipo de usuário.
 */
public interface TipoUsuario {

    public TipoUsuario obterTipoUsuario();
    public IRegra getRegraTipoUsuario();
    public LocalDate getDataPrevistaDevolucao();
    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo);
    public Observador criaObservador();
    public Observador getObservador();

}