package Util;

import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
public class DFS {
    private int tempo;
    private int[] tempoChegada;
    private int[] tempoSaida;
    private Grafo grafo;
    public DFS(Grafo grafo) {
        int numeroVertices = grafo.getVertices().size();
        this.tempo = 0;
        this.tempoChegada = new int[numeroVertices];
        this.tempoSaida = new int[numeroVertices];
        this.grafo = grafo;
    }

    // Método para iniciar o DFS em todos os vértices
    public void executarDFS(Grafo grafo) {
        Set<Vertice> visitados = new HashSet<>();
        for (Vertice vertice : grafo.getVertices()) {
            if (!visitados.contains(vertice)) {
                dfs(vertice, visitados, grafo);
            }
        }
    }

    // Método recursivo para realizar DFS
    private void dfs(Vertice vertice, Set<Vertice> visitados, Grafo grafo) {
        int indiceVertice = grafo.getIndice(vertice);
        visitados.add(vertice);
        tempoChegada[indiceVertice] = tempo++;

        for (Vertice vizinho : grafo.obterAdjacentes(vertice)) {
            if (!visitados.contains(vizinho)) {
                dfs(vizinho, visitados, grafo);
            }
        }

        tempoSaida[indiceVertice] = tempo++;
    }

    // Método para imprimir os tempos de chegada e partida
    public void imprimirTempos(Grafo grafo) {
        for (Vertice v : grafo.getVertices()) {
            int indice = grafo.getIndice(v);
            System.out.println("Vértice " + v.getNome() + " (Chegada: " + tempoChegada[indice] + ", Partida: " + tempoSaida[indice] + ")");
        }
    }
    public void executarDFSAPartirDoVertice(Vertice vertice, List<Vertice> visitados) {
        if (!visitados.contains(vertice)) {
            dfsParticular(vertice, visitados, this.grafo);
        }
    }

    private void dfsParticular(Vertice vertice, List<Vertice> visitados, Grafo grafo) {
        int indiceVertice = grafo.getIndice(vertice);
        visitados.add(vertice);
        tempoChegada[indiceVertice] = tempo++;

        for (Vertice vizinho : grafo.obterAdjacentes(vertice)) {
            if (!visitados.contains(vizinho)) {
                dfsParticular(vizinho, visitados, grafo);
            }
        }

        tempoSaida[indiceVertice] = tempo++;
    }

    public int getTempoChegada(Vertice vertice) {
        return tempoChegada[grafo.getIndice(vertice)];
    }

    public int getTempoSaida(Vertice vertice) {
        return tempoSaida[grafo.getIndice(vertice)];
    }

}
