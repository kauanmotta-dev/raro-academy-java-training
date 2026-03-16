# 🔷 API de Produtos — Arquitetura Hexagonal

API REST em **Spring Boot** que gerencia produtos e pedidos, estruturada seguindo a **Arquitetura Hexagonal (Ports & Adapters)**. Evolução do [Exercicio04](../Exercicio04), com separação clara entre domínio, aplicação e infraestrutura.

## 📋 Visão Geral

O projeto implementa uma API que consome produtos de uma API externa (via Feign Client) e permite criar pedidos com validação de estoque. A arquitetura hexagonal garante que a lógica de negócio seja totalmente independente de frameworks e detalhes de infraestrutura.

## 🏗️ Arquitetura

```
src/main/java/br/com/raroacademy/product/
├── apllication/
│   ├── service/
│   │   ├── PedidoService.java       # Orquestra casos de uso de pedidos
│   │   └── ProductService.java      # Orquestra casos de uso de produtos
│   └── usecase/
│       ├── GetProductsUseCase.java  # Busca produtos disponíveis
│       └── ProcessOrderUseCase.java # Valida e persiste pedidos
├── domain/
│   ├── entity/
│   │   └── Pedido.java              # Entidade de domínio: Pedido
│   └── repository/
│       ├── ProductRepository.java   # Porta de saída: contrato de produtos
│       └── PedidoRepository.java    # Porta de saída: contrato de pedidos
├── infrastructure/
│   ├── adapter/
│   │   └── ProductRepositoryAdapter.java  # Adaptador: implementa ProductRepository via Feign
│   ├── client/
│   │   └── ProductClient.java             # Feign Client para API externa de produtos
│   ├── schedule/
│   │   └── TotalPedidoSchedule.java       # Tarefa agendada: total de pedidos periódico
│   └── web/
│       ├── config/WebConfig.java           # Configuração de CORS e beans web
│       └── interceptor/RequestTimingInterceptor.java  # Interceptor de tempo de requisição
└── interfaces/
    ├── controller/
    │   ├── ProductController.java   # Endpoints REST de produtos
    │   └── PedidoController.java    # Endpoints REST de pedidos
    ├── dto/
    │   ├── product/                 # DTOs de produto (Request/Response/List)
    │   └── pedido/                  # DTOs de pedido (Request/Response)
    └── exception/
        └── ValidationExceptionHandler.java  # Tratamento global de erros
```

## 🔌 Endpoints

| Método | Rota | Descrição |
|--------|------|-----------|
| `GET` | `/products` | Lista todos os produtos disponíveis |
| `POST` | `/orders` | Cria pedido com validação de estoque |

## ✅ Validações de Pedido

- Quantidade deve ser maior que zero
- Produto deve existir na API externa
- Estoque disponível deve ser suficiente

## 🎯 Padrões e Conceitos Praticados

- **Arquitetura Hexagonal (Ports & Adapters)**: domínio isolado de infraestrutura
- **Use Cases**: cada operação de negócio é encapsulada em um caso de uso
- **Feign Client**: consumo declarativo de API externa
- **Spring Scheduler**: tarefa recorrente com `@Scheduled`
- **Interceptor HTTP**: medição de tempo de resposta com `HandlerInterceptor`
- **Global Exception Handler**: `@ControllerAdvice` para tratamento centralizado de erros
- **JPA / H2**: persistência de pedidos em banco de dados em memória

## 🚀 Como Executar

```bash
# Na pasta Product/Product/
mvn spring-boot:run
```

A aplicação sobe na porta padrão `8080`. Configure a URL da API externa de produtos em `src/main/resources/application.properties`.

## 🧪 Testes

```bash
mvn test
```

---

*Desenvolvido como parte do programa Raro Academy*
