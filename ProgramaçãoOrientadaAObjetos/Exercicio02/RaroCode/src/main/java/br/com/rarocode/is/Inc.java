package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class Inc extends UnaryOperation<Integer> {
    @Override
    public void execute(Value<Integer> a) {
        push(new Value<>(a.getValue() + 1));
    }
}
