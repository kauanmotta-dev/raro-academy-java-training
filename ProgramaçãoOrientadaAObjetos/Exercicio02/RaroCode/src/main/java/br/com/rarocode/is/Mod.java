package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class Mod<T> extends BinaryOperation<T> {


    @Override
    public void execute(Value<T> a, Value<T> b) {
            int resto = (int)b.getValue() % (int)a.getValue();
            if (resto == 0 && (int)a.getValue() < (int)b.getValue()){
                push(new Value<>("Número não é primo!"));
                push(new Value<>(false));

            } else{
                push(new Value<>(true));
            }
            if ((int)a.getValue() == (int)b.getValue()){
                push(new Value<>("Número primo!"));
                push(new Value<>(false));
            }

    }
}
