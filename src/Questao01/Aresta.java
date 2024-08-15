package Questao01;

public class Aresta {
    private Vertice origem;
    private Vertice destino;

    public Aresta(Vertice origem, Vertice destino) {
        this.origem = origem;
        this.destino = destino;
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
