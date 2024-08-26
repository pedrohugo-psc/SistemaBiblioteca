import java.util.ArrayList;
import java.util.List;

public class ObservaLivro{

  private ArrayList<Observador> observadores;
  private List<ReservaLivroUsuario> reservas;

  public ObservaLivro(List<ReservaLivroUsuario> reservas){
    this.reservas = reservas;
    observadores = new ArrayList<>();
  }

  public void registraObservador(Observador observador){
    observadores.add(observador);
  }

  public void notificaObservadores() {
      for (int i = 0; i < observadores.size(); i++) {
          Observador observador = observadores.get(i);
            observador.update(this);
      }
  }

  public void verificaReservaSimultaneas(int idLivro){
    int contador = 0;
    for(ReservaLivroUsuario reserva: reservas){
      if(reserva.getExemplar().getIdLivro() == idLivro){
        contador++;
        if(contador >= 2) notificaObservadores();
      }
    }
  }

  
}