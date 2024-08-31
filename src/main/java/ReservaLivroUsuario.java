/**
 * Classe que representa uma reserva de um livro por um usuário.
 * Ao criar uma reserva, o status do exemplar é automaticamente alterado para "RESERVADO".
 */
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
    return usuario.getIdUsuario();
  }

  public int getIdLivroReserva(){
    return exemplar.getIdLivro();
  }

  public String getNomeReserva(){
    return usuario.getNome();
  }

  public String getTituloReserva(){
    return exemplar.getTituloExemplar();
  }
  
}