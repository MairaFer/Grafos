package Questao03;

import Util.DFS;
import Util.Grafo;
import Util.Vertice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class main03 {
    public static void main(String[] args) {
        // Cria um grafo direcionado lendo os dados de um arquivo
        Grafo grafo = new Grafo(true);
        grafo.construirGrafoDeArquivo("src/Entrada/EntradaQ3.txt");

        // Executa DFS e encontra o vértice raiz
        DFS dfs = new DFS(grafo);
        dfs.executarDFS(grafo);

        // Verifica e imprime o vértice raiz
        Vertice vr = encontrarVerticeRaiz(grafo, dfs);
        if (vr != null) {
            System.out.println("O vértice raiz é: " + vr.getNome());
        } else {
            System.out.println("O grafo não possui vértice raiz.");
        }
    }

    private static Vertice encontrarVerticeRaiz(Grafo grafo, DFS dfs) {
        Stack<Vertice> pilha = new Stack<>();
        List<Vertice> visitados = new ArrayList<>();

        // Preenche a pilha com base no tempo de finalização do DFS
        for (Vertice vertice : grafo.getVertices()) {
            if (!visitados.contains(vertice)) {
                dfs.executarDFSAPartirDoVertice(vertice, visitados);
                pilha.push(vertice);
            }
        }

        // Pega o vértice com o maior tempo de finalização
        Vertice possivelVR = pilha.pop();

        // Verifica se esse vértice pode alcançar todos os outros vértices
        if (verificaConectividade(grafo, possivelVR)) {
            return possivelVR;
        }

        return null; // Se não houver vértice raiz, retorna null
    }

    private static boolean verificaConectividade(Grafo grafo, Vertice vertice) {
        List<Vertice> visitados = new ArrayList<>();
        DFS dfs = new DFS(grafo);
        dfs.executarDFSAPartirDoVertice(vertice, visitados); // Executa o DFS a partir do vértice inicial

        for (Vertice v : grafo.getVertices()) {
            if (!visitados.contains(v)) {
                return false;
            }
        }
        return true;
    }
}
