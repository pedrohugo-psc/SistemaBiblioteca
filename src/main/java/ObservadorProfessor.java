/**
 * Classe que implementa um observador específico para professores no contexto do padrão Observer.
 * Mantém um contador de notificações recebidas e exibe esse número quando solicitado.
 */
public class ObservadorProfessor implements Observador{

  private int registraNotificacao = 0;

	public void update(ObservaLivro observaLivro) {

    this.registraNotificacao++; 
	}

  public void display(){
    System.out.println("Numero de notificacao: " + this.registraNotificacao);
  }
  
}