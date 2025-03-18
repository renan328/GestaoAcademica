public class Pessoa {
    String nome;
    int nascimento;
    String cep;
    int telefone;

    public Pessoa(String nome, int nascimento, String cep, int telefone) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.cep = cep;
        this.telefone = telefone;
    }

    public void imprimir() {
        System.out.println("Nome Completo: " + this.nome);
        System.out.println("Data de nascimento: " + this.nascimento);
        System.out.println("CEP: " + this.cep);
        System.out.println("Telefone: " + this.telefone);
    }
}
