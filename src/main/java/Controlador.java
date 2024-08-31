import java.util.HashMap;

/**
 * Classe que atua como um controlador central para o sistema de comandos.
 * Armazena um mapa de comandos, onde as chaves são strings que representam os comandos 
 * e os valores são instâncias da interface Comando.
 * Permite invocar comandos a partir de strings de entrada, realizando o tratamento e 
 * delegação para a execução do comando apropriado.
 */
public class Controlador {
	private HashMap<String, Comando> comandos = new HashMap<String, Comando>();;

    public Controlador() {
        iniciaComandos();
    }

    public void iniciaComandos() {
        comandos.put("emp", new ComandoProcessaEmprestimo());
        comandos.put("dev", new ComandoProcessaDevolucao());
        comandos.put("res", new ComandoProcessaReserva());
        comandos.put("obs", new ComandoProcessaObservador());
        comandos.put("liv", new ComandoConsultaLivro());
        comandos.put("usu", new ComandoConsultaHistorico());
        comandos.put("ntf", new ComandoConsultaQtdNotificacao());
        comandos.put("sai", new ComandoSair());
        
    }

    public void invoca(String comandoStr) {
        String[] parametros = comandoStr.split(" "); 
        String tipoComando = parametros[0];
        
        if (comandos.containsKey(tipoComando)) {
            Comando comando = comandos.get(tipoComando);
            comando.executar(parametros);
        } else {
            System.out.println("Comando inválido.");
        }
    }
}