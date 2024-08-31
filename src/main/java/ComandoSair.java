/**
 * Classe que implementa o comando de saída do sistema.
 * Ao ser executado, encerra a instância do SistemaEmprestimo.
 * Não requer parâmetros adicionais.
 */
public class ComandoSair implements Comando{

    @Override
    public void executar(String[] parametros) {
        SistemaEmprestimo.getInstancia().sairDoSistema();
    }

}
