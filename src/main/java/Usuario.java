import java.time.LocalDate;
/**
 * Classe que representa um usuário no sistema de biblioteca.
 * Cada usuário possui um nome, um ID único e um tipo de usuário (aluno, professor, etc.) que define suas regras e comportamentos específicos.
 */
public class Usuario {
    private String nome;
    private int idUsuario;
    private TipoUsuario tipoUsuario; 

    public Usuario(String nome, int idUsuario, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() {
        return this.idUsuario;
    }

    public String getNome(){
        return this.nome;
    }

    public TipoUsuario getTipoUsuario(){
        return this.tipoUsuario;
    }

    public IRegra getRegraUsuario(){
        return this.tipoUsuario.getRegraTipoUsuario();
    }

    public void setDataPrevistaUsuario(LocalDate dataEmprestimo){
       this.tipoUsuario.setDataPrevistaDevolucao(dataEmprestimo);
    }

    public LocalDate getDataPrevistaUsuario(){
        return this.tipoUsuario.getDataPrevistaDevolucao();
    }

    public Observador criaObservadorUsario(){
        return this.tipoUsuario.criaObservador();
    }

    public Observador getObservadorUsuario(){
        return this.tipoUsuario.getObservador();
    }
    
}
