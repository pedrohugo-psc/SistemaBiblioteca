/**
 * Interface que define o comportamento de um observador no padrão Observer.
 * Observadores são notificados sobre mudanças no estado de um objeto observado (ObservaLivro)
 * e podem reagir a essas mudanças de forma específica.
 */
public interface Observador {
  public void update(ObservaLivro observaLivro);
  public void display();
}