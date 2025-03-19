public class Oferecimento {
    int codigo;
    int ano;
    int semestre;

    public Oferecimento(int codigo, int ano, int semestre) {
        this.codigo = codigo;
        this.ano = ano;
        this.semestre = semestre;
    }

    public void imprimir() {
        System.out.println("Código do Oferecimento: " + codigo);
        System.out.println("Ano: " + ano);
        System.out.println("Semestre: " + semestre);
    }
}
