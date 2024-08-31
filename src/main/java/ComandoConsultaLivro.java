/**
 * Classe que implementa o comando de consulta de informações sobre um livro.
 * Recebe o ID do livro como parâmetro e delega a consulta ao SistemaEmprestimo.
 * Em caso de parâmetros inválidos, exibe uma mensagem de erro (a mensagem de erro parece estar incorreta, deveria solicitar o ID do livro).
 */
public class ComandoConsultaLivro implements Comando{

    @Override
    public void executar(String[] parametros) {
        if (parametros.length >= 2) {
            String idLivro = parametros[1];
            int codigoLivro = Integer.parseInt(idLivro);

            SistemaEmprestimo.getInstancia().consultaLivro(codigoLivro);
        } else {
            System.out.println("Comando inválido. Informe o ID do usuário que esteja cadastrado no sistema.");
        }
        
        
    }

}
