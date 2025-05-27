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

    // os Getters e Setters
    public String getNomeCompleto() { 
        return nomeCompleto; 
    }

    public void setNomeCompleto(String nomeCompleto){
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataNascimento() { 
        return dataNascimento; 
    }

    public void setDataNascimento( String dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public String getCep() { 
        return cep; 
    }

    public void setCep(String cep){
        this.cep = cep;
    }

    public String getTelefone() { 
        return telefone; 
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public abstract void imprimirDados();
}
