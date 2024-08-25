package Questao05;

import Util.Aresta;
import Util.Grafo;
import Util.Kruskal;

import java.util.List;

public class main05 {
    public static void main(String[] args) {
        // Caminho para o arquivo de entrada
        String caminhoArquivo = "src/Entrada/EntradaQ5.txt";

        // Criar um grafo não direcionado
        Grafo grafo = new Grafo(false);

        // Construir o grafo a partir do arquivo
        grafo.construirGrafoDeArquivo(caminhoArquivo);

        // Executar o algoritmo de Kruskal para encontrar a MST
        List<Aresta> mst = Kruskal.kruskalMST(grafo);

        // Exibir a MST
        System.out.println("Árvore Geradora Mínima (MST) usando Kruskal:");
        for (Aresta aresta : mst) {
            System.out.println(aresta);
        }
    }
}
