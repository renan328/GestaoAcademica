import java.util.ArrayList;

public class Disciplina {
    // Atributos privados
    private String codigoDisciplina;
    private String nomeDisciplina;
    private String cursoOferecido;
    private ArrayList<Oferecimento> listaOferecimentos;

    // Construtor
    public Disciplina(String codigoDisciplina, String nomeDisciplina, String cursoOferecido) {
        this.codigoDisciplina = codigoDisciplina;
        this.nomeDisciplina = nomeDisciplina;
        this.cursoOferecido = cursoOferecido;
        this.listaOferecimentos = new ArrayList<>();
    }

    // Método para imprimir os dados da disciplina
    public void imprimirDados() {
        System.out.println("--- Disciplina --- ");
        System.out.println("Código: " + codigoDisciplina);
        System.out.println("Nome: " + nomeDisciplina);
        System.out.println("Curso: " + cursoOferecido);
        System.out.println("Oferecimentos:");
        for (Oferecimento o : listaOferecimentos) {
            o.imprimirDados();
        }
    }

    // Método para adicionar um oferecimento
    public void adicionarOferecimento(Oferecimento oferecimento) {
        listaOferecimentos.add(oferecimento);
    }

    // Método para buscar um oferecimento da disciplina
    public Oferecimento buscarOferecimentoPorCodigo(String codigo) {
        for (Oferecimento o : listaOferecimentos) {
            if (o.getCodigoOferecimento().equalsIgnoreCase(codigo)) {
                return o;
            }
        }
        return null;
    }

    // Getters e Setters
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getCursoOferecido() {
        return cursoOferecido;
    }

    public void setCursoOferecido(String cursoOferecido) {
        this.cursoOferecido = cursoOferecido;
    }

    public ArrayList<Oferecimento> getListaOferecimentos() {
        return listaOferecimentos;
    }

    public void setListaOferecimentos(ArrayList<Oferecimento> listaOferecimentos) {
        this.listaOferecimentos = listaOferecimentos;
    }
}