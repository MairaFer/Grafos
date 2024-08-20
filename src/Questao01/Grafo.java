package Questao01;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices;

    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void removerVertice(Vertice vertice) {
        vertices.remove(vertice);
        // Remove as arestas associadas ao vértice
        for (Vertice v : vertices) {
            v.getAdjacentes().removeIf(aresta -> aresta.getDestino().equals(vertice));
        }
    }

    public void adicionarAresta(Vertice origem, Vertice destino) {
        Aresta aresta = new Aresta(origem, destino);
        origem.adicionarAresta(aresta);
    }

    public void removerAresta(Vertice origem, Vertice destino) {
        origem.getAdjacentes().removeIf(aresta -> aresta.getDestino().equals(destino));
    }

    public Vertice pesquisarVertice(String nome) {
        for (Vertice vertice : vertices) {
            if (vertice.getNome().equals(nome)) {
                return vertice;
            }
        }
        return null;
    }

    public Aresta pesquisarAresta(Vertice origem, Vertice destino) {
        for (Aresta aresta : origem.getAdjacentes()) {
            if (aresta.getDestino().equals(destino)) {
                return aresta;
            }
        }
        return null;
    }

    public List<Vertice> obterAdjacentes(Vertice vertice) {
        List<Vertice> adjacentes = new ArrayList<>();
        for (Aresta aresta : vertice.getAdjacentes()) {
            adjacentes.add(aresta.getDestino());
        }
        return adjacentes;
    }


    public void imprimirGrafo() {
        for (Vertice vertice : vertices) {
            System.out.print(vertice + ": ");
            for (Aresta aresta : vertice.getAdjacentes()) {
                System.out.print(aresta.getDestino() + " ");
            }
            System.out.println();
        }
    }





}
