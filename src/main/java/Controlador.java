import java.util.HashMap;

public class Controlador {
	private HashMap<String, Comando> comandos = new HashMap<String, Comando>();;

    public Controlador() {
        iniciaComandos();
    }

    public void iniciaComandos() {
        comandos.put("emp", new ComandoProcessaEmprestimo());
        comandos.put("dev", new ComandoProcessaDevolucao());
        comandos.put("res", new ComandoProcessaReserva());
        comandos.put("obs", new ComandoProcessaObervador());
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