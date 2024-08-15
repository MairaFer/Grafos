package Questao01;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String nome;
    private List<Aresta> adjacentes;

    public Vertice(String nome) {
        this.nome = nome;
        this.adjacentes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Aresta> getAdjacentes() {
        return adjacentes;
    }

    public void adicionarAresta(Aresta aresta) {
        adjacentes.add(aresta);
    }

    public void removerAresta(Aresta aresta) {
        adjacentes.remove(aresta);
    }

    @Override
    public String toString() {
        return nome;
    }
}
