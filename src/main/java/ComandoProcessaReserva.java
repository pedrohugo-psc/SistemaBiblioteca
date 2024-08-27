
public class ComandoProcessaReserva implements Comando{

    @Override
    public void executar(String[] parametros) {
        if (parametros.length >= 3) {
            String idUsuario = parametros[1];
            String idLivro = parametros[2];
            
            int codigoUsuario = Integer.parseInt(idUsuario);
            int codigoLivro = Integer.parseInt(idLivro);

            SistemaEmprestimo.getInstancia().processaReserva(codigoLivro, codigoUsuario);
        } else {
            System.out.println("Comando inválido. Informe o ID do usuário e do livro que estejam cadastrados no sistema.");
        }
    }

}
