public class Disciplina {
    int codigo;
    String nome;
    String cursoOferecido;
    
    public Disciplina(int codigo, String nome, String cursoOferecido){
        this.codigo = codigo;
        this.nome = nome;
        this.cursoOferecido = cursoOferecido;
    }

    public void imprimir(){
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Curso onde é oferecido: " + this.cursoOferecido);
    }
}

