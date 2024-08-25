
package lerarquivo;
import Questao01.Grafo;
import Questao01.Vertice;
import java.io.*;

public class LerGrafo {

    public static Grafo carregarArquivo(String arquivo) throws IOException {
        Grafo grafo = new Grafo();
        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(";");
                // Obtenção dos vértices a partir da linha do arquivo
                String nomeV1 = dados[0];
                String nomeV2 = dados[1];
                int  peso = Integer.parseInt(dados[2]);

                // Verificação se os vértices já existem no grafo
                Vertice V1 = grafo.pesquisarVertice(nomeV1);
                if (V1 == null) {
                    V1 = new Vertice(nomeV1);
                    grafo.adicionarVertice(V1);
                }
                Vertice V2 = grafo.pesquisarVertice(nomeV2);

                if (V2 == null) {
                    V2 = new Vertice(nomeV2);
                    grafo.adicionarVertice(V2);
                }

                // Adiciona a aresta entre os vértices com o peso
                grafo.adicionarAresta(V1, V2, peso);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        grafo.imprimirGrafoPeso();

        return grafo;
    }
}
    