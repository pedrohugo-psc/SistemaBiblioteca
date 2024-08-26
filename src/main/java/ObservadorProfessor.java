public class ObservadorProfessor implements Observador{

  private int registraNotificacao = 0;

	public void update(ObservaLivro observaLivro) {

    this.registraNotificacao++; 
	}

  public void display(){
    System.out.println("Numero de notificacao: " + this.registraNotificacao);
  }
  
}