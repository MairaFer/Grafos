package Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Vertice {
    private String nome;
    private Integer cor;
    private List<Vertice> adjacentes;

    public Vertice(String nome) {
        this.nome = nome;
        this.cor = null; // Cor inicializada como nula
        this.adjacentes = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }
    public List<Vertice> getTodosAdjacentes() {
        return adjacentes;
    }

    public void adicionarAdjacente(Vertice vertice) {
        if (!adjacentes.contains(vertice)) {
            adjacentes.add(vertice);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertice vertice = (Vertice) o;
        return Objects.equals(nome, vertice.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return nome;
    }
}
