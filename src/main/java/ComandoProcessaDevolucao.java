/**
 * Classe que implementa o comando de processamento de devolução de um livro.
 * Recebe o ID do usuário e o ID do livro como parâmetros e delega o processamento ao SistemaEmprestimo.
 * Em caso de parâmetros inválidos, exibe uma mensagem de erro.
 */
public class ComandoProcessaDevolucao implements Comando{

    @Override
    public void executar(String[] parametros){
        if (parametros.length >= 3) {
            String idUsuario = parametros[1];
            String idLivro = parametros[2];
            
            int codigoUsuario = Integer.parseInt(idUsuario);
            int codigoLivro = Integer.parseInt(idLivro);

            SistemaEmprestimo.getInstancia().processaDevolucao(codigoLivro,codigoUsuario);
        } else {
            System.out.println("Comando inválido. Informe o ID do usuário e do livro que estejam cadastrados no sistema.");
        }
    }

}
