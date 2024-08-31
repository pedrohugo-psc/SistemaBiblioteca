import java.time.LocalDate;
/**
 * Classe que representa um Professor dentro do sistema de biblioteca, implementando a interface TipoUsuario.
 * Professores possuem regras específicas para empréstimos e devoluções, definidas pela classe RegraProfessor.
 * Diferente de alunos, professores podem ter um observador associado, criado através do método criaObservador.
 */
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
