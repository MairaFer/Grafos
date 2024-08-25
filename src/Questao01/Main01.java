package Questao01;

import java.io.IOException;
import java.util.List;
import Util.Aresta;
import Util.Grafo;
import Util.Vertice;
import lerarquivo.LerGrafo;

/**1. Desenvolva seu próprio Grafo com no mínimo 
 as funcionalidades para inserir e remover (vértices 
e arestas), pesquisar (vértices e arestas), obter 
adjacentes de um vértice e imprimir (apresenta cada 
vértice seguido dos seus adjacentes). Observe que, 
obrigatoriamente, o seu grafo deve ser utilizado 
em todas as questões que seguem. (0,5 pontos) */


public class Main01 {
    public static void main(String[] args) throws IOException {
    Grafo grafo = new Grafo();
   // Grafo grafo = LerGrafo.carregarArquivo("src/Entrada/dadosQ4.txt");

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
