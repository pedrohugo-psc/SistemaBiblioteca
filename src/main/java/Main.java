import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

public class Main {
  public static void main(String[] args) {
    Usuario usr1 = new Usuario("Joao", 1, new Aluno());
    Usuario usr2 = new Usuario("Maria", 2, new Professor());
    Usuario usr3 = new Usuario("Pedro", 3, new AlunoPosGraduacao());

    List<Usuario> usuarios = new ArrayList<>();

    usuarios.add(usr1);
    usuarios.add(usr2);
    usuarios.add(usr3);

    List<String> autores = new ArrayList<String>();

    autores.add("Jose");
    autores.add("Raimundo");
    autores.add("Tereza");

    ILivro lvr1 = new Livro("Editora 1", 2020, "Titulo 1", 1, 1, autores);
    ILivro lvr2 = new Livro("Editora 2", 2021, "Titulo 2", 2, 2, autores);
    ILivro lvr3 = new Livro("Editora 3", 2022, "Titulo 3", 3, 3, autores);
    ILivro lvr4 = new Livro("Editora 4", 2023, "Titulo 4", 4, 4, autores);
    ILivro lvr5 = new Livro("Editora 5", 2024, "Titulo 5", 5, 5, autores);

    Exemplar exp = new Exemplar(lvr1, 1, Status.StatusEnum.DISPONIVEL);
    Exemplar exp1 = new Exemplar(lvr2, 2, Status.StatusEnum.DISPONIVEL);
    Exemplar exp2 = new Exemplar(lvr3, 3, Status.StatusEnum.DISPONIVEL);
    Exemplar exp3 = new Exemplar(lvr4, 4, Status.StatusEnum.DISPONIVEL);
    Exemplar exp4 = new Exemplar(lvr5, 5, Status.StatusEnum.DISPONIVEL);
    

    List<Exemplar> exemplares = new ArrayList<Exemplar>();

    exemplares.add(exp);
    exemplares.add(exp1);
    exemplares.add(exp2);
    exemplares.add(exp3);
    exemplares.add(exp4);

    Biblioteca biblioteca = new Biblioteca(exemplares);

    // IEmprestimo emprestimo = new Emprestimo(lvr1.getIdLivro(),usr1.getidUsuario(), exp);

    SistemaEmprestimo sistema = new SistemaEmprestimo(biblioteca, usuarios);

    LocalDate dataAtual = LocalDate.now();

    // sistema.processaEmprestimo(lvr1.getIdLivro(), usr2.getidUsuario());
    // sistema.processaEmprestimo(lvr1.getIdLivro(), usr2.getidUsuario());
    // sistema.processaEmprestimo(lvr2.getIdLivro(), usr2.getidUsuario());
    // sistema.processaEmprestimo(lvr3.getIdLivro(), usr2.getidUsuario());
    // sistema.processaEmprestimo(lvr4.getIdLivro(), usr2.getidUsuario());
    // sistema.processaEmprestimo(lvr5.getIdLivro(), usr2.getidUsuario());

    sistema.processaReserva(lvr1.getIdLivro(), usr3.getidUsuario());
    sistema.processaReserva(lvr2.getIdLivro(), usr3.getidUsuario());
    sistema.processaReserva(lvr3.getIdLivro(), usr3.getidUsuario());
    sistema.processaReserva(lvr4.getIdLivro(), usr3.getidUsuario());

    sistema.processaEmprestimo(lvr1.getIdLivro(), usr3.getidUsuario());

    sistema.processaDevolucao(lvr1.getIdLivro(), usr3.getidUsuario());

    sistema.processaDevolucao(lvr1.getIdLivro(), usr3.getidUsuario());

    // sistema.processaDevolucao(lvr1.getIdLivro(), usr3.getidUsuario());

    // sistema.processaEmprestimo(lvr1.getIdLivro(), usr3.getidUsuario());

    // sistema.processaReserva(lvr1.getIdLivro(), usr3.getidUsuario());

    // sistema.processaEmprestimo(lvr1.getIdLivro(), usr3.getidUsuario());

    // sistema.processaEmprestimo(lvr1.getIdLivro(), usr3.getidUsuario());

    // sistema.processaReserva(lvr1.getIdLivro(), usr3.getidUsuario());

    System.out.println("Hello world");
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}