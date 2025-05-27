import java.util.ArrayList;

public class Aluno extends Pessoa {
    private int ra;
    private String email;
    private String cursoMatriculado;
    private ArrayList<String> codigosOferecimentosMatriculados;

    public Aluno(String nomeCompleto, String dataNascimento, String cep, String telefone, int ra, String cursoMatriculado) {
        super(nomeCompleto, dataNascimento, cep, telefone);
        this.ra = ra;
        this.email = ra + "@mackenzista.com.br"; // criando o email
        this.cursoMatriculado = cursoMatriculado;
        this.codigosOferecimentosMatriculados = new ArrayList<>();
    }

    @Override
    public void imprimirDados() {
        System.out.println("--- Aluno --- ");
        System.out.println("Nome: " + getNomeCompleto());
        System.out.println("Nascimento: " + getDataNascimento());
        System.out.println("CEP: " + getCep());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("RA: " + ra);
        System.out.println("E-mail: " + email);
        System.out.println("Curso: " + cursoMatriculado);
        System.out.println("Oferecimento Matriculados: " + codigosOferecimentosMatriculados);
    }

    // add e remover Oferecimento
    public void adicionarOferecimento(String codigo) {
        codigosOferecimentosMatriculados.add(codigo);
        System.out.println("Adicionou " + getNomeCompleto() + " a " + codigo);
    }

    public void removerCodigoOferecimento(String codigo) {
        codigosOferecimentosMatriculados.remove(codigo);
        System.out.println("Removeu " + codigo);
    }

    public String getNome() {
        return getNomeCompleto();
    }

    public void setNome(String nome) {
        setNomeCompleto(nome);
    }

    public String getNascimento() {
        return getDataNascimento();
    }

    public void setNascimento(String dataNascimento) {
        setDataNascimento(dataNascimento);
    }

    public String getEndereco() {
        return getCep();
    }

    public void setEndereco(String cep) {
        setCep(cep);
    }

    public String getContato() {
        return getTelefone();
    }

    public void setContato(String telefone) {
        setTelefone(telefone);
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
        this.email = ra + "@mackenzista.com.br";
    }

    public String getEmail() {
        return email;
    }

    public String getCursoMatriculado() {
        return cursoMatriculado;
    }

    public void setCursoMatriculado(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    public ArrayList<String> getCodigosOferecimentos() {
        return this.codigosOferecimentosMatriculados;
    }

}