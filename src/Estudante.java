import java.util.ArrayList;

public class Estudante extends Pessoa {
    int ra;
    String email;
    String cursoMatriculado;
    ArrayList<String> codigosOferecimentosMatriculados;

    public Estudante(String nomeCompleto, String dataNascimento, String cep, String telefone, int ra, String cursoMatriculado) {
        super(nomeCompleto, dataNascimento, cep, telefone);
        this.ra = ra;
        this.email = ra + "mackenista.com.br";
        this.cursoMatriculado = cursoMatriculado;
    }

    @Override
    public void imprimirDados() {
        System.out.println("Estudante " + getNomeCompleto());
    }
}
