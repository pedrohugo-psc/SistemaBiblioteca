/**
 * Classe que implementa o comando de consulta da quantidade de notificações de um usuário.
 * Recebe o ID do usuário como parâmetro e delega a consulta ao SistemaEmprestimo.
 * Em caso de parâmetros inválidos, exibe uma mensagem de erro.
 */
public class ComandoConsultaQtdNotificacao implements Comando {

    @Override
    public void executar(String[] parametros) {
        if (parametros.length >= 2) {
            String idUsuario = parametros[1];
            int codigoUsuario = Integer.parseInt(idUsuario);

            SistemaEmprestimo.getInstancia().consultaQtdNotificacao(codigoUsuario);
        } else {
            System.out.println("Comando inválido. Informe o ID do usuário que esteja cadastrado no sistema.");
        }
    }

}
