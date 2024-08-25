package Util;

import java.util.ArrayList;
import java.util.List;

public class Vertice {
    private String nome;
    private List<Aresta> adjacentes;
    private List<Vertice> verticesAdjacentes;
    private Integer tempoChegada;
    private Integer tempoPartida;
    private Integer cor;
    private Integer peso;

    public Vertice(String nome) {
        this.nome = nome;
        this.adjacentes = new ArrayList<>();
        this.verticesAdjacentes = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Aresta> getAdjacentes() {
        return adjacentes;
    }


    public List<Vertice> getVerticesAdjacentes() {
        List<Vertice> verticesAdjacentes = new ArrayList<>();
        for (Aresta aresta : adjacentes) {
            verticesAdjacentes.add(aresta.getDestino());
        }

        return verticesAdjacentes;
    }

    public List<Vertice> getTodosAdjacentes() {
        return verticesAdjacentes;
    }

    public void adicionarAresta(Aresta aresta) {
        adjacentes.add(aresta);
    }

    public void adicionarAdjacente(Vertice vertice) {
        verticesAdjacentes.add(vertice);
    }

    public void removerAresta(Aresta aresta) {
        adjacentes.remove(aresta);
    }

    @Override
    public String toString() {
        return nome;
    }

    public Integer getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(Integer tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public Integer getTempoPartida() {
        return tempoPartida;
    }

    public void setTempoPartida(Integer tempoPartida) {
        this.tempoPartida = tempoPartida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAdjacentes(List<Aresta> adjacentes) {
        this.adjacentes = adjacentes;
    }

    public void setVerticesAdjacentes(List<Vertice> verticesAdjacentes) {
        this.verticesAdjacentes = verticesAdjacentes;
    }

    public Integer getCor() {
        return cor;
    }

    public void setCor(Integer cor) {
        this.cor = cor;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer cor) {
        this.cor = peso;
    }

    
}