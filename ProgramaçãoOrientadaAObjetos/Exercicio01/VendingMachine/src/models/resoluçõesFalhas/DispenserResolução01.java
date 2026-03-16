package models.resoluçõesFalhas;

import models.dinheiro.Dinheiro;
import models.dinheiro.notasEMoedas.*;

import java.util.Arrays;

public class DispenserResolução01 {

    private final Dinheiro[] estoque = new Dinheiro[] {
        new MoedaDeCincoCentavos(),
        new MoedaDeDezCentavos(),
        new MoedaDeVinteECincoCentavos(),
        new MoedaDeCinquentaCentavos(),
        new MoedaDeUmReal(),
        new NotaDeUmReal(),
        new NotaDeDoisReais(),
        new NotaDeCincoReais(),
        new NotaDeDezReais(),
        new NotaDeVinteReais(),
        new NotaDeCinquentaReais(),
        new NotaDeCemReais(),
        new NotaDeDozentosReais()
    };

    /** Define a quantidade fixa para uma denominação (inicialização). */
    public void definirEstoque(Class<? extends Dinheiro> clazz, int quantidade){
        getDinheiro(clazz).setQuantidade(quantidade);
    }

    /** Retorna a quantidade atual de uma denominação. */
    public int getQuantidade(Class<? extends Dinheiro> clazz){
        return getDinheiro(clazz).getQuantidade();
    }

    /** Soma total do dinheiro no dispenser. */
    public double getSaldoTotal() {
        double total = 0;
        for (Dinheiro dinheiro : estoque) {
            total += dinheiro.getQuantidade() * dinheiro.valor();
        }
        return total;
    }

    private Dinheiro getDinheiro(Class<? extends Dinheiro> clazz) {
        for (Dinheiro dinheiro : estoque) {
            if (dinheiro.getClass() == clazz) {
                return dinheiro;
            }
        }
        throw new IllegalArgumentException("Denominação não registrada: " + clazz.getSimpleName());
    }

    public void incrementarEstoque(Class<? extends Dinheiro> clazz, int quantidade) {
        Dinheiro dinheiro = getDinheiro(clazz);
        dinheiro.setQuantidade(dinheiro.getQuantidade() + quantidade);
    }

    public void decrementarEstoque(Class<? extends Dinheiro> clazz, int quantidade){
        Dinheiro dinheiro = getDinheiro(clazz);
        dinheiro.setQuantidade(dinheiro.getQuantidade() - quantidade);
    }

    /**
     * Calcula o troco usando um algoritmo ganancioso (maiores valores primeiro).
     * Retorna um array vazio se não houver troco e {@code null} caso o estoque
     * não permita montar o valor necessário.
     */
    public Dinheiro[] trocoPara(double valorPago, double valorProduto) {
        double troco = valorPago - valorProduto;
        if (troco == 0.0) {
            return new Dinheiro[0];
        }

        /*----------------------------------------------------------------------------------------
         * RESOLUÇÃO SIMPLES DO EXERCÍCIO PARA O TESTE "deveRetornarNullQuandoEstoqueInsuficiente"
         *
         *  if (getSaldoTotal() < troco){
         *  return null;
         *   }
         *----------------------------------------------------------------------------------------*/

        // Cópia apenas das referências para ordenação
        Dinheiro[] ordenado = Arrays.copyOf(estoque, estoque.length);

        // Ordena por valor decrescente (bubble‑sort simples)
        for (int i = 0; i < ordenado.length - 1; i++) {
            for (int j = i + 1; j < ordenado.length; j++) {
                if (ordenado[j].valor() > ordenado[i].valor()) {
                    Dinheiro tmp = ordenado[i];
                    ordenado[i] = ordenado[j];
                    ordenado[j] = tmp;
                }
            }
        }

        Dinheiro[] usados = new Dinheiro[100];
        int usadosIndex = 0;

/*----------------------------------------------------------------------------------------------------------
 * RESOLUÇÃO DO DESAFIO:
 * Trocos realizados sem backtracking.
 *---------------------------------------------------------------------------------------------------------*/

        int nãoUsarValorIndex = 0;

        for (int x = 0; x < ordenado.length; x++) {
            for (int i = 0; (i + nãoUsarValorIndex) < ordenado.length; i++) {
                Dinheiro dinheiro = ordenado[i + nãoUsarValorIndex];

                // Só considera denominações cujo estoque original tenha ao menos 1 unidade
                if (dinheiro.getQuantidade() == 0) {
                    continue;
                }
                while (troco + 1e-6 >= dinheiro.valor()) {
                    // Checagem para não estourar o array fixo
                    if (usadosIndex == usados.length) {
                        return null; // Falha: precisaríamos de mais itens que o limite didático permite
                    }
                    troco = (double) Math.round((troco - dinheiro.valor()) * 100.0) / 100;

                    usados[usadosIndex++] = novaInstancia(dinheiro);


                    //----------------------------------------------------------------------------------------
                    //RESOLUÇÃO COMPLETA DO EXERCÍCIO PARA O TESTE "deveRetornarNullQuandoEstoqueInsuficiente"
                    dinheiro.setQuantidade(dinheiro.getQuantidade() - 1);

                    if (troco == 0.0) {
                        return Arrays.copyOf(usados, usadosIndex);
                    }

                    if (dinheiro.getQuantidade() == 0)
                        break;
                    //-----------------------------------------------------------------------------------------
                }
            }
            for (int i = 0; i < ordenado.length; i++) {
                Dinheiro dinheiro = ordenado[i];
                if (dinheiro.getQuantidade() != 0) {
                    nãoUsarValorIndex = i + 1;
                    break;
                }
            }
        }
        // Não foi possível compor exatamente o valor do troco
        return null;
    }

    private Dinheiro novaInstancia(Dinheiro dinheiro) {
        if (dinheiro instanceof MoedaDeCincoCentavos)       return new MoedaDeCincoCentavos();
        if (dinheiro instanceof MoedaDeDezCentavos)         return new MoedaDeDezCentavos();
        if (dinheiro instanceof MoedaDeVinteECincoCentavos) return new MoedaDeVinteECincoCentavos();
        if (dinheiro instanceof MoedaDeCinquentaCentavos)   return new MoedaDeCinquentaCentavos();
        if (dinheiro instanceof MoedaDeUmReal)              return new MoedaDeUmReal();
        if (dinheiro instanceof NotaDeUmReal)               return new NotaDeUmReal();
        if (dinheiro instanceof NotaDeDoisReais)            return new NotaDeDoisReais();
        if (dinheiro instanceof NotaDeCincoReais)           return new NotaDeCincoReais();
        if (dinheiro instanceof NotaDeDezReais)             return new NotaDeDezReais();
        if (dinheiro instanceof NotaDeVinteReais)           return new NotaDeVinteReais();
        if (dinheiro instanceof NotaDeCinquentaReais)       return new NotaDeCinquentaReais();
        if (dinheiro instanceof NotaDeCemReais)             return new NotaDeCemReais();
        if (dinheiro instanceof NotaDeDozentosReais)        return new NotaDeDozentosReais();

        throw new IllegalArgumentException("Tipo de dinheiro desconhecido");
    }

    /**
     * Coloca todas as quantidades do estoque em zero (útil para testes).
     */
    public void zerarEstoque() {
        for (int i = 0; i < estoque.length; i++) {
            estoque[i].setQuantidade(0);
        }
    }



}