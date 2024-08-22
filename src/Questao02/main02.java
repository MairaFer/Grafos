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
import Questao01.Grafo;
import Questao01.Vertice;
import java.util.HashSet;
import java.util.Set;

public class main02 {
    static int tempo = 0;
    //TemposDeChegadaEPartida

    static void TemposDeChegadaEPartida(Vertice vertice, Set<Vertice> visitados, Grafo grafo, int[] tempoChegada, int[] tempoSaida){
        int indiceVertice = grafo.getIndice(vertice);
        // Marcar o vértice como visitado
        visitados.add(vertice);
        // Registrar tempo de chegada
        tempoChegada[indiceVertice] = tempo++;
        System.out.println("Chegada no vértice " + vertice + " no tempo " + tempoChegada[indiceVertice]);

        // Para cada vizinho do vértice, se não foi visitado, faça a chamada recursiva
        for (Vertice vizinho : grafo.obterAdjacentes(vertice)) {
            if (!visitados.contains(vizinho)) {
                TemposDeChegadaEPartida(vizinho, visitados, grafo, tempoChegada, tempoSaida);
            }
        }

        // Registrar tempo de saída
        tempoSaida[indiceVertice] = tempo++;
        System.out.println("Saída do vértice " + vertice + " no tempo " + tempoSaida[indiceVertice]);
    }
//---MAIN -------------------------------------------------------------------------------------------------------------//
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


        Set<Vertice> visitados = new HashSet<>();
         // Criar arrays para armazenar os tempos de chegada e saída
        int numeroVertices = grafo.getVertices().size();
        int[] tempoChegada = new int[numeroVertices];
        int[] tempoSaida = new int[numeroVertices];

        
       // tmpDfs(v1, visitados, grafo, tempoChegada, tempoSaida);
       TemposDeChegadaEPartida(v1, visitados, grafo, tempoChegada, tempoSaida);
    }
    //fim main    
}
