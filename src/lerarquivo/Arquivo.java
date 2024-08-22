package lerarquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Arquivo {

    public static List<String> lerDadosSimples(String caminho) throws IOException {
        BufferedReader buffered = new BufferedReader(new FileReader(caminho));
        List<String> result = buffered.lines().map(str -> str.replace(";", "")).collect(Collectors.toList());
        buffered.close();
        return result;
    }

    public static void lerExec(String caminho) {
        
    }
}