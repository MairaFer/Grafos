package Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static List<Aresta> kruskalMST(Grafo grafo) {
        List<Aresta> mst = new ArrayList<>();
        UnionFind uf = new UnionFind();

        for (Vertice v : grafo.getVertices()) {
            uf.makeSet(v);
        }

        List<Aresta> arestas = new ArrayList<>(grafo.getArestas());

        // Ordenar as arestas usando um Comparator
        Collections.sort(arestas, new Comparator<Aresta>() {
            @Override
            public int compare(Aresta a1, Aresta a2) {
                return Integer.compare(a1.getPeso(), a2.getPeso());
            }
        });

        for (Aresta aresta : arestas) {
            Vertice u = aresta.getOrigem();
            Vertice v = aresta.getDestino();

            if (uf.find(u) != uf.find(v)) {
                mst.add(aresta);
                uf.union(u, v);
            }
        }

        return mst;
    }
}
