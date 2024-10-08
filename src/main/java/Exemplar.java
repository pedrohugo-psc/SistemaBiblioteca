/**
 * Classe que representa um exemplar de um livro em uma biblioteca.
 * Contém informações sobre o livro associado, seu código único, status atual e métodos para gerenciá-los
 */
public class Exemplar {

    private ILivro livro;
    private int codigoExemplar;
    private Status.StatusEnum status;

    public Exemplar(ILivro livro, int codigoExemplar, Status.StatusEnum disponivel){
        this.livro = livro;
        this.codigoExemplar = codigoExemplar;
        this.status = Status.StatusEnum.DISPONIVEL;
    }

    public int getIdLivro(){

        return livro.getIdLivro();

    }

    public int getCodigoExemplar(){

        return codigoExemplar;
    }

    public Status.StatusEnum getStatus(){
        return status;
    }

    public void setStatus(Status.StatusEnum statusNovo){
        this.status = statusNovo;
    }

    public String getTituloExemplar(){
        return livro.getTitulo();
    }

    public String getNomeStatus(){
        if(status == Status.StatusEnum.DISPONIVEL) return "Disponivel";
        else if(status == Status.StatusEnum.RESERVADO) return "Reservado";
        else return "Emprestado";
    }

}
