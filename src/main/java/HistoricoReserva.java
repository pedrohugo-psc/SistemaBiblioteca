import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa o histórico de reservas de livros de um sistema.
 * Armazena informações sobre as reservas realizadas e suas respectivas datas.
 * Permite registrar novas reservas e fornecer informações sobre o histórico de reservas de um usuário específico.
 */
public class HistoricoReserva{

  private List<ReservaLivroUsuario> historico_reservas;
  private List<LocalDate>data_reservas;

  public HistoricoReserva(){
    this.historico_reservas = new ArrayList<>();
    this.data_reservas = new ArrayList<>();
  }

  public void setHistoricoReserva(ReservaLivroUsuario reserva){
    LocalDate data_reserva = LocalDate.now();
    this.historico_reservas.add(reserva);
    this.data_reservas.add(data_reserva);
  }

  public void informaHistoricoReservaUsuario(int codigoUsuario){
    for(int i = 0; i < historico_reservas.size(); i++){
      if(historico_reservas.get(i).getIdUsarioReserva() == codigoUsuario){
        System.out.println("Titulo: " + historico_reservas.get(i).getTituloReserva());
        System.out.println("Data da Reserva: " + data_reservas.get(i));
      }
    }
  }
  
  
}