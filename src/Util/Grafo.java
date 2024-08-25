package Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;
    private boolean direcionado;

    public Grafo(boolean direcionado) {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
        this.direcionado = direcionado;
    }

    public void inserirVertice(Vertice vertice) {
        if (!vertices.contains(vertice)) {
            vertices.add(vertice);
        }
    }

    public void inserirAresta(Vertice origem, Vertice destino, int peso) {
        Aresta aresta = new Aresta(origem, destino, peso);
        arestas.add(aresta);

        if (!direcionado) {
            Aresta arestaReversa = new Aresta(destino, origem, peso);
            arestas.add(arestaReversa);
        }
    }

    public void removerVertice(String nome) {
        Vertice vertice = pesquisarVertice(nome);

        if (vertice != null) {
            vertices.remove(vertice);
            arestas.removeIf(aresta -> aresta.getOrigem().equals(vertice) || aresta.getDestino().equals(vertice));
        }
    }

    public void removerAresta(Vertice origem, Vertice destino) {
        arestas.removeIf(aresta -> aresta.getOrigem().equals(origem) && aresta.getDestino().equals(destino));

        if (!direcionado) {
            arestas.removeIf(aresta -> aresta.getOrigem().equals(destino) && aresta.getDestino().equals(origem));
        }
    }

    public Vertice pesquisarVertice(String nome) {
        for (Vertice vertice : vertices) {
            if (vertice.getNome().equals(nome)) {
                return vertice;
            }
        }
        return null;
    }

    public Aresta pesquisarAresta(Vertice origem, Vertice destino) {
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(origem) && aresta.getDestino().equals(destino)) {
                return aresta;
            }
        }
        return null;
    }

    public List<Vertice> obterAdjacentes(Vertice vertice) {
        List<Vertice> adjacentes = new ArrayList<>();
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(vertice)) {
                adjacentes.add(aresta.getDestino());
            }
        }
        return adjacentes;
    }

    public void imprimirGrafo() {
        for (Aresta aresta : arestas) {
            System.out.println(aresta);
        }
    }

    public void construirGrafoDeArquivo(String caminhoArquivo) {
        try {
            List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));
            for (String linha : linhas) {
                String[] partes = linha.split(" ");
                String nomeV1 = partes[0];
                String nomeV2 = partes[1];
                int peso = Integer.parseInt(partes[2]);

                Vertice v1 = pesquisarVertice(nomeV1);
                if (v1 == null) {
                    v1 = new Vertice(nomeV1);
                    inserirVertice(v1);
                }

                Vertice v2 = pesquisarVertice(nomeV2);
                if (v2 == null) {
                    v2 = new Vertice(nomeV2);
                    inserirVertice(v2);
                }

                inserirAresta(v1, v2, peso);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getIndice(Vertice vertice) {
        return vertices.indexOf(vertice);
    }
    public List<Vertice> getVertices() {
        return vertices;
    }

}
