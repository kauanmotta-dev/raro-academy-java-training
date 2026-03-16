# 🗄️ Biblioteca Raro Academy — Persistência com Spring Data JPA

Projeto Spring Boot que demonstra **persistência de dados** com JPA/Hibernate e MySQL, incluindo o uso de **stored procedures** e consultas nativas SQL. Baseado no modelo relacional da Biblioteca Raro Academy.

## 📋 Visão Geral

O sistema modela o domínio de empréstimos de uma biblioteca. Implementa três formas de interagir com o banco de dados:

1. **Via stored procedure** — chamada de procedure MySQL para registrar empréstimos
2. **Via JPA direto** — persistência usando `save()` do repositório Spring Data
3. **Consulta nativa** — busca de empréstimos ativos ordenados por data de devolução

## 🏗️ Estrutura

```
src/
├── main/java/com/example/raro_academy_db/
│   ├── RaroAcademyDbApplication.java   # Entry point: executa demonstrações ao iniciar
│   ├── domain/
│   │   └── Emprestimo.java             # Entidade JPA mapeada para a tabela Emprestimo
│   └── repository/
│       └── EmprestimoRepository.java   # Repositório com consultas customizadas
├── resources/
│   └── application.properties          # Configuração da conexão com o banco
MySQL.sql                                # Script DDL: criação do banco, tabelas e procedure
Modelo Relacional.odt                    # Documentação do modelo relacional
```

## 🗃️ Modelo de Dados

A entidade `Emprestimo` representa o empréstimo de um item da biblioteca por um associado:

| Campo | Tipo | Descrição |
|-------|------|-----------|
| `id` | INT (PK) | Identificador auto-gerado |
| `codigo_associado` | INT | Referência ao associado |
| `codigo_item` | INT | Referência ao item emprestado |
| `data_emprestimo` | DATE | Data de início do empréstimo |
| `data_devolucao` | DATE | Data prevista de devolução |
| `matricula_funcionario_verificante` | INT | Funcionário que verificou (opcional) |
| `codigo_funcionario_verificante` | INT | Código do funcionário verificante (opcional) |
| `data_hora_verificacao` | DATETIME | Data/hora da verificação (opcional) |

## ⚙️ Operações Implementadas

### 1. Empréstimo via Stored Procedure
```java
emprestimoRepository.realizarEmprestimoComProcedure(
    codigoAssociado, codigoItem, dataEmprestimo, dataDevolucao
);
```
Chama a procedure `realizar_emprestimo` definida no MySQL.

### 2. Empréstimo direto via JPA
```java
Emprestimo emprestimo = new Emprestimo(codigoAssociado, codigoItem, dataEmprestimo, dataDevolucao);
emprestimoRepository.realizarEmprestimoSemProcedure(emprestimo);
```
Usa o mecanismo padrão do Spring Data JPA.

### 3. Consulta de empréstimos ativos
```java
emprestimoRepository.buscarEmprestimosAtivosPorOrdemDeDevolução();
```
Retorna empréstimos ainda não devolvidos, ordenados pela data de devolução.

## 🎯 Conceitos Praticados

- **Spring Data JPA**: repositórios com `JpaRepository`
- **Hibernate ORM**: mapeamento objeto-relacional com anotações JPA (`@Entity`, `@Id`, `@Column`)
- **Stored Procedures**: integração com `@Query` e `@Procedure`
- **Consultas nativas SQL**: `nativeQuery = true` para queries customizadas
- **MySQL**: criação de banco, tabelas com chaves estrangeiras e procedures
- **Spring Boot CommandLineRunner**: execução de código na inicialização da aplicação

## 🚀 Como Executar

### Pré-requisitos
- MySQL rodando localmente
- Banco criado com o script `MySQL.sql`

```bash
# 1. Execute o script SQL para criar o banco e a procedure
mysql -u root -p < MySQL.sql

# 2. Configure as credenciais em application.properties
# spring.datasource.url=jdbc:mysql://localhost:3306/Biblioteca_Raro_Academy
# spring.datasource.username=seu_usuario
# spring.datasource.password=sua_senha

# 3. Execute a aplicação
mvn spring-boot:run
```

---

*Desenvolvido como parte do programa Raro Academy*
