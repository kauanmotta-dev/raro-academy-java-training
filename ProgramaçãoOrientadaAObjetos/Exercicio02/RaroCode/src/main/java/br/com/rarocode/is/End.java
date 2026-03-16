package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;

public class End extends Statement{
    @Override
    public int execute(int count, Map<String, Value> memory) {
        return -1;
    }
}
