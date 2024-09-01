import java.time.LocalDate;

/**
 * Classe que representa um Aluno de Pós-Graduação dentro do sistema de biblioteca, implementando a interface TipoUsuario.
 * Alunos de Pós-Graduação possuem regras específicas para empréstimos e devoluções, definidas pela classe RegraAlunoPosGraduacao.
 * Assim como os alunos de graduação, não é possível criar observadores para alunos de pós-graduação.
 */
public class AlunoPosGraduacao implements TipoUsuario{

    private IRegra regra;
    private IDataPrevista dataPrevistaDevolucao;

    public AlunoPosGraduacao(){
        this.regra = new RegraAlunoPosGraduacao();
        this.dataPrevistaDevolucao = new DataPrevistaProfessor();
    }
    
    public TipoUsuario obterTipoUsuario() {
        return new AlunoPosGraduacao();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

    public LocalDate getDataPrevistaDevolucao(){
        return dataPrevistaDevolucao.getDataPrevista();
    }

    public void setDataPrevistaDevolucao(LocalDate dataEmprestimo){
        this.dataPrevistaDevolucao.setDataPrevista(dataEmprestimo);
    }

    public Observador criaObservador(){
        System.out.println("Nao eh possivel criar observador para um aluno pos graduacao");

        return null;
    }

    public Observador getObservador(){
        return null;
    }
    
}
