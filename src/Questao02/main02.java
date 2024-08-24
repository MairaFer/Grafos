package Questao02;
/**2. Considerando um grafo G qualquer, 
dada uma execução DFS, encontre e 
imprima os Tempos de Chegada e 
Partida dos seus vértices. O Tempo de 
Chegada é o momento em que o vértice 
foi explorado pela primeira vez, 
enquanto o Tempo de Partida 
corresponde ao momento que, após 
explorar toda uma vizinhança, será 
realizado o backtracking. O lado 
direito da imagem apresenta os 
Tempos de Chegada e Partida de cada 
vértice. A solução deve ser 
apresentada no padrão de uma linha 
para cada vértice: Vértice (Chegada: 
Partida) (1,5 pontos) */

import Util.Grafo;
import Util.Vertice;
import Util.DFS;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main02 {
    public static void main(String[] args) {
        // Criação do grafo a partir do arquivo
        Grafo grafo = new Grafo(true);
        try {
            Scanner scanner = new Scanner(new File("src/Entrada/EntradaQ2.txt"));
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");
                if (partes.length == 3) {
                    String nomeV1 = partes[0];
                    String nomeV2 = partes[1];
                    int peso = Integer.parseInt(partes[2]);

                    Vertice v1 = grafo.pesquisarVertice(nomeV1);
                    if (v1 == null) {
                        v1 = new Vertice(nomeV1);
                        grafo.inserirVertice(v1);
                    }

                    Vertice v2 = grafo.pesquisarVertice(nomeV2);
                    if (v2 == null) {
                        v2 = new Vertice(nomeV2);
                        grafo.inserirVertice(v2);
                    }

                    grafo.inserirAresta(v1, v2, peso);
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo de entrada não encontrado: " + e.getMessage());
            return;
        }

        // Imprimir o grafo para verificação
        System.out.println("Grafo criado com sucesso.");
        grafo.imprimirGrafo();

        // Instanciar e executar o DFS
        DFS dfs = new DFS(grafo);
        dfs.executarDFS(grafo);
        dfs.imprimirTempos(grafo);
    }
}
