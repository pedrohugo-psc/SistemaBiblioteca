
public class ComandoSair implements Comando{

    @Override
    public void executar(String[] parametros) {
        SistemaEmprestimo.getInstancia().sairDoSistema();
    }

}
