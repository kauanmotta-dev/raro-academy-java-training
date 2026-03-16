package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;
import java.util.Scanner;

public class ReadMock extends Statement{
    private final Scanner scanner;

    public ReadMock(Scanner scanner) {
        this.scanner = scanner;
    }


    @Override
    public int execute(int count, Map<String, Value> memory) {
        System.out.println("Digite um número: ");
        String resposta = scanner.nextLine();
        push(new Value<>(resposta));
        return count + 1;
    }
}
