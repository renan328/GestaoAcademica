import java.util.ArrayList;

public class Oferecimento {
    // Atributos privados
    private String codigoOferecimento;
    private int ano;
    private int semestre;
    private Professor professorResponsavel;
    private ArrayList<Aluno> alunosMatriculados;

    // Construtor
    public Oferecimento(String codigoOferecimento, int ano, int semestre, Professor professorResponsavel) {
        this.codigoOferecimento = codigoOferecimento;
        this.ano = ano;
        this.semestre = semestre;
        this.professorResponsavel = professorResponsavel;
        this.alunosMatriculados = new ArrayList<>();
    }

    // Método para imprimir os dados do oferecimento
    public void imprimirDados() {
        System.out.println("Código do Oferecimento: " + codigoOferecimento);
        System.out.println("Ano: " + ano);
        System.out.println("Semestre: " + semestre);
        System.out.println("Professor Responsável: " + professorResponsavel.getNome()); // assumindo getNome()
        System.out.println("Alunos Matriculados:");

        if (alunosMatriculados.isEmpty()) {
            System.out.println("Nenhum aluno matriculado.");
        } else {
            System.out.printf("%-3s %-20s %-10s%n", "", "Nome", "RA");
            System.out.println("----------------------------------------");
            
            for (Aluno aluno : alunosMatriculados) {
                System.out.printf("%-3s %-20s %-10s%n", "-", aluno.getNome(), aluno.getRa());
            }
        }
    }

    // Método para adicionar um aluno à turma
    public boolean adicionarAluno(Aluno aluno) {
        for (Aluno a : alunosMatriculados) {
            if (a.getRa() == aluno.getRa()) {
                System.err.println("Aluno já matriculado nesse oefrecimento");
                return false;
            }
        }

        alunosMatriculados.add(aluno);
        return true;
    }

    // Getters e Setters
    public String getCodigoOferecimento() {
        return codigoOferecimento;
    }

    public void setCodigoOferecimento(String codigoOferecimento) {
        this.codigoOferecimento = codigoOferecimento;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public void setAlunosMatriculados(ArrayList<Aluno> alunosMatriculados) {
        this.alunosMatriculados = alunosMatriculados;
    }
}
