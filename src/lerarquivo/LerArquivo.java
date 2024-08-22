
package lerarquivo;

// Java program to illustrate reading data from file
// using nio.File
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;
public class LerArquivo {
    public static List<String> readFileInList(String fileName) {

	List<String> lines = Collections.emptyList();
	try {
            lines =
            Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
	}
	catch (IOException e) {
            // do something
            e.printStackTrace();
	}
        return lines;
    }
    public static String[] ler(String arquivo) {
        File directory = new File("");
        String caminho = (String) directory.getAbsolutePath();
        caminho += "\\entrada\\";
        caminho += arquivo;
        
	List l = readFileInList(caminho);
        String[] dados = new String[l.size()];
        Iterator<String> itr= l.iterator();
        int i=0;
        while(itr.hasNext()) {
            dados[i] = itr.next();
            i++;
        }
        return dados;
    }
}
