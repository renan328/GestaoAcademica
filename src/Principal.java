import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    private static ArrayList<Pessoa> listaPessoas = new ArrayList<>();
    private static ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        // Pré-cadastro para testes
        Pessoa p1 = new Professor("Thiago Donizetti", "12/03/1995", "01200-000", "11911112222", 2001, "FCI");
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

            // ALUNO
            System.out.println("1. Cadastrar Aluno");
            System.out.println("2. Buscar Aluno por RA");
            System.out.println("3. Listar todos os Alunos (RA, Curso e Nome)");
            System.out.println("4. Adicionar Aluno a Oferecimento");

            // PROFESSOR
            System.out.println("5. Cadastrar Professor");
            System.out.println("6. Buscar Professor por DRT");
            System.out.println("7. Listar todos os Professores (DRT e Nome)");

            // DISCIPLINA
            System.out.println("8. Cadastrar Disciplina");
            System.out.println("9. Buscar Disciplina por Código");
            System.out.println("10. Listar todas as Disciplinas");

            // OFERECIMENTO
            System.out.println("11. Cadastrar Oferecimento");
            System.out.println("12. Buscar Oferecimento (Disciplina + Código)");
            System.out.println("13. Listar Oferecimentos de uma Disciplina");
            System.out.println("14. Detalhar Oferecimento (Alunos, Professor, etc.)");
            
            // EXTRA
            System.out.println("15. Listar alunos sem oferecimento");
            
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                // ALUNO
                case 1 -> cadastrarAluno(scanner);
                case 2 -> buscarAlunoPorRa(scanner);
                case 3 -> listarAlunos();
                case 4 -> cadastrarAlunoEmOferecimento(scanner);

                // PROFESSOR
                case 5 -> cadastrarProfessor(scanner);
                case 6 -> buscarProfessor(scanner);
                case 7 -> listarProfessores();

                // DISCIPLINA
                case 8 -> cadastrarDisciplina(scanner);
                case 9 -> buscarDisciplina(scanner);
                case 10 -> listarTodasDisciplinas();

                // OFERECIMENTO
                case 11 -> cadastrarOferecimento(scanner);
                case 12 -> buscarOferecimento(scanner);
                case 13 -> listarOferecimentos(scanner);
                case 14 -> detalharOferecimento(scanner);

                //EXTRA
                case 15 -> listarAlunosSemOferecimentos();

                // SAIR
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // Aluno
    public static void cadastrarAluno(Scanner scanner) {
        System.out.print("RA (registro acadêmico): ");
        int ra = scanner.nextInt();
        scanner.nextLine();

        // Verifica se já existe aluno com esse RA
        if (buscarAlunoPorRa(ra) != null) {
            System.out.println("Já existe um aluno com esse RA");
            return;
        }

        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String nascimento = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Pessoa aluno = new Aluno(nome, nascimento, cep, telefone, ra, curso);
        listaPessoas.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    public static void cadastrarAlunoEmOferecimento(Scanner scanner) {
        // Solicita o RA do aluno
        System.out.print("Informe o RA do aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine();

        Aluno aluno = buscarAlunoPorRa(ra);
        if (aluno == null) {
            System.out.println("Aluno não encontrado.");
            return;
        }

        // Solicita códigos da disciplina e do oferecimento
        System.out.print("Código da disciplina: ");
        String codDisciplina = scanner.nextLine();

        if (buscarDisciplinaPorCodigo(codDisciplina) == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Código do oferecimento: ");
        String codOferecimento = scanner.nextLine();

        Oferecimento oferecimento = buscarOferecimento(codDisciplina, codOferecimento);
        if (oferecimento == null) {
            System.out.println("Oferecimento não encontrado.");
            return;
        }

        // Verifica e adiciona o aluno
        if (oferecimento.adicionarAluno(aluno)) {
            aluno.adicionarOferecimento(oferecimento.getCodigoOferecimento()); // atualiza lista do aluno
            System.out.println("Aluno matriculado com sucesso no oferecimento.");
        }
    }

    public static void buscarAlunoPorRa(Scanner scanner) {
        System.out.print("Informe o RA do aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine();

        Pessoa aluno = buscarAlunoPorRa(ra);
        if (aluno == null) {
            System.out.println("Aluno com RA " + ra + " não encontrado.");
            return;
        }

        aluno.imprimirDados();

    }

    public static void listarAlunos() {
        System.out.println("--- Lista de Alunos ---");
        boolean encontrou = false;

        for (Pessoa p : listaPessoas) {
            if (p instanceof Aluno a) {
                System.out.println("RA: " + a.getRa() + " | Nome: " + a.getNomeCompleto() + " | Curso: "
                        + a.getCursoMatriculado());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum aluno cadastrado.");
        }
    }

    // Professor
    public static void cadastrarProfessor(Scanner scanner) {
        System.out.print("DRT (único): ");
        int drt = scanner.nextInt();
        scanner.nextLine();

        // Verifica se já existe professor com esse DRT
        if (buscarProfessorPorDrt(drt) != null) {
            System.out.println("Já existe um professor com esse DRT.");
            return;
        }

        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Unidade Acadêmica: ");
        String unidade = scanner.nextLine();

        Professor professor = new Professor(nome, dataNascimento, cep, telefone, drt, unidade);
        listaPessoas.add(professor);

        System.out.println("Professor cadastrado com sucesso.");
    }

    public static void buscarProfessor(Scanner scanner) {
        System.out.print("Informe o DRT do professor: ");
        int drt = scanner.nextInt();
        scanner.nextLine();

        Professor professor = buscarProfessorPorDrt(drt);
        if (professor == null) {
            System.out.println("Professor não encontrado.");
            return;
        }

        professor.imprimirDados();

    }

    public static void listarProfessores() {
        boolean encontrou = false;

        for (Pessoa p : listaPessoas) {
            if (p instanceof Professor prof) {
                System.out.println("DRT: " + prof.getDrt() + " | Nome: " + prof.getNome());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum professor cadastrado.");
        }
    }

    // Disciplina
    public static void cadastrarDisciplina(Scanner scanner) {
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();

        if (buscarDisciplinaPorCodigo(codigo) != null) {
            System.out.println("Já existe uma disciplina com esse código.");
            return;
        }

        System.out.print("Nome da disciplina: ");
        String nome = scanner.nextLine();

        System.out.print("Curso em que é oferecida: ");
        String curso = scanner.nextLine();

        Disciplina nova = new Disciplina(codigo, nome, curso);
        listaDisciplinas.add(nova);

        System.out.println("Disciplina cadastrada com sucesso!");
    }

    public static void buscarDisciplina(Scanner scanner) {
        System.out.print("Código da disciplina: ");
        String codigo = scanner.nextLine();

        Disciplina disciplina = buscarDisciplinaPorCodigo(codigo);
        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        disciplina.imprimirDados();
    }

    public static void listarTodasDisciplinas() {
        if (listaDisciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }

        System.out.println("Lista de disciplinas:");
        for (Disciplina d : listaDisciplinas) {
            System.out.println("Código: " + d.getCodigoDisciplina() + " | Nome: " + d.getNomeDisciplina());
        }
    }

    // Oferecimento
    public static void cadastrarOferecimento(Scanner scanner) {
        Disciplina disciplina = null;

        System.out.print("Código da disciplina: ");
        String codDisciplina = scanner.nextLine();

        disciplina = buscarDisciplinaPorCodigo(codDisciplina);

        if (disciplina == null) {
            System.out.println("Disciplina não encontrada.");
            return;
        }

        System.out.print("Código do oferecimento: ");
        String codOferecimento = scanner.nextLine();

        if (buscarOferecimento(codDisciplina, codOferecimento) != null) {
            System.out.println("Já existe um Oferecimento com esse código nessa disciplina");
            return;
        }

        System.out.print("Ano: ");
        int ano = scanner.nextInt();

        System.out.print("Semestre: ");
        int semestre = scanner.nextInt();
        scanner.nextLine();

        Professor professor = null;

        while (professor == null) {
            System.out.print("Digite o DRT do professor: ");
            int drt = scanner.nextInt();
            scanner.nextLine();

            professor = buscarProfessorPorDrt(drt);

            if (professor == null) {
                System.out.println("Professor não encontrado.");
                System.out.print("Deseja tentar novamente? (s para sim / qualquer outra tecla para cancelar): ");
                String opcao = scanner.nextLine();

                if (!opcao.equalsIgnoreCase("s")) {
                    System.out.println("Cadastro cancelado.");
                    return; // Volta ao menu anterior
                }
            }
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
            System.out.println("--- Oferecimento --- ");
            System.out.println("Disciplina: " + disciplina.getNomeDisciplina());
            System.out.println("Código do Oferecimento: " + o.getCodigoOferecimento()
                    + " | Ano: " + o.getAno()
                    + " | Semestre: " + o.getSemestre()
                    + " | Professor Responsável: " + o.getProfessorResponsavel().getNome());
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
            System.out.println(
                    "Ano: " + o.getAno() + ", Semestre: " + o.getSemestre() + ", Código: " + o.getCodigoOferecimento()
                            + ", Professor: " + o.getProfessorResponsavel().getNomeCompleto());
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
            System.out.println("Disciplina: " + disciplina.getNomeDisciplina());
            o.imprimirDados();
        }
    }

    // Extra
    public static void listarAlunosSemOferecimentos() {
        System.out.println("Alunos sem nenhum oferecimento matriculado:");
        boolean encontrou = false;

        for (Pessoa p : listaPessoas) {
            if (p instanceof Aluno) {
                Aluno aluno = (Aluno) p;
                if (aluno.getCodigosOferecimentos().isEmpty()) {
                    System.out.println("RA: " + aluno.getRa() + " | Nome: " + aluno.getNomeCompleto());
                    encontrou = true;
                }
            }
        }

        if (!encontrou) {
            System.out.println("Todos os alunos estão matriculados em algum oferecimento.");
        }
    }

    // Métodos auxiliares
    // Sobrecarga
    private static Aluno buscarAlunoPorRa(int ra) {
        for (Pessoa p : listaPessoas) {
            if (p instanceof Aluno a && a.getRa() == ra) {
                return a;
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

    private static Disciplina buscarDisciplinaPorCodigo(String codigo) {
        for (Disciplina d : listaDisciplinas) {
            if (d.getCodigoDisciplina().equalsIgnoreCase(codigo)) {
                return d;
            }
        }
        return null;
    }

    // Sobrecarga
    private static Oferecimento buscarOferecimento(String codDisciplina, String codOferecimento) {
        Disciplina disciplina = buscarDisciplinaPorCodigo(codDisciplina);
        if (disciplina != null) {
            return disciplina.buscarOferecimentoPorCodigo(codOferecimento);
        }

        return null;
    }

}

// Integrantes:
// Bianca Jesus Dias – 10437274
// João Pedro Franco Watanabe Torres – 10730384
// Mariana da Silva Santos – 10722812
// Renan Rodrigues Oliveira – 10730971