package Questao04;

import lerarquivo.*;
import java.util.*;
import java.nio.file.*;
import Questao01.Grafo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Questao01.Vertice;
import lerarquivo.LerGrafo;

public class rascunhoexemplo {
    LerGrafo dados = new LerGrafo();

    public static void main(String[] args) throws IOException {

        try {
            Grafo grafo = LerGrafo.carregarArquivo("src/Entrada/entrada.txt"); // Carrega e retorna o grafo

            

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}