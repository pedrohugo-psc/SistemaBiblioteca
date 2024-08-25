public class Professor implements TipoUsuario{

    private static final IRegra regra = new RegraProfessor();

    public TipoUsuario obterTipoUsuario() {
        return new Professor();
    }

    public IRegra getRegraTipoUsuario(){
        return regra.getRegra();
    }

}
