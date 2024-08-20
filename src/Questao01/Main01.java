package Questao01;

import java.util.List;


public class Main01 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        Vertice v1 = new Vertice("A");
        Vertice v2 = new Vertice("B");
        Vertice v3 = new Vertice("C");
        Vertice v4 = new Vertice("D");

        grafo.adicionarVertice(v1);
        grafo.adicionarVertice(v2);
        grafo.adicionarVertice(v3);
        grafo.adicionarVertice(v4);

        grafo.adicionarAresta(v1, v2);
        grafo.adicionarAresta(v1, v3);
        grafo.adicionarAresta(v3, v4);

        grafo.imprimirGrafo();

        Vertice v = grafo.pesquisarVertice("B");
        if (v != null) {
            System.out.println("Vértice encontrado: " + v.getNome());
        } else {
            System.out.println("Vértice não encontrado");
        }

        List<Vertice> adjacentes = grafo.obterAdjacentes(v1);
        System.out.println("Adjacentes de " + v1.getNome() + ": " + adjacentes);

        grafo.removerAresta(v1, v2);
        grafo.imprimirGrafo();

        grafo.removerVertice(v3);
        grafo.imprimirGrafo();
    }
}
