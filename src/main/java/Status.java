/**
 * Classe que define os possíveis estados de um exemplar ou empréstimo no sistema.
 */
public class Status {
    public enum StatusEnum {
        DISPONIVEL,
        RESERVADO,
        EMPRESTADO,
        EM_CURSO,
        FINALIZADO
    }
}
