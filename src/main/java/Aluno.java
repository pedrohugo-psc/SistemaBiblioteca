public class Aluno implements TipoUsuario{

    private static IRegra regra = new RegraAluno();

    public TipoUsuario obterTipoUsuario() {
        return new Aluno();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

}