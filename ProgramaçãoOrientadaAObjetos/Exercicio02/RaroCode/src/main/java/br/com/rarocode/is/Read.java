package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;
import java.util.Scanner;

public class Read extends Statement{

    @Override
    public int execute(int count, Map<String, Value> memory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um número: ");
        String resposta = scanner.nextLine();
        push(new Value<>(resposta));
        return count + 1;
    }
}
