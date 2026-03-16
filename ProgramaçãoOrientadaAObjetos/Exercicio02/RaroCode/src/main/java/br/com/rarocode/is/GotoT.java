package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;

public class GotoT extends Statement{

    private final String label;

    public GotoT(String label) {
        this.label = label;
    }

    @Override
    public int execute(int count, Map<String, Value> memory) {
        Value<Boolean> value = pop();
        if(value.getValue() == true){
            return getCounterByLabel(label);
            //Jump
        }

        return count + 1;
    }

    public String toString() {
        return getClass().getSimpleName() + " " + this.label ;
    }

}
