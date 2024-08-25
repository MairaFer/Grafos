package Questao04;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Util.Grafo;
import Util.Vertice;


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
 e Partição 2 (E, F, G ...) (2,0 pontos).
 */

public class main04 {

    public static void main(String[] args) throws IOException {
        // Carrega o grafo a partir de um arquivo
        Grafo grafo = new Grafo(false);
        grafo.construirGrafoDeArquivo("src/Entrada/EntradaQ4.txt");

        // Verifica se o grafo é bipartido
        if (ehBipartido(grafo)) {
            System.out.println("O grafo É bipartido!");
            exibirParticoes(grafo);
        } else {
            System.out.println("O grafo NÃO é bipartido!");
        }
    }

    static boolean ehBipartido(Grafo grafo) {
        // Inicializa as cores dos vértices como nulas
        for (Vertice vertice : grafo.getVertices()) {
            vertice.setCor(null); // Usando Integer para permitir valores nulos
        }

        // Verifica bipartição para todos os componentes do grafo
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getCor() == null) {
                try {
                    ehBipartidoAux(vertice, 0);
                } catch (Exception e) {
                    return false;
                }
            }
        }

        return true;
    }

    static void ehBipartidoAux(Vertice vertice, int cor) throws Exception {
        if (vertice.getCor() == null) {
            vertice.setCor(cor);
        } else if (!vertice.getCor().equals(cor)) {
            // Se o vértice já tem uma cor diferente, não é bipartido
            throw new Exception("Conflito de cores");
        }

        for (Vertice adjacente : vertice.getTodosAdjacentes()) {
            if (adjacente.getCor() == null) {
                adjacente.setCor(inverterCor(cor));
                ehBipartidoAux(adjacente, inverterCor(cor));
            } else if (vertice.getCor().equals(adjacente.getCor())) {
                // Se o adjacente tem a mesma cor, não é bipartido
                throw new Exception("Conflito de cores");
            }
        }
    }

    static int inverterCor(int cor) {
        return cor == 1 ? 0 : 1;
    }

    static void exibirParticoes(Grafo grafo) {
        List<Vertice> particaoA = new ArrayList<>();
        List<Vertice> particaoB = new ArrayList<>();

        // Verifica se a cor é nula e categoriza os vértices
        for (Vertice vertice : grafo.getVertices()) {
            if (vertice.getCor() == 0) {
                particaoA.add(vertice);
            } else if (vertice.getCor() == 1) {
                particaoB.add(vertice);
            }
        }

        System.out.print("Partição 1: ");
        if (particaoA.isEmpty()) {
            System.out.print("Nenhum vértice ");
        } else {
            for (Vertice v : particaoA) {
                System.out.print(v.getNome() + " ");
            }
        }
        System.out.println();

        System.out.print("Partição 2: ");
        if (particaoB.isEmpty()) {
            System.out.print("Nenhum vértice ");
        } else {
            for (Vertice v : particaoB) {
                System.out.print(v.getNome() + " ");
            }
        }
        System.out.println();
    }
}

