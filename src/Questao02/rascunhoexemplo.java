package Questao02;



import java.util.*;

class Vertice {
    String nome;

    Vertice(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}

class Grafo {
    private List<Vertice> vertices;  // Lista de vértices
    private List<List<Vertice>> adjacencias;  // Lista de adjacências (cada índice corresponde a um vértice)

    public Grafo() {
        vertices = new ArrayList<>();
        adjacencias = new ArrayList<>();
    }

    public void adicionarVertice(Vertice v) {
        vertices.add(v);
        adjacencias.add(new ArrayList<>());  // Cria uma lista de adjacências para o novo vértice
    }

    public void adicionarAresta(Vertice origem, Vertice destino) {
        int indiceOrigem = vertices.indexOf(origem);
        int indiceDestino = vertices.indexOf(destino);

        if (indiceOrigem != -1 && indiceDestino != -1) {
            adjacencias.get(indiceOrigem).add(destino);
            adjacencias.get(indiceDestino).add(origem);  // Se for grafo não-direcionado
        }
    }

    public List<Vertice> getAdjacencias(Vertice v) {
        int indice = vertices.indexOf(v);
        if (indice != -1) {
            return adjacencias.get(indice);
        }
        return Collections.emptyList();  // Retorna lista vazia se o vértice não for encontrado
    }

    public List<Vertice> getVertices() {
        return vertices;
    }
}

public class rascunhoexemplo {

    public static void dfs(Vertice vertice, Set<Vertice> visitados, Grafo grafo) {
        // Marcar o vértice como visitado
        visitados.add(vertice);
        System.out.println("Visitando: " + vertice);

        // Para cada vizinho do vértice, se não foi visitado, faça a chamada recursiva
        for (Vertice vizinho : grafo.getAdjacencias(vertice)) {
            if (!visitados.contains(vizinho)) {
                dfs(vizinho, visitados, grafo);
            }
        }
    }

    public static void main(String[] args) {
        Grafo grafo = new Grafo();

        // Criando vértices
        Vertice v1 = new Vertice("A");
        Vertice v2 = new Vertice("B");
        Vertice v3 = new Vertice("C");
        Vertice v4 = new Vertice("D");

        // Adicionando vértices ao grafo
        grafo.adicionarVertice(v1);
        grafo.adicionarVertice(v2);
        grafo.adicionarVertice(v3);
        grafo.adicionarVertice(v4);

        // Adicionando arestas
        grafo.adicionarAresta(v1, v2);
        grafo.adicionarAresta(v1, v3);
        grafo.adicionarAresta(v3, v4);

        // Iniciando DFS a partir do vértice A
        Set<Vertice> visitados = new HashSet<>();
        dfs(v1, visitados, grafo);
    }
}

