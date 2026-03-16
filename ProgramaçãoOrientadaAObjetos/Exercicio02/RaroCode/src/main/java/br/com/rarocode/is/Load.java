package br.com.rarocode.is;


import br.com.rarocode.machine.Value;

import java.util.Map;

public class Load extends Statement {
    private final String variable;

    public Load(String variable) {
        this.variable = variable;
    }

    @Override
    public int execute(int count, Map<String, Value> memory) {
        push(memory.get(variable));
        return count + 1;
    }

    public String getVariable() {
        return variable;
    }
}
