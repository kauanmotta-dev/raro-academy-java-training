package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public abstract class UnaryOperation<T> extends Instruction{

    public abstract void execute(Value<T> a);

}
