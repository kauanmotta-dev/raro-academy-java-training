package br.com.rarocode.is;

import br.com.rarocode.machine.Value;

import java.util.Map;

public abstract class Statement extends Instruction{

    public abstract int execute(int count, Map<String, Value> memory);
}
