package Questao01;

public class Aresta {
    private Vertice origem;
    private Vertice destino;

    private Double peso;
    //construtor
    public Aresta(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public Aresta(Vertice origem, Vertice destino, double peso) {
        this.origem = origem;
        this.destino = destino;
        this.peso = peso;
    }

    public Double getPeso(){
        return peso;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return origem.getNome() + " -> " + destino.getNome();
    }
}
