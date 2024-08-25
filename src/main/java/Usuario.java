public class Usuario {
    private String nome;
    private int idUsuario;
    private TipoUsuario tipoUsuario; 

    public Usuario(String nome, int idUsuario, TipoUsuario tipoUsuario) {
        this.nome = nome;
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public int getidUsuario() {
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
}
