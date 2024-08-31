import java.util.Scanner;

/**
 * Classe responsável por gerenciar a interação com o usuário e a execução de comandos.
 * Utiliza um Controlador para processar os comandos inseridos pelo usuário através de um Scanner.
 * Mantém um loop infinito para receber e processar comandos até que o usuário decida sair do sistema.
 */
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