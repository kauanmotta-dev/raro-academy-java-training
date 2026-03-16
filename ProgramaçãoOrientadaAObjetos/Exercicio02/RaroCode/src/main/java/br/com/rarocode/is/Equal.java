package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class Equal extends BinaryOperation<Integer>{
    @Override
    public void execute(Value<Integer> a, Value<Integer> b) {
        push(b);
        push(a);
        push(new Value<>(a.getValue().equals(b.getValue())));
    }
}
