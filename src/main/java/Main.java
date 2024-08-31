import java.util.ArrayList;
import java.util.List;
/**
 * Classe principal que inicia a aplicação de sistema de empréstimo de biblioteca.
 * Cria usuários, livros, exemplares e configura o sistema de empréstimo.
 * Em seguida, inicia o gerenciador de comandos para interagir com o usuário.
 */
public class Main {
  public static void main(String[] args) {
    Usuario usr1 = new Usuario("Joao da Silva", 123, new Aluno());
    Usuario usr2 = new Usuario("Luiz Fernando Rodrigues", 456, new AlunoPosGraduacao());
    Usuario usr3 = new Usuario("Pedro Paulo", 789, new Aluno());
    Usuario usr4 = new Usuario("Carlos Lucena", 100, new Professor());

    List<Usuario> usuarios = new ArrayList<>();

    usuarios.add(usr1);
    usuarios.add(usr2);
    usuarios.add(usr3);
    usuarios.add(usr4);

    List<String> autores1 = new ArrayList<String>();
    List<String> autores2 = new ArrayList<String>();
    List<String> autores3 = new ArrayList<String>();
    List<String> autores4 = new ArrayList<String>();
    List<String> autores5 = new ArrayList<String>();
    List<String> autores6 = new ArrayList<String>();
    List<String> autores7 = new ArrayList<String>();
    List<String> autores8 = new ArrayList<String>();

    autores1.add("Ian Sommervile");

    autores2.add("Grady Booch");
    autores2.add("James Rumbaugh");
    autores2.add(" Ivar Jacobson");

    autores3.add("Steve McConnell");

    autores4.add("Robert Martin ");

    autores5.add("Martin Fowler");

    autores6.add("Norman Fenton");
    autores6.add("James Bieman");

    autores7.add("Erich Gamma");
    autores7.add("Richard Helm");
    autores7.add("Ralph Johnson");
    autores7.add("John Vlisside");

    autores8.add("Martin Fowler ");

    ILivro lvr1 = new Livro("AddisonWesley", 2000, "Engenharia de Software", 6, 100, autores1);
    ILivro lvr2 = new Livro("Campus", 2000, "UML - Guia do Usuario", 7, 101, autores2);
    ILivro lvr3 = new Livro("Microsoft Press", 2014, "Code Complete", 2, 200, autores3);
    ILivro lvr4 = new Livro("Prentice Hall", 2002, "Agile Software Development, Principles, Patterns, and Practices", 1, 201, autores4);
    ILivro lvr5 = new Livro("Addison-Wesley Professional", 1999, "Refactoring: Improving the Design of Existing Code", 1, 300, autores5);
    ILivro lvr6 = new Livro("CRC Press", 2014, "Software Metrics: A Rigorous and Practical Approach", 3, 301, autores6);
    ILivro lvr7 = new Livro("Addison-Wesley Professional", 1994, "Design Patterns: Elements of Reusable Object-Oriented Software", 1, 400, autores7);
    ILivro lvr8 = new Livro("Addison-Wesley Professional", 2003, "UML Distilled: A Brief Guide to the Standard Object Modeling Language", 3, 401, autores8);
    
    Exemplar exp1 = new Exemplar(lvr1, 1, Status.StatusEnum.DISPONIVEL);
    Exemplar exp2 = new Exemplar(lvr1, 2, Status.StatusEnum.DISPONIVEL);
    Exemplar exp3 = new Exemplar(lvr2, 3, Status.StatusEnum.DISPONIVEL);
    Exemplar exp4 = new Exemplar(lvr3, 4, Status.StatusEnum.DISPONIVEL);
    Exemplar exp5 = new Exemplar(lvr4, 5, Status.StatusEnum.DISPONIVEL);
    Exemplar exp6 = new Exemplar(lvr5, 6, Status.StatusEnum.DISPONIVEL);   
    Exemplar exp7 = new Exemplar(lvr5, 7, Status.StatusEnum.DISPONIVEL);
    Exemplar exp8 = new Exemplar(lvr7, 8, Status.StatusEnum.DISPONIVEL);
    Exemplar exp9 = new Exemplar(lvr7, 9, Status.StatusEnum.DISPONIVEL);
    
    List<Exemplar> exemplares = new ArrayList<Exemplar>();

    exemplares.add(exp1);
    exemplares.add(exp2);
    exemplares.add(exp3);
    exemplares.add(exp4);
    exemplares.add(exp5);
    exemplares.add(exp6);
    exemplares.add(exp7);
    exemplares.add(exp8);
    exemplares.add(exp9);

    Biblioteca biblioteca = new Biblioteca(exemplares);

    SistemaEmprestimo sistema = SistemaEmprestimo.getInstancia();

    sistema.insereDadosIniciais(biblioteca, usuarios);

    GerenciadorComandos gerencia = new GerenciadorComandos();
		gerencia.getComando();

  }

}