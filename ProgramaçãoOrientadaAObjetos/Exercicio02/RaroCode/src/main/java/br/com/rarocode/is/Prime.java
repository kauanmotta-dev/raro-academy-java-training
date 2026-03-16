package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public class Prime<T> extends UnaryOperation<T> {

    @Override
    public void execute(Value<T> a) {

        int ContadorDePrimos = 0;
        for(int i = (int) a.getValue() - 1; i < (int) a.getValue() && i > 1; i--) {
            if(((int)a.getValue() % i) == 0){
                ContadorDePrimos++;
            }
        }
        if (ContadorDePrimos > 0){
            push(new Value<>(false));
        } else {
            push(new Value<>(true));
        }
    }
}
