package test.br.com.raroacademy.vendingmachineTest;

import models.*;
import models.dinheiro.*;
import models.dinheiro.notasEMoedas.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DispenserTest {

    private Dispenser dispenser;

    @Before
    public void deveInicializarODispenser() {
        dispenser = new Dispenser();
        dispenser.definirEstoque(MoedaDeCincoCentavos.class, 1);
        dispenser.definirEstoque(MoedaDeDezCentavos.class, 10);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 10);
        dispenser.definirEstoque(MoedaDeCinquentaCentavos.class, 10);
        dispenser.definirEstoque(MoedaDeUmReal.class, 10);
        dispenser.definirEstoque(NotaDeUmReal.class, 2);
        dispenser.definirEstoque(NotaDeDoisReais.class, 10);
        dispenser.definirEstoque(NotaDeCincoReais.class, 10);
        dispenser.definirEstoque(NotaDeDezReais.class, 10);
        dispenser.definirEstoque(NotaDeVinteReais.class, 10);
        dispenser.definirEstoque(NotaDeCinquentaReais.class, 10);
        dispenser.definirEstoque(NotaDeCemReais.class, 10);
        dispenser.definirEstoque(NotaDeDozentosReais.class, 1);
    }

    @Test
    public void deveEstarInicializado() {
        double total = dispenser.getSaldoTotal();
        assertEquals(2090.55, total, 0);
    }

    @Test
    public void deveIncrementarEstoque() {
        int qntdMoedasEstoqueTotalEsperado = 15;
        dispenser.incrementarEstoque(MoedaDeDezCentavos.class, 5);
        assertEquals(qntdMoedasEstoqueTotalEsperado, dispenser.getQuantidade(MoedaDeDezCentavos.class));
    }

    @Test
    public void deveDecrementarEstoque() {
        int qntdMoedasEstoqueTotalEsperado = 5;
        dispenser.decrementarEstoque(MoedaDeDezCentavos.class, 5);
        assertEquals(qntdMoedasEstoqueTotalEsperado, dispenser.getQuantidade(MoedaDeDezCentavos.class));
    }

    @Test
    public void deveDarZeroDeTroco() {
        Dinheiro[] troco = dispenser.trocoPara(200, 200);
        assertArrayEquals(new Dinheiro[0], troco);
    }

    @Test
    public void naoDeveTerTroco() {
        Dinheiro[] troco = dispenser.trocoPara(20000, 123.40);
        assertNull(troco);
    }

    @Test
    public void deveCalcularTrocoSimples() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(MoedaDeCinquentaCentavos.class, 1);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 2);

        Dinheiro[] troco = dispenser.trocoPara(5.00, 4.00);

        // deve existir pelo menos uma unidade de troco
        assertTrue(troco.length > 0);

        // deve estar em ordem decrescente de valor
        for (int i = 1; i < troco.length; i++) {
            assertTrue(troco[i - 1].valor() >= troco[i].valor());
        }

        // soma das denominações deve ser exatamente R$ 1,00
        double total = 0.0;
        double totalExperado = 1.0;
        for (Dinheiro dinheiro : troco) {
            total += dinheiro.valor();
        }
        assertEquals(totalExperado, total, 0.0001);
    }

    // 1. Troco viável usando apenas uma nota
    @Test
    public void deveDarTrocoEmUmaNota() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeVinteReais.class, 3);
        Dinheiro[] troco = dispenser.trocoPara(50.00, 30.00);

        assertEquals(1, troco.length);
        assertEquals(20.00, troco[0].valor(), 0.0001);
    }

    // 2. Troco fracionado com notas e moedas diversas (R$ 1,85)
    @Test
    public void deveDarTrocoComMoedasDiversas() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(MoedaDeUmReal.class, 2);
        dispenser.definirEstoque(MoedaDeCinquentaCentavos.class, 2);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 2);
        dispenser.definirEstoque(MoedaDeDezCentavos.class, 2);

        Dinheiro[] troco = dispenser.trocoPara(10.00, 8.15);

        double total = 0.0;
        for (Dinheiro d : troco) total += d.valor();
        assertEquals(1.85, total, 0.0001);

        for (int i = 1; i < troco.length; i++) {
            assertTrue(troco[i - 1].valor() >= troco[i].valor());
        }
    }

    // 3. Troco impossível devido a centavos não representáveis
    @Test
    public void deveRetornarNullQuandoTrocoDecimalImpossivel() {
        dispenser.zerarEstoque(); // estoque não importa, não há moeda de 0,02 ou 0,05
        Dinheiro[] troco = dispenser.trocoPara(5.00, 4.03);
        assertNull(troco);
    }

    // 4. Troco misto em notas e moedas (R$ 36,60)
    @Test
    public void deveDarTrocoUsandoNotasEMoedas() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeVinteReais.class, 2);
        dispenser.definirEstoque(NotaDeDezReais.class, 2);
        dispenser.definirEstoque(NotaDeCincoReais.class, 5);
        dispenser.definirEstoque(MoedaDeUmReal.class, 5);
        dispenser.definirEstoque(MoedaDeCinquentaCentavos.class, 3);
        dispenser.definirEstoque(MoedaDeDezCentavos.class, 2);

        Dinheiro[] troco = dispenser.trocoPara(100.00, 63.40);
        double total = 0.0;
        for (Dinheiro d : troco) total += d.valor();
        assertEquals(36.60, total, 0.0001);
    }


    // 5. Estoque limitado – troco deve falhar por falta de moedas suficientes
    @Test
    public void deveRetornarNullQuandoEstoqueInsuficiente() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(MoedaDeUmReal.class, 1); // apenas R$ 1 disponível
        Dinheiro[] troco = dispenser.trocoPara(10.00, 8.00); // troco de R$ 2
        assertNull(troco); // não há moedas ou notas suficientes para R$ 2
    }

    //---------------------------------------------------------------------------------------
    //TESTS NANDA
    //---------------------------------------------------------------------------------------
    @Test
    public void deveRetornarOTrocoExatoCenario3(){
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeDoisReais.class, 4);
        dispenser.definirEstoque(MoedaDeCinquentaCentavos.class, 3);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 1);
        dispenser.definirEstoque(MoedaDeDezCentavos.class,3);

        Dinheiro[] troco = dispenser.trocoPara(20.00, 14.20);
        assertEquals(2.0, troco[0].valor(),0);
        assertEquals(2.0, troco[1].valor(),0);
        assertEquals(0.5, troco[2].valor(),0);
        assertEquals(0.5, troco[3].valor(),0);
        assertEquals(0.5, troco[4].valor(),0);
        assertEquals(0.1, troco[5].valor(),0);
        assertEquals(0.1, troco[5].valor(),0);
        assertEquals(0.1, troco[6].valor(),0);
    }

    @Test
    public void deveRetornarOTrocoExatoCenario4(){
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeCincoReais.class,1);
        dispenser.definirEstoque(NotaDeDoisReais.class, 3);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 1);
        dispenser.definirEstoque(MoedaDeDezCentavos.class,4);

        Dinheiro[] troco = dispenser.trocoPara(10.0, 3.70);
        assertEquals(2.0, troco[0].valor(),0);
        assertEquals(2.0, troco[1].valor(),0);
        assertEquals(2.0, troco[2].valor(),0);
        assertEquals(0.1, troco[3].valor(),0);
        assertEquals(0.1, troco[4].valor(),0);
        assertEquals(0.1, troco[5].valor(),0);
    }

    //-------------------------------------------------------------------------------------------
    //TESTS HARD
    //-------------------------------------------------------------------------------------------

    @Test
    public void deveRetornarTroco01() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeCinquentaReais.class, 1);
        dispenser.definirEstoque(NotaDeVinteReais.class, 3);
        dispenser.definirEstoque(NotaDeCincoReais.class, 1);
        dispenser.definirEstoque(NotaDeDoisReais.class, 3);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 1);
        dispenser.definirEstoque(MoedaDeDezCentavos.class, 3);
        Dinheiro[] troco = dispenser.trocoPara(66.31, 0.01); // troco de R$ 66,30

        assertNotNull(troco);

        double totalTroco = 0;
        for (Dinheiro dinheiro : troco) {
            totalTroco += dinheiro.valor();
        }
        assertEquals(66.30, totalTroco, 0.0001);

        // Verificar se as denominações estão em ordem decrescente
        for (int i = 1; i < troco.length; i++) {
            assertTrue(troco[i - 1].valor() >= troco[i].valor());
        }
        assertEquals(NotaDeVinteReais.class, troco[0].getClass());
        assertEquals(NotaDeVinteReais.class, troco[1].getClass());
        assertEquals(NotaDeVinteReais.class, troco[2].getClass());
        assertEquals(NotaDeDoisReais.class, troco[3].getClass());
        assertEquals(NotaDeDoisReais.class, troco[4].getClass());
        assertEquals(NotaDeDoisReais.class, troco[5].getClass());
        assertEquals(MoedaDeDezCentavos.class, troco[6].getClass());
        assertEquals(MoedaDeDezCentavos.class, troco[7].getClass());
        assertEquals(MoedaDeDezCentavos.class, troco[8].getClass());
    }

    @Test
    public void deveRetornarTroco02() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeCincoReais.class, 3);
        dispenser.definirEstoque(NotaDeDoisReais.class, 3);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 3);
        dispenser.definirEstoque(MoedaDeDezCentavos.class, 3);
        Dinheiro[] troco = dispenser.trocoPara(16.81, 0.01); // troco de R$ 66,30

        assertNotNull(troco);

        double totalTroco = 0;
        for (Dinheiro dinheiro : troco) {
            totalTroco += dinheiro.valor();
        }
        assertEquals(16.80, totalTroco, 0.0001);

        // Verificar se as denominações estão em ordem decrescente
        for (int i = 1; i < troco.length; i++) {
            assertTrue(troco[i - 1].valor() >= troco[i].valor());
        }

        assertEquals(NotaDeCincoReais.class, troco[0].getClass());
        assertEquals(NotaDeCincoReais.class, troco[1].getClass());
        assertEquals(NotaDeDoisReais.class, troco[2].getClass());
        assertEquals(NotaDeDoisReais.class, troco[3].getClass());
        assertEquals(NotaDeDoisReais.class, troco[4].getClass());
        assertEquals(MoedaDeVinteECincoCentavos.class, troco[5].getClass());
        assertEquals(MoedaDeVinteECincoCentavos.class, troco[6].getClass());
        assertEquals(MoedaDeDezCentavos.class, troco[7].getClass());
        assertEquals(MoedaDeDezCentavos.class, troco[8].getClass());
        assertEquals(MoedaDeDezCentavos.class, troco[9].getClass());
    }

    //-------------------------------------------------------------------------------------------
    //TESTS ALUNOS RARO ACADEMY
    //-------------------------------------------------------------------------------------------

 @Test
 public void deveRetornarOTrocoExatoCenario6() {
 dispenser.zerarEstoque();
 dispenser.definirEstoque(NotaDeCincoReais.class, 1);
 dispenser.definirEstoque(NotaDeUmReal.class, 3);
 dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 1);
 dispenser.definirEstoque(MoedaDeCincoCentavos.class, 4);

 // Calcula o troco para um pagamento de R$ 10,00 com uma compra de R$ 3,70
 Dinheiro[] troco = dispenser.trocoPara(10.0, 3.70);

 //Verifica se o troco não é nulo
 assertNotNull(troco);

 //Soma os valores das denominações retornadas
 double totalTroco = 0;
 for (Dinheiro dinheiro : troco) {
 totalTroco += dinheiro.valor();
 }

 // Verifica se o total do troco é igual a R$ 5,80
 assertEquals(6.30, totalTroco, 0.0001);

 // Verificar se as denominações estão em ordem decrescente
 for (int i = 1; i < troco.length; i++) {
 assertTrue(troco[i - 1].valor() >= troco[i].valor());
 }

 // Verifica se os tipos das denominações são os esperados
 assertEquals(NotaDeCincoReais.class, troco[0].getClass());
 assertEquals(NotaDeUmReal.class, troco[1].getClass());
 assertEquals(MoedaDeVinteECincoCentavos.class, troco[2].getClass());
 assertEquals(MoedaDeCincoCentavos.class, troco[3].getClass());
 }


    // 4. Troco misto em notas e moedas (R$ 36,60)
    @Test
    public void deveDarTrocoUsandoNotasEMoedas1() {
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeVinteReais.class, 2);
        dispenser.definirEstoque(NotaDeDezReais.class, 2);
        dispenser.definirEstoque(NotaDeCincoReais.class, 5);
        dispenser.definirEstoque(MoedaDeUmReal.class, 5);
        dispenser.definirEstoque(MoedaDeCinquentaCentavos.class, 3);
        dispenser.definirEstoque(MoedaDeDezCentavos.class, 2);

        Dinheiro[] troco = dispenser.trocoPara(100.00, 63.40);
        double total = 0.0;
        for (Dinheiro d : troco) total += d.valor();
        assertEquals(36.60, total, 0.0001);
    }


    @Test
    public void deveRetorar6630(){
        dispenser.zerarEstoque();
        dispenser.definirEstoque(NotaDeCinquentaReais.class, 1);
        dispenser.definirEstoque(NotaDeVinteReais.class, 3);
        dispenser.definirEstoque(NotaDeCincoReais.class, 1);
        dispenser.definirEstoque(NotaDeDoisReais.class, 3);
        dispenser.definirEstoque(MoedaDeVinteECincoCentavos.class, 1);
        dispenser.definirEstoque(MoedaDeDezCentavos.class, 3);

        Dinheiro[] troco = dispenser.trocoPara(86.30, 20.00);
        double total = 0.0;
        for (Dinheiro d : troco) total += d.valor();
        assertEquals(66.3, total, 0.0001);
    }
}

