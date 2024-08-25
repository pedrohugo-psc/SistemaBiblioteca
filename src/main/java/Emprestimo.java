import java.time.LocalDate;

public class Emprestimo implements IEmprestimo{

     private  Exemplar exemplar;
     private  Usuario usuario;
     private  LocalDate data;

     public Emprestimo(Exemplar exemplar, Usuario usuario){
          this.data = LocalDate.now();
          this.exemplar = exemplar;
          this.usuario = usuario;
          this.usuario.setDataPrevistaUsuario(data);
     }

     public int getIdLivro(){

          return exemplar.getIdLivro();

     }

     public int getIdUsuario(){

          return usuario.getIdUsuario();

     }

     public LocalDate getData() {
          return data;
     }

     public Exemplar getExemplar(){
          return exemplar;
     }

     public int getIdExemplarEmprestimo(){
          return exemplar.getCodigoExemplar();
     }

     public String getNomeUsuarioEmprestimo(){
          return usuario.getNome();
     }

     public LocalDate getDataPrevistaEmprestimo(){
          return usuario.getDataPrevistaUsuario();
     }

     public Status.StatusEnum getStatusEmprestimo(){
          return exemplar.getStatus();
     }

     public String getTituloEmprestimo(){
          return exemplar.getTituloExemplar();
     }

}