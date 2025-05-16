import java.util.ArrayList;

public class Professor extends Pessoa {
    private int drt;
    private String email;
    private String unidadeAcademica;
    private ArrayList<Oferecimento> oferecimentosResponsaveis;

    // Construtor
    public Professor(String nomeCompleto, String dataNascimento, String cep, String telefone, int drt,
            String unidadeAcademica) {
        super(nomeCompleto, dataNascimento, cep, telefone);
        this.drt = drt;
        this.email = drt + "@mackenzie.br";
        this.unidadeAcademica = unidadeAcademica;
        this.oferecimentosResponsaveis = new ArrayList<>();
    }

    // Sobrescrita do método imprimirDados (polimorfismo)
    @Override
    public void imprimirDados() {
        System.out.println("--- Professor --- ");
        System.out.println("Nome: " + getNomeCompleto());
        System.out.println("Data de Nascimento: " + getDataNascimento());
        System.out.println("CEP: " + getCep());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("DRT: " + drt);
        System.out.println("E-mail: " + email);
        System.out.println("Unidade Acadêmica: " + unidadeAcademica);
        System.out.println("Oferecimentos Responsáveis:");

        if (oferecimentosResponsaveis.isEmpty()) {
            System.out.println("Nenhum oferecimento atribuído.");
        } else {
            for (Oferecimento o : oferecimentosResponsaveis) {
                System.out.println("- " + o.getCodigoOferecimento() + " (" + o.getAno() + "/" + o.getSemestre() + ")");
            }
        }
    }

    // Métodos para adicionar e remover oferecimentos
    public void adicionarOferecimento(Oferecimento o) {
        if (!oferecimentosResponsaveis.contains(o)) {
            oferecimentosResponsaveis.add(o);
        }
    }

    public void removerOferecimento(Oferecimento o) {
        oferecimentosResponsaveis.remove(o);
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

    // Getters e Setters
    public int getDrt() {
        return drt;
    }

    public void setDrt(int drt) {
        this.drt = drt;
        this.email = drt + "@mackenzie.br"; // atualiza o e-mail automaticamente
    }

    public String getEmail() {
        return email;
    }

    public String getUnidadeAcademica() {
        return unidadeAcademica;
    }

    public void setUnidadeAcademica(String unidadeAcademica) {
        this.unidadeAcademica = unidadeAcademica;
    }

    public ArrayList<Oferecimento> getOferecimentosResponsaveis() {
        return oferecimentosResponsaveis;
    }

    public void setOferecimentosResponsaveis(ArrayList<Oferecimento> oferecimentosResponsaveis) {
        this.oferecimentosResponsaveis = oferecimentosResponsaveis;
    }
}