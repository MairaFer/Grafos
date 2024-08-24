package Questao01;

import Util.Aresta;
import Util.Grafo;
import Util.Vertice;

public class main01 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(false); // Cria um grafo não direcionado
        grafo.construirGrafoDeArquivo("src/Entrada/EntradaQ1.txt");

        grafo.inserirVertice(new Vertice("Z"));
        grafo.inserirAresta(new Vertice("Z"), new Vertice("A"), 5);
        grafo.removerVertice("Z");
        grafo.removerAresta(new Vertice("A"), new Vertice("B"));

        // Pesquisa de vértice e aresta
        Vertice v = grafo.pesquisarVertice("A");
        Aresta a = grafo.pesquisarAresta(new Vertice("A"), new Vertice("B"));

        // Imprimir o grafo
        grafo.imprimirGrafo();
    }
}
