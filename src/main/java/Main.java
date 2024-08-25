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

    Exemplar exp = new Exemplar(lvr1, 1, Status.StatusEnum.DISPONIVEL);
    Exemplar exp1 = new Exemplar(lvr2, 2, Status.StatusEnum.DISPONIVEL);

    List<Exemplar> exemplares = new ArrayList<Exemplar>();

    exemplares.add(exp);
    exemplares.add(exp1);

    Biblioteca biblioteca = new Biblioteca(exemplares);

    // IEmprestimo emprestimo = new Emprestimo(lvr1.getIdLivro(),usr1.getidUsuario(), exp);

    SistemaEmprestimo sistema = new SistemaEmprestimo(biblioteca, usuarios);

    LocalDate dataAtual = LocalDate.now();

    sistema.processaEmprestimo(lvr1.getIdLivro(), usr1.getidUsuario());
    sistema.processaEmprestimo(lvr1.getIdLivro(), usr1.getidUsuario());
    sistema.processaEmprestimo(lvr2.getIdLivro(), usr1.getidUsuario());

    sistema.processaDevolucao(lvr1.getIdLivro(), usr1.getidUsuario());

    // sistema.processaEmprestimo(lvr1.getIdLivro(), usr1.getidUsuario());

    sistema.processaReserva(lvr1.getIdLivro(), usr1.getidUsuario());

    sistema.processaEmprestimo(lvr1.getIdLivro(), usr1.getidUsuario());

    sistema.processaEmprestimo(lvr1.getIdLivro(), usr1.getidUsuario());

    sistema.processaReserva(lvr1.getIdLivro(), usr1.getidUsuario());

    System.out.println("Hello world");
  }

  // @Test
  // void addition() {
  //     assertEquals(2, 1 + 1);
  // }
}