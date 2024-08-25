public class ReservaLivroUsuario{
  Exemplar exemplar;
  Usuario usuario;
  
  public ReservaLivroUsuario(Exemplar exemplar, Usuario usuario){
    this.exemplar = exemplar;
    this.usuario = usuario;
    this.exemplar.setStatus(Status.StatusEnum.RESERVADO);
  }

  public Exemplar getExemplar(){
    return exemplar;
  }

  public Usuario getUsuario(){
    return usuario;
  }

  public int getIdUsarioReserva(){
    return usuario.getidUsuario();
  }

  public int getIdLivroReserva(){
    return exemplar.getIdLivro();
  }
}