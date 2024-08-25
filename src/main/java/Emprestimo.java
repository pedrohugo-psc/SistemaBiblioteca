import java.time.LocalDate;

public class Emprestimo implements IEmprestimo{

     private  int idLivro;
     private  int idUsuario;
     private  Exemplar exemplar;
     private  LocalDate data;

     public Emprestimo(int idLivro, int idUsuario, Exemplar exemplar){
          this.data = LocalDate.now();
          this.idLivro = idLivro;
          this.exemplar = exemplar;
          this.idUsuario = idUsuario;
     }

     public int getIdLivro(){

          return idLivro;

     }

     public int getIdUsuario(){

          return idUsuario;

     }

     public LocalDate getData() {
          return data;
     }

     public Exemplar getExemplar(){
          return exemplar;
     }

}