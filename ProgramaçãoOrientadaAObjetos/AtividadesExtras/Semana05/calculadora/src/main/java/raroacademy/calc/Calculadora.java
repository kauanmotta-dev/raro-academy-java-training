package raroacademy.calc;

import java.util.Map;
import java.util.HashMap;


// Calculadora sem condicionais ou estruturas de repição
public class Calculadora {


    public static int calcular(String[] entrada){

        Map<String, Integer> numerosMap = new HashMap<>();
        numerosMap.put("Zero", 0);
        numerosMap.put ("Um", 1);
        numerosMap.put ("Dois", 2);
        numerosMap.put ("Tres", 3);
        numerosMap.put ("Quatro", 4);
        numerosMap.put ("Cinco", 5);
        numerosMap.put ("Seis", 6);
        numerosMap.put ("Sete", 7);
        numerosMap.put ("Oito", 8);
        numerosMap.put ("Nove", 9);


        int a = numerosMap.get(entrada[0]);
        int b = numerosMap.get(entrada[1]);
        String operador = entrada[2];
        return executa(a,b,operador);
    }


    private static int executa(int a, int b, String operador) {

        Map<String, Integer> funçãoMap = new HashMap<>();
                funçãoMap.put("Somar", (a + b));
                funçãoMap.put("Subtrair", (a - b));
                funçãoMap.put("Multiplicar", (a * b));
                funçãoMap.put("Dividir", ( a / b));

        int resposta = funçãoMap.get(operador);
        return resposta;
    }
}
