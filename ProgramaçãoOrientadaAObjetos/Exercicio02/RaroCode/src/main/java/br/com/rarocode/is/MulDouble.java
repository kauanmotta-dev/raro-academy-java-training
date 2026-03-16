package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class MulDouble extends BinaryOperation<Double> {
    @Override
    public void execute(Value<Double> a, Value<Double> b) {
        Value<Double> resultado = new Value<>((b.getValue() * a.getValue())*100/100);
        push(resultado);
    }
}
