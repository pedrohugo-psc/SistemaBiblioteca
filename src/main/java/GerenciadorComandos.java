import java.util.Scanner;

public class GerenciadorComandos { 
	Controlador servico = new Controlador();
	private Scanner scanner = new Scanner(System.in);
	
	public void getComando() {
		while (true) {
			System.out.println("Insira um comando: ");
			String input = scanner.nextLine();
			
			servico.invoca(input);
		}
		
	}
	
}