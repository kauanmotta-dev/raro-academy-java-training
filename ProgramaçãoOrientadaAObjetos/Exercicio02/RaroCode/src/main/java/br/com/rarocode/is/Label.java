package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;

public class Label extends Statement{

    private final String label;

    public Label(String label) {
        this.label = label;
    }


    @Override
    public int execute(int count, Map<String, Value> memory) {
        return count + 1;
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        return getClass().getSimpleName() + " " + this.label ;
    }

}
