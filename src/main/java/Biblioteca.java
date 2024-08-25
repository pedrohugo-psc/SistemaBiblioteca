import java.util.List;
import java.util.ArrayList;

public class Biblioteca{

    private List<Exemplar> exemplares;

    public Biblioteca(List<Exemplar> exemplares){
        this.exemplares = exemplares;
    }

    public List<Exemplar> getExemplares(){
        return exemplares;
    }

    public boolean buscaStatusDisponivel(int idLivro){

        for (Exemplar exemplar : exemplares) {
            if ((exemplar.getIdLivro() == idLivro) && exemplar.getStatus() == Status.StatusEnum.DISPONIVEL) {
                return true;
            }
        }
        return false;
    }

    public Exemplar buscaExemplar(int codigoLivro){
        
        for(Exemplar exemplar: exemplares){
            if(exemplar.getIdLivro() == codigoLivro){
                return exemplar;
            }
        }
		return null;
    }

    public void setExemplarBibliotecaEmprestado(Exemplar exemplar){
        exemplar.setStatus(Status.StatusEnum.EMPRESTADO);
    }

    public void setExemplarBibliotecaDisponivel(Exemplar exemplar){
        exemplar.setStatus(Status.StatusEnum.DISPONIVEL);
    }

    public Exemplar getExemplarDisponivel(int codigoLivro){

        for(Exemplar exemplar: exemplares){
            if((exemplar.getIdLivro() == codigoLivro) && ((exemplar.getStatus() == Status.StatusEnum.DISPONIVEL))){
                return exemplar;
            }
        }
        
        return null;
    }

    public Exemplar getExemplarReservado(int codigoLivro){

        for(Exemplar exemplar: exemplares){
            if((exemplar.getIdLivro() == codigoLivro) && ((exemplar.getStatus() == Status.StatusEnum.RESERVADO))){
                return exemplar;
            }
        }
        return null;
    }

    public List<Exemplar> getExemplaresLivro(int codigoLivro){
        List<Exemplar> exemplaresLivro = new ArrayList<>();

        for(Exemplar exemplar: exemplares){
            if(exemplar.getIdLivro() == codigoLivro){
                exemplaresLivro.add(exemplar);
            }
        }
        
        return exemplaresLivro;
    }
    

}