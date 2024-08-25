public class AlunoPosGraduacao implements TipoUsuario{

    private static IRegra regra = new RegraAlunoPosGraduacao();

    public TipoUsuario obterTipoUsuario() {
        return new AlunoPosGraduacao();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

}
