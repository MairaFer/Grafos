package Questao06;

import Util.Aresta;
import Util.Grafo;
import Util.Kruskal;
import Util.Vertice;
import Util.DFS;

import java.util.*;

public class main06 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(false); // Grafo não direcionado
        grafo.construirGrafoDeArquivo("src/Entrada/EntradaQ6.txt");

        List<Aresta> ciclo = cicloMinimo(grafo);
        System.out.println("Ciclo mínimo encontrado:");
        for (Aresta aresta : ciclo) {
            System.out.println(aresta.getOrigem().getNome() + " -> " + aresta.getDestino().getNome() + " [peso=" + aresta.getPeso() + "]");
        }
    }

    public static List<Aresta> cicloMinimo(Grafo grafo) {
        // Encontra a MST usando o algoritmo de Kruskal
        List<Aresta> mst = Kruskal.kruskalMST(grafo);
        Set<Vertice> visitados = new HashSet<>();
        List<Aresta> ciclo = new ArrayList<>();

        // Cria um mapa para o grafo e inicia com os vértices da MST
        Map<Vertice, List<Aresta>> adjList = new HashMap<>();
        for (Aresta aresta : mst) {
            adjList.computeIfAbsent(aresta.getOrigem(), k -> new ArrayList<>()).add(aresta);
            adjList.computeIfAbsent(aresta.getDestino(), k -> new ArrayList<>()).add(aresta);
        }

        // Encontrar o ciclo mínimo usando uma abordagem baseada em MST
        for (Vertice vertice : grafo.getVertices()) {
            if (!visitados.contains(vertice)) {
                encontrarCicloMinimoDFS(vertice, visitados, adjList, ciclo);
            }
        }

        return ciclo;
    }

    private static void encontrarCicloMinimoDFS(Vertice vertice, Set<Vertice> visitados, Map<Vertice, List<Aresta>> adjList, List<Aresta> ciclo) {
        Stack<Vertice> pilha = new Stack<>();
        pilha.push(vertice);

        while (!pilha.isEmpty()) {
            Vertice atual = pilha.pop();
            if (visitados.contains(atual)) continue;
            visitados.add(atual);

            List<Aresta> arestas = adjList.get(atual);
            if (arestas != null) {
                for (Aresta aresta : arestas) {
                    Vertice vizinho = aresta.getDestino().equals(atual) ? aresta.getOrigem() : aresta.getDestino();
                    if (!visitados.contains(vizinho)) {
                        pilha.push(vizinho);
                        ciclo.add(aresta);
                    }
                }
            }
        }
    }
}
