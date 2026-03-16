package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

public abstract class BinaryOperation<T> extends Instruction{

    public abstract void execute(Value<T> a, Value<T> b);

}
