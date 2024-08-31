/**
 * Interface que representa um comando a ser executado.
 * Implementações desta interface encapsulam uma ação específica 
 * e seus parâmetros, permitindo que sejam tratadas de forma genérica.
 */
public interface Comando {
	void executar(String[] parametros);
}
