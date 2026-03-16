package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class Print<T> extends UnaryOperation<T> {
    @Override
    public void execute(Value<T> a) {
        System.out.println(a.getValue().toString());
        push(a);
        notifyOutput(a.getValue().toString());
    }
}
