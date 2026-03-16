import org.junit.Test;
import raroacademy.calc.Calculadora;
import static org.junit.Assert.assertEquals;

public class CalculadoraTest {
    @Test
    public void testAdicionarDoisNumeros() {

        String[] entrada = new String[]{
                "Cinco",
                "Dois",
                "Somar",
        };
        int expect = 7;
        int actual = Calculadora.calcular(entrada);

        assertEquals(expect,actual);
    }

    @Test
    public void testMultiplicarDoisNumeros(){

        String[] entrada = new String[]{
                "Cinco",
                "Dois",
                "Multiplicar",
        };
        int expect = 10;
        int actual = Calculadora.calcular(entrada);

        assertEquals(expect,actual);
    }

    @Test
    public void testSubtrairDoisNumeros(){

        String[] entrada = new String[]{
                "Cinco",
                "Dois",
                "Subtrair",
        };
        int expect = 3;
        int actual = Calculadora.calcular(entrada);

        assertEquals(expect,actual);
    }

    @Test
    public void testDividirDoisNumeros(){

        String[] entrada = new String[]{
                "Cinco",
                "Dois",
                "Dividir",
        };
        int expect = 2;
        int actual = Calculadora.calcular(entrada);

        assertEquals(expect,actual);
    }
}