package Questao04;

import java.util.ArrayList;
import java.util.List;

/**
  Dado um grafo qualquer, verificar se ele é
  bipartido ou não. Por definição, um grafo bipartido é
um grafo cujos vértices podem ser divididos em dois
conjuntos disjuntos U e V, de modo que cada aresta
conecta um vértice em U a um em V. Abaixo são
apresentadas duas maneiras de verificar se
um grafo é bipartido, implemenar uma delas. A
saída deverá ser: O grafo NÃO é bipartido ou O
grafo É bipartido: Partição 1 (A, B, C, ...)
e Partição 2 (E, F, G ...) (2,0 pontos)
 */
import Questao01.Grafo;
import Questao01.Vertice;

public class Main04 {

    public static void main(String[] args) {


        Grafo grafo = grafoBipartido();
        ehBipartido(grafo);

        System.out.println("The end");

    }

    static void ehBipartido(Grafo grafo) {
        Vertice verticeInicial = grafo.getVertices().getFirst();
        try {
            ehBipartidoAux(verticeInicial, 0);
            System.out.println("EH BIPARTIDO!");
            exibirParticoes(grafo);
        } catch (Exception e) {
            System.out.println("NAO EH BIPARTIDO!");
        }
    }

    static void ehBipartidoAux(Vertice vertice, int cor) throws Exception {
        if (vertice.getCor() == null) {
            vertice.setCor(cor);
        }

        for (Vertice adjacente : vertice.getTodosAdjacentes()) {
            if (adjacente.getCor() == null) {
                adjacente.setCor(inverterCor(cor));
            } else {
                if (vertice.getCor() == adjacente.getCor()) {
                    throw new Exception("Conflito de cores");
                }
            }
        }

        for (Vertice adjacente : vertice.getVerticesAdjacentes()) {
            ehBipartidoAux(adjacente, inverterCor(cor));
        }
    }

    static int inverterCor(int cor) {
        return cor == 1 ? 0 : 1;
    }

    static void exibirParticoes(Grafo grafo) {
        List<Vertice> particaoA = new ArrayList<>();
        List<Vertice> particaoB = new ArrayList<>();

        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getCor() == 0) {
                particaoA.add(vertice);
            } else {
                particaoB.add(vertice);
            }
        }

        System.out.println("Particao A: " + particaoA);
        System.out.println("Particao B: " + particaoB);
    }

    static Grafo grafoNaoBipartido() {
        Grafo grafo = new Grafo(true);

        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Vertice vI = new Vertice("I");

        grafo.adicionarVertice(vA);
        grafo.adicionarVertice(vB);
        grafo.adicionarVertice(vC);
        grafo.adicionarVertice(vD);
        grafo.adicionarVertice(vE);
        grafo.adicionarVertice(vF);
        grafo.adicionarVertice(vG);
        grafo.adicionarVertice(vH);
        grafo.adicionarVertice(vI);

        grafo.adicionarAresta(vA, vB);
        grafo.adicionarAresta(vA, vC);
        grafo.adicionarAresta(vA, vF);
        grafo.adicionarAresta(vB, vG);
        grafo.adicionarAresta(vB, vH);
        grafo.adicionarAresta(vC, vD);
        grafo.adicionarAresta(vC, vI);
        grafo.adicionarAresta(vD, vI);
        grafo.adicionarAresta(vE, vF);
        grafo.adicionarAresta(vE, vG);

        return grafo;
    }
    
    static Grafo grafoBipartido() {
        Grafo grafo = new Grafo(true);

        Vertice vA = new Vertice("A");
        Vertice vB = new Vertice("B");
        Vertice vC = new Vertice("C");
        Vertice vD = new Vertice("D");
        Vertice vE = new Vertice("E");
        Vertice vF = new Vertice("F");
        Vertice vG = new Vertice("G");
        Vertice vH = new Vertice("H");
        Vertice vI = new Vertice("I");

        grafo.adicionarVertice(vA);
        grafo.adicionarVertice(vB);
        grafo.adicionarVertice(vC);
        grafo.adicionarVertice(vD);
        grafo.adicionarVertice(vE);
        grafo.adicionarVertice(vF);
        grafo.adicionarVertice(vG);
        grafo.adicionarVertice(vH);
        grafo.adicionarVertice(vI);

        grafo.adicionarAresta(vA, vH);
        grafo.adicionarAresta(vA, vB);
        grafo.adicionarAresta(vA, vD);
        grafo.adicionarAresta(vB, vG);
        grafo.adicionarAresta(vB, vI);
        grafo.adicionarAresta(vB, vC);
        grafo.adicionarAresta(vC, vF);
        grafo.adicionarAresta(vC, vD);
        grafo.adicionarAresta(vD, vI);
        grafo.adicionarAresta(vD, vE);
        grafo.adicionarAresta(vE, vH);
        grafo.adicionarAresta(vE, vF);
        grafo.adicionarAresta(vF, vI);
        grafo.adicionarAresta(vF, vG);
        grafo.adicionarAresta(vG, vH);
        grafo.adicionarAresta(vH, vI);

        return grafo;
    }
}