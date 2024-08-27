
public class ComandoConsultaHistorico implements Comando{

    @Override
    public void executar(String[] parametros) {
        if (parametros.length >= 2) {
            String idUsuario = parametros[1];
            int codigoUsuario = Integer.parseInt(idUsuario);

            SistemaEmprestimo.getInstancia().consultaHistorico(codigoUsuario);
        } else {
            System.out.println("Comando inválido. Informe o ID do usuário que esteja cadastrado no sistema.");
        }
        
        
    }

}
