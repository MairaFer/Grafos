package Questao06;

import Util.Aresta;
import Util.Grafo;
import Util.Kruskal;
import Util.Vertice;

import java.util.*;

public class main06 {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(false); // Grafo não direcionado
        grafo.construirGrafoDeArquivo("src/Entrada/EntradaQ6.txt");

        List<Aresta> cicloMinimo = encontrarCicloMinimo(grafo);
        System.out.println("Ciclo mínimo encontrado:");
        for (Aresta aresta : cicloMinimo) {
            System.out.println(aresta.getOrigem().getNome() + " -> " + aresta.getDestino().getNome() + " [peso=" + aresta.getPeso() + "]");
        }
    }

    public static List<Aresta> encontrarCicloMinimo(Grafo grafo) {
        // Passo 1: Encontrar a MST usando Kruskal
        List<Aresta> mst = Kruskal.kruskalMST(grafo);

        // Passo 2: Criar um multigrafo (duplicar arestas da MST)
        List<Aresta> grafoAumentado = criarGrafoParaCicloEuleriano(mst);

        // Passo 3: Encontrar o ciclo Euleriano
        List<Vertice> cicloEuleriano = encontrarCicloEuleriano(grafoAumentado, grafo.getVertices().get(0));

        // Passo 4: Converter o ciclo Euleriano em ciclo Hamiltoniano
        return converterParaCicloHamiltoniano(cicloEuleriano, grafo);
    }

    private static List<Aresta> criarGrafoParaCicloEuleriano(List<Aresta> mst) {
        List<Aresta> grafoAumentado = new ArrayList<>(mst);
        grafoAumentado.addAll(mst); // Duplicar arestas para o ciclo Euleriano
        return grafoAumentado;
    }

    private static List<Vertice> encontrarCicloEuleriano(List<Aresta> grafoAumentado, Vertice start) {
        Map<Vertice, LinkedList<Vertice>> adjList = new HashMap<>();
        for (Aresta aresta : grafoAumentado) {
            adjList.computeIfAbsent(aresta.getOrigem(), k -> new LinkedList<>()).add(aresta.getDestino());
            adjList.computeIfAbsent(aresta.getDestino(), k -> new LinkedList<>()).add(aresta.getOrigem());
        }

        List<Vertice> ciclo = new ArrayList<>();
        Stack<Vertice> pilha = new Stack<>();
        pilha.push(start);

        while (!pilha.isEmpty()) {
            Vertice v = pilha.peek();
            if (adjList.get(v).isEmpty()) {
                ciclo.add(v);
                pilha.pop();
            } else {
                Vertice u = adjList.get(v).poll();
                adjList.get(u).remove(v);
                pilha.push(u);
            }
        }
        return ciclo;
    }

    private static List<Aresta> converterParaCicloHamiltoniano(List<Vertice> cicloEuleriano, Grafo grafo) {
        List<Aresta> cicloHamiltoniano = new ArrayList<>();
        Set<Vertice> visitados = new HashSet<>();
        Map<String, Aresta> arestasUsadas = new HashMap<>();

        Vertice prev = null;
        for (Vertice v : cicloEuleriano) {
            if (prev != null) {
                String chave = prev.getNome() + "-" + v.getNome();
                if (!arestasUsadas.containsKey(chave) && !arestasUsadas.containsKey(v.getNome() + "-" + prev.getNome())) {
                    Aresta aresta = new Aresta(prev, v, 0); // Peso será atualizado na próxima linha
                    arestasUsadas.put(chave, aresta);
                    cicloHamiltoniano.add(aresta);
                }
            }
            visitados.add(v);
            prev = v;
        }

        // Fechar o ciclo
        if (prev != null && !cicloHamiltoniano.isEmpty()) {
            Aresta arestaFinal = new Aresta(prev, cicloEuleriano.get(0), 0); // Peso será atualizado na próxima linha
            String chave = prev.getNome() + "-" + cicloEuleriano.get(0).getNome();
            if (!arestasUsadas.containsKey(chave) && !arestasUsadas.containsKey(cicloEuleriano.get(0).getNome() + "-" + prev.getNome())) {
                cicloHamiltoniano.add(arestaFinal);
                arestasUsadas.put(chave, arestaFinal);
            }
        }

        // Atualizar os pesos das arestas
        for (Aresta aresta : cicloHamiltoniano) {
            int peso = calcularPesoAresta(aresta.getOrigem(), aresta.getDestino(), grafo);
            aresta.setPeso(peso);
        }

        return cicloHamiltoniano;
    }

    private static int calcularPesoAresta(Vertice origem, Vertice destino, Grafo grafo) {
        for (Aresta aresta : grafo.getArestas()) {
            if ((aresta.getOrigem().equals(origem) && aresta.getDestino().equals(destino)) ||
                    (aresta.getOrigem().equals(destino) && aresta.getDestino().equals(origem))) {
                return aresta.getPeso();
            }
        }

        // Caso não encontre a aresta
        System.out.println("Aresta não encontrada entre " + origem.getNome() + " e " + destino.getNome());
        return 0; // Pode ser um valor padrão ou uma exceção, conforme sua necessidade
    }
}
