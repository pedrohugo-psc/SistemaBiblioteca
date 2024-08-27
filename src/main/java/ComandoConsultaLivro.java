
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
