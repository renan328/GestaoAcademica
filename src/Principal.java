import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Pré-cadastro para testes
        Pessoa p1 = new Professor("Thiago Donizet", "12/03/1995", "01200-000", "11911112222", 2001, "FCI");
        Pessoa a1 = new Aluno("Mariana Silva", "15/03/2003", "01234-567", "11999999999", 101, "SI");
        Pessoa a2 = new Aluno("Bianca Dias", "03/05/2006", "04567-890", "11888888888", 102, "SI");

        Disciplina d1 = new Disciplina("ADS01", "POO", "SI");
        Disciplina d2 = new Disciplina("ADS02", "Banco de Dados", "SI");

        listaPessoas.add(p1);
        listaPessoas.add(a1);
        listaPessoas.add(a2);

        listaDisciplinas.add(d1);
        listaDisciplinas.add(d2);

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar Oferecimento");
            System.out.println("2. Buscar Oferecimento (Disciplina + Código)");
            System.out.println("3. Listar Oferecimentos de uma Disciplina");
            System.out.println("4. Detalhar Oferecimento (alunos, professor, etc.)");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir enter

            switch (opcao) {
                case 1 -> cadastrarOferecimento(scanner);
                case 2 -> buscarOferecimento(scanner);
                case 3 -> listarOferecimentos(scanner);
                case 4 -> detalharOferecimento(scanner);
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void cadastrarOferecimento(Scanner scanner) {
        System.out.print("Código da disciplina: ");
        String codDisciplina = scanner.nextLine();

        Disciplina disciplina = buscarDisciplinaPorCodigo(codDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Código do oferecimento: ");
        String codOferecimento = scanner.nextLine();

        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();
        scanner.nextLine();

        System.out.print("DRT do professor: ");
        int drt = scanner.nextInt();
        scanner.nextLine();

        Professor professor = buscarProfessorPorDrt(drt);
        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        Oferecimento oferecimento = new Oferecimento(codOferecimento, ano, semestre, professor);
        disciplina.adicionarOferecimento(oferecimento);
        professor.adicionarOferecimento(oferecimento);

        System.out.println("Oferecimento cadastrado com sucesso.");
    }

    public static void buscarOferecimento(Scanner scanner) {
        System.out.print("Código da disciplina: ");
        String codDisciplina = scanner.nextLine();

        Disciplina disciplina = buscarDisciplinaPorCodigo(codDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Código do oferecimento: ");
        String codOferecimento = scanner.nextLine();

        Oferecimento o = disciplina.buscarOferecimentoPorCodigo(codOferecimento);
        if (o == null) {
            System.out.println("Oferecimento não encontrado.");
        } else {
            o.imprimirDados();
        }
    }

    public static void listarOferecimentos(Scanner scanner) {
        System.out.print("Código da disciplina: ");
        String codDisciplina = scanner.nextLine();

        Disciplina disciplina = buscarDisciplinaPorCodigo(codDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.println("--- Oferecimentos da disciplina " + disciplina.getNomeDisciplina() + " ---");
        for (Oferecimento o : disciplina.getListaOferecimentos()) {
            System.out.println("Ano: " + o.getAno() + ", Semestre: " + o.getSemestre() + ", Código: " + o.getCodigoOferecimento() +
                    ", Professor: " + o.getProfessorResponsavel().getNomeCompleto());
        }
    }

    public static void detalharOferecimento(Scanner scanner) {
        System.out.print("Código da disciplina: ");
        String codDisciplina = scanner.nextLine();

        Disciplina disciplina = buscarDisciplinaPorCodigo(codDisciplina);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Código do oferecimento: ");
        String codOferecimento = scanner.nextLine();

        Oferecimento o = disciplina.buscarOferecimentoPorCodigo(codOferecimento);
        if (o == null) {
            System.out.println("Oferecimento não encontrado.");
        } else {
           o.imprimirDados();
        }
    }

    // Métodos auxiliares
    private static Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : listaDisciplinas) {
            if (d.getCodigoDisciplina().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

    private static Professor buscarProfessorPorDrt(int drt) {
        for (Pessoa p : listaPessoas) {
            if (p instanceof Professor prof && prof.getDrt() == drt) {
                return prof;
            }
        }
        return null;
    }
}

// Integrantes: 
// Bianca Jesus Dias – 10437274
// João Pedro Franco Watanabe Torres – 10730384
// Mariana da Silva Santos – 10722812
// Renan Rodrigues Oliveira – 10730971