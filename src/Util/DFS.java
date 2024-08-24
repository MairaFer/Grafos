package Util;

import Util.Grafo;
import Util.Vertice;
import java.util.HashSet;
import java.util.Set;

public class DFS {
    private int tempo;
    private int[] tempoChegada;
    private int[] tempoSaida;

    public DFS(Grafo grafo) {
        int numeroVertices = grafo.getVertices().size();
        this.tempo = 0;
        this.tempoChegada = new int[numeroVertices];
        this.tempoSaida = new int[numeroVertices];
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
}
