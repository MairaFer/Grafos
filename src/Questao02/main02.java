package Questao02;
import java.util.HashSet;
import java.util.Set;

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
import Questao01.Grafo;
import Questao01.Vertice;

public class Main02 {

    //---MAIN -------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) {
        Grafo grafo = new Grafo(true);

        Vertice v0 = new Vertice("0");
        Vertice v1 = new Vertice("1");
        Vertice v2 = new Vertice("2");
        Vertice v3 = new Vertice("3");
        Vertice v4 = new Vertice("4");
        Vertice v5 = new Vertice("5");
        Vertice v6 = new Vertice("6");
        Vertice v7 = new Vertice("7");

        grafo.adicionarVertice(v0);
        grafo.adicionarVertice(v1);
        grafo.adicionarVertice(v2);
        grafo.adicionarVertice(v3);
        grafo.adicionarVertice(v4);
        grafo.adicionarVertice(v5);
        grafo.adicionarVertice(v6);
        grafo.adicionarVertice(v7);

        grafo.adicionarAresta(v0, v1);
        grafo.adicionarAresta(v0, v2);
        grafo.adicionarAresta(v2, v3);
        grafo.adicionarAresta(v2, v4);
        grafo.adicionarAresta(v3, v1);
        grafo.adicionarAresta(v3, v5);
        grafo.adicionarAresta(v4, v5);
        grafo.adicionarAresta(v6, v7);

        System.out.println("Grafo criado com sucesso.");
        tempoChegadaPartida(grafo);
        imprimirTemposChegadaPartida(grafo);
    }
    
    static void tempoChegadaPartida(Grafo grafo) {
        int tempo = 0;
        Set<Vertice> visitados = new HashSet<>();
        for (Vertice vertice : grafo.getVertices()) {
            if (visitados.contains(vertice)) {
                continue;
            }

            tempo = tempoChegadaPartidaAux(vertice, visitados, tempo) + 1;
        }
    }

    static int tempoChegadaPartidaAux(Vertice vertice, Set<Vertice> visitados, int tempo) {
        if (visitados.contains(vertice)) {
            return tempo;
        }
        
        vertice.setTempoChegada(tempo);
        for (Vertice adjacente : vertice.getVerticesAdjacentes()) {
            if(visitados.contains(adjacente)){
                continue;
            }

            tempo = tempoChegadaPartidaAux(adjacente, visitados, ++tempo);
        }

        vertice.setTempoPartida(++tempo);
        visitados.add(vertice);
        return tempo;
    }

    static void imprimirTemposChegadaPartida(Grafo grafo) {
        for (Vertice vertice : grafo.getVertices()) {
            System.out.println(vertice + ": (" + vertice.getTempoChegada() + ", " + vertice.getTempoPartida() + ")");
        }
    }
}