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
            System.out.println("1. Cadastrar Oferecimento");
            System.out.println("2. Buscar Oferecimento (Disciplina + Código)");
            System.out.println("3. Listar Oferecimentos de uma Disciplina");
            System.out.println("4. Detalhar Oferecimento (alunos, professor, etc.)");
            System.out.println("5. Cadastrar Aluno");
            System.out.println("6. Buscar Aluno por RA");
            System.out.println("7. Buscar todos os Alunos (RA, Curso e Nome))");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // consumir enter

            switch (opcao) {
                case 1 -> cadastrarOferecimento(scanner);
                case 2 -> buscarOferecimento(scanner);
                case 3 -> listarOferecimentos(scanner);
                case 4 -> detalharOferecimento(scanner);
                case 5 -> cadastrarAluno(scanner);
                case 6 -> buscarAlunoPorRa(scanner);
                case 7 -> listarAlunos();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void cadastrarAluno(Scanner scanner) {
        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento (dd/mm/aaaa): ");
        String nascimento = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("RA (registro acadêmico): ");
        int ra = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        Pessoa aluno = new Aluno(nome, nascimento, cep, telefone, ra, curso);
        listaPessoas.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }

    // public void cadastrarAlunoEmOferecimento(Scanner scanner) {

    //     // Buscar aluno
    //     Aluno aluno = null;
    //     while (aluno == null) {
    //         System.out.print("RA do aluno: ");
    //         int ra = scanner.nextInt();
    //         scanner.nextLine(); // limpa o buffer

    //         aluno = buscarAlunoPorRa(ra);

    //         if (aluno == null) {
    //             System.out.println("Aluno não encontrado.");
    //             System.out.print("Deseja tentar novamente? (s para sim / qualquer outra tecla para cancelar): ");
    //             String opcao = scanner.nextLine();
    //             if (!opcao.equalsIgnoreCase("s")) {
    //                 System.out.println("Operação cancelada.");
    //                 return;
    //             }
    //         }
    //     }

    //     // Buscar oferecimento
    //     Oferecimento oferecimento = null;
    //     while (oferecimento == null) {
    //         System.out.print("Código do oferecimento: ");
    //         String codigo = scanner.nextLine();

    //         oferecimento = buscarOferecimentoPorCodigo(codigo);

    //         if (oferecimento == null) {
    //             System.out.println("Oferecimento não encontrado.");
    //             System.out.print("Deseja tentar novamente? (s para sim / qualquer outra tecla para cancelar): ");
    //             String opcao = scanner.nextLine();
    //             if (!opcao.equalsIgnoreCase("s")) {
    //                 System.out.println("Operação cancelada.");
    //                 return;
    //             }
    //         }
    //     }

    //     // Cadastrar aluno no oferecimento
    //     boolean sucesso = oferecimento.adicionarAluno(aluno);
    //     if (sucesso) {
    //         System.out.println("Aluno cadastrado com sucesso no oferecimento.");
    //     } else {
    //         System.out.println("Aluno já está cadastrado neste oferecimento.");
    //     }
    // }

    public static void buscarAlunoPorRa(Scanner scanner) {
        System.out.print("Informe o RA do aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine();

        for (Pessoa p : listaPessoas) {
            if (p instanceof Aluno a && a.getRa() == ra) {
                a.imprimirDados();
                return;
            }
        }

        System.out.println("Aluno com RA " + ra + " não encontrado.");
    }

    public static void listarAlunos() {
        System.out.println("--- Lista de Alunos ---");
        boolean encontrou = false;

        for (Pessoa p : listaPessoas) {
            if (p instanceof Aluno a) {
                System.out.println("RA: " + a.getRa() + " | Nome: " + a.getNomeCompleto() + " | Curso: "
                        + a.getCursoMattriculado());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum aluno cadastrado.");
        }
    }

    public static void cadastrarOferecimento(Scanner scanner) {
        Disciplina disciplina = null;

        while (disciplina == null) {
            System.out.print("Código da disciplina: ");
            String codDisciplina = scanner.nextLine();

            disciplina = buscarDisciplinaPorCodigo(codDisciplina);

            if (disciplina == null) {
                System.out.println("Disciplina não encontrada.");
                System.out.print("Deseja tentar novamente? (s para sim / qualquer outra tecla para cancelar): ");
                String opcao = scanner.nextLine();

                if (!opcao.equalsIgnoreCase("s")) {
                    System.out.println("Cadastro cancelado.");
                    return;
                }
            }
        }

        System.out.print("Código do oferecimento: ");
        String codOferecimento = scanner.nextLine();

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
            System.out.println(
                    "Ano: " + o.getAno() + ", Semestre: " + o.getSemestre() + ", Código: " + o.getCodigoOferecimento() + ", Professor: " + o.getProfessorResponsavel().getNomeCompleto());
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