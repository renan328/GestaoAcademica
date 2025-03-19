// Integrantes: 
// Bianca Jesus Dias – 10437274
// João Pedro Franco Watanabe Torres – 10730384
// Mariana da Silva Santos – 10722812
// Renan Rodrigues Oliveira – 10730971

import java.util.Scanner;
public class Principal {
    static Pessoa [] pessoas = new Pessoa[3];
    static Disciplina [] disciplinas = new Disciplina[3];
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        for(int i = 0; i <= 2; i++){
            System.out.println("\nCadastro da pessoa " + (i + 1) + ":");

            System.out.println("Nome: ");
            String nome = input.nextLine();

            System.out.println("Ano nascimento: ");
            int nascimento = input.nextInt();
            input.nextLine();

            System.out.println("CEP: ");
            String cep = input.nextLine();
            
            System.out.print("Telefone: ");
            int telefone = input.nextInt();
            input.nextLine();

            pessoas[i] = new Pessoa(nome, nascimento, cep, telefone);

        }

        for(int i = 0; i <= 2; i++){
            System.out.println("\nCadastro da disciplina " + (i + 1) + ":");

            System.out.println("Código único: ");
            int codigo = input.nextInt();
            input.nextLine();

            System.out.println("Nome completo: ");
            String nome = input.nextLine();

            System.out.println("Curso oferecido: ");
            String cursoOferecido = input.nextLine();

            disciplinas[i] = new Disciplina(codigo, nome, cursoOferecido);

        }

        listarPessoas();
        listarDisciplinas();
        input.close();
    }

    public static void listarPessoas(){
        for (int i = 0; i < pessoas.length; i++) {
            System.out.println("\nPessoa " + (i+1) + "\n");
            pessoas[i].imprimir();
        }
    }
    
    public static void listarDisciplinas(){
        for (int i = 0; i < disciplinas.length; i++) {
            System.out.println("\nDisciplina " + (i+1) + "\n");
            disciplinas[i].imprimir();
        }
    }
}
