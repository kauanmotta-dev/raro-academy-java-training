# 🗄️ Sistemas de Persistência de Dados

Este módulo contém exercícios práticos sobre **Persistência de Dados** em Java. Os exercícios exploram modelagem relacional, integração com bancos de dados e o uso de frameworks modernos de ORM.

## 📚 O que são Sistemas de Persistência de Dados?

Sistemas de persistência de dados são responsáveis pelo armazenamento e recuperação confiável de informações em aplicações. Eles garantem que os dados sejam mantidos de forma durável, mesmo após o término de processos ou desligamento do sistema.

### Principais Tipos

| Tipo | Descrição | Exemplos |
|------|-----------|---------|
| **Bancos de Dados Relacionais** | Armazenam dados em tabelas com relacionamentos definidos por chaves | MySQL, PostgreSQL, Oracle |
| **Bancos de Dados NoSQL** | Projetados para grandes volumes de dados não estruturados ou semiestruturados | MongoDB, Cassandra, Redis |
| **Sistemas de Arquivos** | Persistência simples em arquivos locais ou em rede | JSON, XML, CSV |

## 📋 Exercícios Disponíveis

| Exercício | Tema | Descrição |
|-----------|------|-----------|
| **Exercicio06** | Modelagem Relacional | Projeto do modelo relacional da Biblioteca Raro Academy com diagrama entidade-relacionamento |
| **Exercicio07** | Spring Data JPA | Implementação de persistência com JPA/Hibernate, stored procedures e consultas nativas SQL |

## 🔗 Acesso Rápido

1. [Exercicio06 — Modelo Relacional Biblioteca Raro Academy](./Exercicio06)
2. [Exercicio07 — Persistência com Spring Data JPA](./Exercicio07)

## 🎯 Conceitos Praticados

- Modelagem de dados e diagramas entidade-relacionamento (ER)
- **JPA / Hibernate**: mapeamento objeto-relacional com anotações (`@Entity`, `@Id`, `@Column`)
- **Spring Data JPA**: repositórios com `JpaRepository` e consultas customizadas
- **Stored Procedures**: criação e chamada de procedures MySQL via `@Procedure`
- **Consultas nativas SQL**: `nativeQuery = true` para queries personalizadas
- Configuração de datasource com Spring Boot

## 💻 Tecnologias Utilizadas

- **Linguagem**: Java
- **Framework**: Spring Boot
- **ORM**: Hibernate / JPA
- **Banco de Dados**: MySQL
- **Gerenciamento de Dependências**: Maven

## 🚀 Como Executar os Exercícios

1. Navegue até a pasta do exercício desejado
2. Leia o `README.md` específico do exercício para entender o contexto e pré-requisitos
3. Configure o banco de dados conforme as instruções do exercício
4. Compile e execute o projeto com Maven (`mvn spring-boot:run`) ou pela sua IDE

## 🔍 Importância da Persistência de Dados

A escolha do sistema de persistência adequado deve considerar fatores como:

- **Escalabilidade**: capacidade de crescer conforme a demanda
- **Consistência**: integridade e confiabilidade dos dados armazenados
- **Durabilidade**: garantia de que os dados não sejam perdidos em falhas
- **Desempenho**: tempo de resposta nas operações de leitura e escrita

---

*Desenvolvido como parte do programa Raro Academy*