package br.com.rarocode.is;


import br.com.rarocode.machine.Value;

import java.util.Map;

public class Store extends Statement {
    private final String variable;

    public Store(String variable) {
        this.variable = variable;
    }

    @Override
    public int execute(int count, Map<String, Value> memory) {
        memory.put(variable, pop());
        return count + 1;
    }

    public String getVariable() {
        return variable;
    }
}
