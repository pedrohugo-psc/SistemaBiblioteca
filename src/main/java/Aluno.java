import java.time.LocalDate;

/**
 * Classe que representa um Aluno dentro do sistema de biblioteca, implementando a interface TipoUsuario.
 * Alunos possuem regras específicas para empréstimos e devoluções, definidas pela classe RegraAluno.
 * Não é possível criar observadores para alunos, conforme indicado no método criaObservador.
 */
public class Aluno implements TipoUsuario{

    private static IRegra regra = new RegraAluno();
    private LocalDate dataPrevistaDevolucao;

    public Aluno(){
        this.dataPrevistaDevolucao = null;
    }

    public TipoUsuario obterTipoUsuario() {
        return new Aluno();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

    public LocalDate getDataPrevistaDevolucao(){
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo){
        IDataPrevista dataPrevista = new DataPrevistaAluno(dataEmprestimo);
        this.dataPrevistaDevolucao = dataPrevista.getDataPrevista();
    }

    public Observador criaObservador(){
        System.out.println("Nao eh possivel criar observador para um aluno");
        return null;
    }

    public Observador getObservador(){
        return null;
    }

}