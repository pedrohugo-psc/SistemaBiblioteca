import java.util.ArrayList;
import java.util.List;
/**
 * Classe que representa um livro sendo observado para notificar observadores sobre reservas simultâneas.
 * Mantém uma lista de observadores e uma lista de reservas.
 * Permite registrar observadores e notificá-los quando múltiplas reservas são feitas para o mesmo livro.
 */
public class ObservaLivro{

  private ArrayList<Observador> observadores;

  public ObservaLivro(){
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

  public void verificaReservaSimultaneas(int idLivro, List<ReservaLivroUsuario> reservas){
    int contador = 0;
    for(ReservaLivroUsuario reserva: reservas){
      if(reserva.getExemplar().getIdLivro() == idLivro){
        contador++;
        if(contador >= 2) notificaObservadores();
      }
    }
  }

  
}