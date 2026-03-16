# 🏛️ Labyrinth of Minotaur

Jogo de labirinto baseado em console com **concorrência em Java**: o Corredor tenta escapar enquanto o Minotauro surge periodicamente e ameaça sua rota.

## 📋 Visão Geral

O jogador controla o **Corredor**, que navega por um labirinto ASCII. Após um determinado número de passos, o **Minotauro** aparece em uma posição aleatória do labirinto e passa a existir como ameaça concorrente — rodando em uma `Thread` separada. O objetivo é chegar à saída (`E`) antes de ser alcançado.

## 🏗️ Estrutura

```
src/
├── raroacademy/com/br/
│   ├── Main.java           # Ponto de entrada: configura e inicia o jogo
│   └── features/
│       ├── Maze.java       # Gera e armazena o labirinto a partir de uma string ASCII
│       ├── Runner.java     # Personagem do jogador: movimentação e histórico de passos
│       ├── Minotaur.java   # Monstro concorrente (Runnable): spawna a cada N passos
│       └── Verificador.java # Valida condições de vitória e derrota
└── Test/
    └── MazeTest.java       # Testes unitários
```

O projeto evoluiu em três versões:

| Versão | Pasta | Destaque |
|--------|-------|----------|
| v0 | `LabyrinthOfMinotaur/` | Implementação inicial |
| v1 | `LabyrinthOfMinotaur1.0/` | Refatoração das regras do jogo |
| v2 | `LabyrinthOfMinotaur2.0/` | Gerenciamento de mapas com `Maps.java` |

## 🗺️ Formato do Labirinto

O labirinto é representado por uma string ASCII:

```
#########
#S      #
# ### ###
#   #   #
### # # #
#     # E
#########
```

| Caractere | Significado |
|-----------|-------------|
| `#` | Parede |
| ` ` | Corredor livre |
| `S` | Posição inicial do Corredor |
| `E` | Saída (objetivo) |
| `M` | Posição do Minotauro (dinâmica) |

## ⚙️ Como Funciona

1. O labirinto é carregado e o Corredor posicionado em `S`
2. O jogador move o Corredor passo a passo
3. A cada `N` passos (configurável), o `Minotaur` spawna em uma posição aleatória válida, rodando em uma `Thread` separada
4. O `Verificador` checa continuamente se o Corredor chegou à saída (vitória) ou foi alcançado pelo Minotauro (derrota)

## 🎯 Conceitos Praticados

- **Multithreading**: `Minotaur` implementa `Runnable` e roda em thread independente
- **Sincronização**: acesso concorrente ao estado do labirinto com `volatile`
- **Encapsulamento**: cada entidade (Maze, Runner, Minotaur) tem responsabilidade bem definida
- **Programação orientada a objetos**: modelagem de entidades do mundo do jogo
- **Testes unitários**: validação do comportamento do labirinto com JUnit

---

*Desenvolvido como parte do programa Raro Academy*
