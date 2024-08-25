import java.util.List;

public class Biblioteca{

    private List<Exemplar> exemplares;

    public Biblioteca(List<Exemplar> exemplares){
        this.exemplares = exemplares;
    }

    public List<Exemplar> getExemplares(){
        return exemplares;
    }

    public boolean buscaStatusDisponivel(int idLivro){
        boolean resultado = false;

        for (Exemplar exemplar : exemplares) {
            if ((exemplar.getIdLivro() == idLivro) && exemplar.getStatus() == Status.StatusEnum.DISPONIVEL) {
                resultado =  true;
            }
        }
        return resultado;
    }

    public Exemplar buscaExemplar(int codigoLivro){
        Exemplar exemplarEncontrado = null;
        
        for(Exemplar exemplar: exemplares){
            if(exemplar.getIdLivro() == codigoLivro){
                    exemplarEncontrado =  exemplar;
            }
        }
		return exemplarEncontrado;
    }

    public void setExemplarBibliotecaEmprestado(Exemplar exemplar){
        exemplar.setStatus(Status.StatusEnum.EMPRESTADO);
    }

    public void setExemplarBibliotecaDisponivel(Exemplar exemplar){
        exemplar.setStatus(Status.StatusEnum.DISPONIVEL);
    }

    public Exemplar getExemplarDisponivel(int codigoLivro){
        Exemplar exemplar = buscaExemplar(codigoLivro);
        
        if(exemplar != null) {
            if((exemplar.getStatus() == Status.StatusEnum.DISPONIVEL)){
                return exemplar;
            }
        }
        return null;
    }

    public Exemplar getExemplarReservado(int codigoLivro){
        Exemplar exemplar = buscaExemplar(codigoLivro);

        if(exemplar != null) {
            if((exemplar.getStatus() == Status.StatusEnum.RESERVADO)){
                return exemplar;
            }
        }
        return null;
    }
    

}