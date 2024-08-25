package Util;

import java.util.HashMap;
import java.util.Map;

public class UnionFind {
    private Map<Vertice, Vertice> parent = new HashMap<>();
    private Map<Vertice, Integer> rank = new HashMap<>();

    public void makeSet(Vertice vertice) {
        parent.put(vertice, vertice);
        rank.put(vertice, 0);
    }

    public Vertice find(Vertice vertice) {
        if (!parent.get(vertice).equals(vertice)) {
            parent.put(vertice, find(parent.get(vertice)));
        }
        return parent.get(vertice);
    }

    public void union(Vertice u, Vertice v) {
        Vertice rootU = find(u);
        Vertice rootV = find(v);

        if (!rootU.equals(rootV)) {
            if (rank.get(rootU) > rank.get(rootV)) {
                parent.put(rootV, rootU);
            } else if (rank.get(rootU) < rank.get(rootV)) {
                parent.put(rootU, rootV);
            } else {
                parent.put(rootV, rootU);
                rank.put(rootU, rank.get(rootU) + 1);
            }
        }
    }
}
