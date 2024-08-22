package Questao02;

import Questao01.Grafo;
import Questao01.Vertice;

public class Questao02 {

    public static void main(String[] args) {
        // Criação do grafo
        Grafo grafo = new Grafo(true);

        // Apenas para teste
        Vertice v1 = new Vertice("A");
        Vertice v2 = new Vertice("B");
        Vertice v3 = new Vertice("C");
        Vertice v4 = new Vertice("D");

        // Adicionar vértices
        grafo.adicionarVertice(v1);
        grafo.adicionarVertice(v2);
        grafo.adicionarVertice(v3);
        grafo.adicionarVertice(v4);

        // Adicionar arestas
        grafo.adicionarAresta(v1, v2);
        grafo.adicionarAresta(v1, v3);
        grafo.adicionarAresta(v3, v4);

        // Teste para verificar o grafo (imprimindo vértices e arestas)
        System.out.println("Grafo criado com sucesso.");
        grafo.imprimirGrafo();
    }
}
