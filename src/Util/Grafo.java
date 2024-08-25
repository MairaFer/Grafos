package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Grafo {

    static int tempo = 0;

    private List<Vertice> vertices;
    private Boolean direcionado = false;
    
    public Grafo() {
        this.vertices = new ArrayList<>();
    }

    public Grafo(Boolean direcionado) {
        this.direcionado = direcionado;
        this.vertices = new ArrayList<>();
    }

    public void adicionarVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void removerVertice(Vertice vertice) {
        vertices.remove(vertice);
        for (Vertice v : vertices) {
            v.getAdjacentes().removeIf(aresta -> aresta.getDestino().equals(vertice));
        }
    }

    public void adicionarAresta(Vertice origem, Vertice destino) {
        Aresta aresta = new Aresta(origem, destino);
        origem.adicionarAresta(aresta);
        
        origem.adicionarAdjacente(destino);
        destino.adicionarAdjacente(origem);
    }


    public void adicionarAresta(Vertice origem, Vertice destino, int peso) {
        Aresta aresta = new Aresta(origem, destino, peso);
        origem.adicionarAresta(aresta);
        
        origem.adicionarAdjacente(destino);
        destino.adicionarAdjacente(origem);
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

    public int getIndice(Vertice v) {
        return vertices.indexOf(v);
    }

    public List<Vertice> getVertices() {
        return vertices;
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

    public void imprimirGrafoPeso() {
        for (Vertice vertice : vertices) {
            System.out.print(vertice + ": ");
            for (Aresta aresta : vertice.getAdjacentes()) {
                System.out.print(aresta.getDestino().getNome() + " (Peso: " + aresta.getPeso() + ") ");
            }
            System.out.println();
        }
    }

    public static void dfs(Vertice vertice, Set<Vertice> visitados, Grafo grafo) {
    // Marcar o vértice como visitado
    visitados.add(vertice);
    System.out.println("Visitando: " + vertice);

    // Para cada vizinho do vértice, se não foi visitado, faça a chamada recursiva
    for (Vertice vizinho : grafo.obterAdjacentes(vertice)) {
        if (!visitados.contains(vizinho)) {
            dfs(vizinho, visitados, grafo);
        }
    }
    }

    public void kruskal(Grafo grafo, Set<Vertice> peso){
        
    }
}