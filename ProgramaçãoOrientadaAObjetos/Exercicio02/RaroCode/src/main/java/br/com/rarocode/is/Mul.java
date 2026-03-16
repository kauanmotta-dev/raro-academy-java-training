package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class Mul extends BinaryOperation<Integer> {
    @Override
    public void execute(Value<Integer> a, Value<Integer> b) {
        Value<Integer> resultado = new Value<>(b.getValue() * a.getValue());
        push(resultado);
    }
}
