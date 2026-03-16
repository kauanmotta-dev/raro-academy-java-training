# 🗂️ RaroCode — Máquina de Pilha (Stack Machine)

Uma **máquina de pilha virtual** implementada em Java, capaz de executar um conjunto de instruções customizadas. Inspirada em conceitos de compiladores e máquinas de baixo nível, como a JVM.

## 📋 Visão Geral

O RaroCode é uma máquina de estados baseada em pilha (*stack-based virtual machine*). Programas são representados como listas de instruções que operam sobre uma pilha de valores e uma memória de variáveis. A máquina lê cada instrução sequencialmente e a executa, podendo desviar o fluxo de controle com instruções de salto (`GotoT`, `GotoF`, `Label`).

## 🏗️ Arquitetura

```
src/
├── machine/
│   ├── StackMachine.java        # Motor principal: gerencia pilha, memória e contador
│   ├── InstructionExecute.java  # Interface que toda instrução implementa
│   ├── Value.java               # Tipo que encapsula valores na pilha
│   ├── OutputNotifier.java      # Interface para capturar saída da máquina
│   └── Debug.java               # Utilitário de depuração (imprime estado a cada instrução)
└── is/
    ├── Instruction.java / Statement.java  # Interfaces base
    ├── Push, Pop                          # Operações de pilha
    ├── Load, Store                        # Acesso à memória de variáveis
    ├── Add, Sub, Mul, Div, Mod            # Aritmética inteira
    ├── AddDouble, SubDouble, ...          # Aritmética com ponto flutuante
    ├── Inc                                # Incremento
    ├── Equal, NotEquals, LessThan, GreaterThan  # Comparações
    ├── GotoT, GotoF, Label                # Controle de fluxo
    ├── Read, ReadMock, Print              # Entrada e saída
    ├── Prime                              # Verifica se número é primo
    └── End                               # Encerra execução
```

## 💻 Conjunto de Instruções

| Categoria | Instruções |
|-----------|-----------|
| **Pilha** | `Push`, `Pop` |
| **Memória** | `Load`, `Store` |
| **Aritmética inteira** | `Add`, `Sub`, `Mul`, `Div`, `Mod`, `Inc` |
| **Aritmética double** | `AddDouble`, `SubDouble`, `MulDouble`, `DivDouble` |
| **Comparação** | `Equal`, `NotEquals`, `LessThan`, `GreaterThan` |
| **Controle de fluxo** | `Label`, `GotoT`, `GotoF` |
| **E/S** | `Read`, `ReadMock`, `Print` |
| **Especiais** | `Prime`, `End` |

## 🎯 Conceitos Praticados

- **Polimorfismo**: cada instrução é uma classe que implementa `InstructionExecute`
- **Padrão Command**: instruções encapsulam operações como objetos
- **Padrão Strategy**: comportamentos intercambiáveis via interface comum
- **Gerenciamento de estado**: pilha (`Stack<Value>`) e memória (`Map<String, Value>`)
- **Fluxo de controle**: desvios condicionais e incondicionais com `Label`/`Goto`

## 🚀 Como Executar

```bash
# Compilar e executar testes
mvn clean test

# Compilar o projeto
mvn clean install
```

## ✅ Testes

Os testes estão em `src/test/java/br/com/rarocode/tests/StackMachineTest.java` e cobrem programas completos executados na máquina (cálculos, laços, entrada/saída simulada).

---

*Desenvolvido como parte do programa Raro Academy*