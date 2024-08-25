package Questao02;
import java.io.IOException;
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
import lerarquivo.LerGrafo;

public class Main02 {

    //---MAIN -------------------------------------------------------------------------------------------------------------//
    public static void main(String[] args) throws IOException {
       // Grafo grafo = new Grafo(true);
        Grafo grafo = LerGrafo.carregarArquivo("src/Entrada/dadosQ2.txt");

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
