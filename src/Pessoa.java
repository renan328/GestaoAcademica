public abstract class Pessoa {
    private String nomeCompleto;
    private String dataNascimento;
    private String cep;
    private String telefone;

    public Pessoa(String nomeCompleto, String dataNascimento, String cep, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
        this.cep = cep;
        this.telefone = telefone;
    }

    public String getNomeCompleto() { return nomeCompleto; }
    public String getDataNascimento() { return dataNascimento; }
    public String getCep() { return cep; }
    public String getTelefone() { return telefone; }

    public abstract void imprimirDados();
}
