import java.util.ArrayList;

public class TesteAluno {
    public static void main(String[] args) {
        ArrayList<Aluno> listarEstudantes = new ArrayList<>();

        Aluno est1 = new Aluno("Kayque Carvalho", "14/09/2006","15220-871", "(11) 91123-2544", 370492, "Engenharia de Software");
        Aluno est2 = new Aluno("Luciana Roberta", "07/03/2005", "15266-701", "(11) 95247-789", 389769, "Sistema de Informação");
        Aluno est3 = new Aluno("Marta Coelho", "02/02/2002", "26310-512", "(11) 95119-174", 390529, "Ciência da Computação");

        est1.adicionarCodigoOferecimento("PYT023");
        est2.adicionarCodigoOferecimento("PRS101");
        est3.adicionarCodigoOferecimento("BND404");

        est3.removerCodigoOferecimento("BND404");

        listarEstudantes.add(est1);
        listarEstudantes.add(est2);
        listarEstudantes.add(est3);

        for(Aluno estudante: listarEstudantes){
            estudante.imprimirDados();
            System.out.println("___________________");//isso é para separar na hora de printar ^^
        }
    }
}
