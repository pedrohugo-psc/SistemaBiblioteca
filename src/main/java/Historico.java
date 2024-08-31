/**
 * Classe que representa o histórico de empréstimos e reservas de um usuário.
 * Gerencia o registro de empréstimos e devoluções através de um HistoricoEmprestimos
 * e o registro de reservas através de um HistoricoReserva.
 * Permite adicionar novos registros de empréstimos, devoluções e reservas,
 * além de fornecer informações sobre o histórico de empréstimos e reservas de um usuário específico.
 */
public class Historico{
  
  HistoricoEmprestimos registro_emprestimo;
  HistoricoReserva registro_reserva;

  public Historico(){
    this.registro_emprestimo = new HistoricoEmprestimos();
    this.registro_reserva = new HistoricoReserva();
  }

  public void setRegistroEmprestimos(IEmprestimo emprestimo){

    registro_emprestimo.setHistoricoEmprestimo(emprestimo);
    
  }

  public void setRegistroDevolucao(IEmprestimo emprestimo){

    registro_emprestimo.setHistoricoDevolucao(emprestimo);
    
  }

  public void setRegistroReserva(ReservaLivroUsuario reserva){
      registro_reserva.setHistoricoReserva(reserva);
  }

  public void getInformaHistoricoEmprestimoUsuario(int codigoUsuario){

    registro_emprestimo.informaHistoricoEmprestimoUsuario(codigoUsuario);
    
  }

  public void getInformaHistoricoReservaUsuario(int codigoUsuario){

      registro_reserva.informaHistoricoReservaUsuario(codigoUsuario);

  }

  
  
}