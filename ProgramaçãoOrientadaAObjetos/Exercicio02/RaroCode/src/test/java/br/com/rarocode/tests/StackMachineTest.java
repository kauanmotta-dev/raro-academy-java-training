package br.com.rarocode.tests;

import br.com.rarocode.is.*;
import br.com.rarocode.machine.InstructionExecute;
import br.com.rarocode.machine.OutputNotifier;
import br.com.rarocode.machine.StackMachine;
import br.com.rarocode.machine.Value;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/*
import static org.mockito.Mockito.*;
*/

public class StackMachineTest {

    @Test
    public void shouldAddTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
          new Push(new Value<>(33)),
          new Push(new Value<>(51)),
          new Add(),
          new Print(),
          new End()
        );

        List<String> expected = Arrays.asList(
            "84"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldSubtractTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(10)),
                new Push(new Value<>(7)),
                new Sub(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "3"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldMultiplyTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(10)),
                new Push(new Value<>(7)),
                new Mul(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "70"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldDivideTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(20)),
                new Push(new Value<>(7)),
                new Div(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "2"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldCalcExpression(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(10)),
                new Push(new Value<>(5)),
                new Add(),
                new Push(new Value<>(3)),
                new Sub(),
                new Push(new Value<>(2)),
                new Mul(),
                new Push(new Value<>(6)),
                new Div(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "4"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldPrintFromZeroToTen(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(5)),
                new Push(new Value<>(0)),
                new Label("Inicio"),
                new Print(),
                new Inc(),
                new Equal(),
                new GotoF("Inicio"),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "0","1","2","3","4","5"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldStoreAndLoad(){
        //Arrange
        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(5)),
                new Store("limite"),
                new Push(new Value<>(0)),
                new Store("i"),
                new Label("Inicio"),
                new Load("i"),
                new Print(),
                new Load("limite"),
                new Equal(),
                new Load("i"),
                new Inc(),
                new Store("i"),
                new GotoF("Inicio"),
                new End()
        );


        List<String> expected = Arrays.asList(
                "0","1","2","3","4","5"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, true);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }




//------------------------------------------------------------------------------------------------
//NEW TESTS
//------------------------------------------------------------------------------------------------


    @Test
    public void shouldUseGreaterThan(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(1)),
                new Push(new Value<>(5)),
                new GreaterThan(),
                new Print(),
                new End()

        );

        List<String> expected = Arrays.asList(
                "true"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


    @Test
    public void shouldUseLessThan(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(10)),
                new Push(new Value<>(5)),
                new LessThan(),
                new Print(),
                new End()

        );

        List<String> expected = Arrays.asList(
                "true"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


    @Test
    public void shouldUseNotEquals(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(23)),
                new Push(new Value<>(27)),
                new NotEquals(),
                new Print(),
                new End()

        );

        List<String> expected = Arrays.asList(
                "true"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


    @Test
    public void shouldUseGotoT(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Label("Inicio"),
                new Push(new Value<>(23)),
                new Push(new Value<>(20)),
                new GreaterThan(),
                new Print(),
                new GotoT("Inicio"),
                new End()

        );

        List<String> expected = Arrays.asList(
                "false"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


    @Test
    public void shouldUseReadWithoutMock() {
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                //Digite 10
                new Read(),
                new Print(),
                new End()

        );

        List<String> expected = Arrays.asList(
                "10"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);


        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

   /* @Test
    public void shouldUseReadWithMock() {
        //Arrange
        Scanner scannerMock = mock(Scanner.class);
        when(scannerMock.nextLine()).thenReturn("10");

        List<InstructionExecute> program = Arrays.asList(
                new ReadMock(scannerMock),
                new Print(),
                new End()

        );

        List<String> expected = Arrays.asList(
                "10"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);


        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }*/


    @Test
    public void shouldDiscoverIfNumberIsPrimeUsingMod(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(

                new Push(new Value<>(11)),
                new Store("Limite"),
                new Push(new Value<>(1)),
                new Store("i"),
                new Label("Inicio"),
                new Load("Limite"),
                new Load("i"),
                new Inc(),
                new Store("i"),
                new Load("i"),
                new Mod(),
                new GotoT("Inicio"),
                new Print(),
                new End()

        );

        List<String> expected = Arrays.asList(
                "Número primo!"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


    @Test
    public void shouldPrintTrueUsingPrime() {
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                //Digite 10
                new Push(new Value<>(23)),
                new Prime(),
                new Print(),
                new End()

        );

        List<String> expected = Arrays.asList(
                "true"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, false);


        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


    //OPERAÇÕES COM DOUBLE


    @Test
    public void shouldAddDoubleTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(33.32)),
                new Push(new Value<>(21.55)),
                new AddDouble(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "54.87"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldSubtractDoubleTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(10.9)),
                new Push(new Value<>(7.4)),
                new SubDouble(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "3.5"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldMultiplyDoubleTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(10.1)),
                new Push(new Value<>(7.5)),
                new MulDouble(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "75.75"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }

    @Test
    public void shouldDivideDoubleTwoNumbers(){
        //Arrange

        List<InstructionExecute> program = Arrays.asList(
                new Push(new Value<>(20.0)),
                new Push(new Value<>(2.5)),
                new DivDouble(),
                new Print(),
                new End()
        );

        List<String> expected = Arrays.asList(
                "8.0"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        });

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


//--------------------------------------------------------------------------------------------
// EXECUÇÃO EM ALTO NIVEL
//--------------------------------------------------------------------------------------------


    @Test
    public void shouldReadStringAndExecute() {

        String input = "empilhe 5;guarde limite;empilhe 0;guarde i;label: inicio;carregue i;imprima;carregue limite;igual;carregue i;incremente;guarde i;va para inicio se falso;fim";

        List<InstructionExecute> program = new ArrayList<>(

        );

        String[] instrucoes = input.split(";");
        for (int i = 0; i < instrucoes.length; i++) {
            String[] ordem = instrucoes[i].split(" ");
            switch (ordem[0]) {
                case "empilhe": int valor = Integer.parseInt(ordem[1]); program.add(new Push(new Value<>(valor))); break;
                case "guarde": program.add(new Store(ordem[1])); break;
                case "label:": program.add(new Label(ordem[1])); break;
                case "carregue": program.add(new Load(ordem[1])); break;
                case "imprima": program.add(new Print<>()); break;
                case "igual": program.add(new Equal()); break;
                case "incremente": program.add(new Inc()); break;
                case "va": if (ordem[4].equals("verdadeiro")) { program.add(new GotoT("" + ordem[2])); break; }
                else { program.add(new GotoF("" + ordem[2])); break; }
                case "fim": program.add(new End()); break;
            }
        }

        List<String> expected = Arrays.asList(
                "0","1","2","3","4","5"
        );
        List<String> output = new ArrayList<>();

        StackMachine sm = new StackMachine(program, new OutputNotifier() {
            @Override
            public void notify(String message) {
                output.add(message);
            }
        }, true);

        // Act
        sm.run();

        // Assert
        assertThat(output, is(expected));
    }


















}
