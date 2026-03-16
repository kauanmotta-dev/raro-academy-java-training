# 🧮 Calculadora sem Condicionais

Implementação de uma calculadora em Java que **não utiliza estruturas condicionais (`if`/`switch`) nem laços de repetição**, demonstrando como mapas de funções substituem lógica condicional.

## 📋 Visão Geral

A `Calculadora` recebe os operandos e o operador como strings (em português, ex.: `"Um"`, `"Dois"`, `"Somar"`) e retorna o resultado. Toda a lógica é resolvida por `HashMap`s que mapeiam nomes para valores e operadores para resultados pré-calculados.

## 💡 Como Funciona

```java
// Entrada: número1, número2, operador (todos como strings)
Calculadora.calcular(new String[]{"Um", "Dois", "Somar"});
// Retorna: 3
```

Os nomes dos números suportados são: `"Um"`, `"Dois"`, `"Três"`, `"Quatro"`, `"Cinco"`, ...

Os operadores suportados são: `"Somar"`, `"Subtrair"`, `"Multiplicar"`, `"Dividir"`

## 🏗️ Estrutura

```
src/
├── main/java/raroacademy/calc/
│   └── Calculadora.java    # Lógica principal com HashMap de operações
└── test/java/
    └── CalculadoraTest.java # Testes unitários JUnit
```

## 🎯 Conceitos Praticados

- **HashMap como despachante**: elimina `if`/`switch` substituindo por mapeamento de funções
- **Programação funcional**: uso de `Map` para associar operadores a resultados
- **Testes unitários**: cobertura com JUnit

## 🚀 Como Executar

```bash
# Rodar os testes
mvn test
```

---

*Desenvolvido como parte do programa Raro Academy*
