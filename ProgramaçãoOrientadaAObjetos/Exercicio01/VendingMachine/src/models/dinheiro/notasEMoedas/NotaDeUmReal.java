package models.dinheiro.notasEMoedas;

import models.dinheiro.Nota;

public class NotaDeUmReal extends Nota {
    @Override
    public double valor() {
        return 1.0;
    }
}
