# API de Produtos com Padrões de Projeto

## Introdução
Neste projeto, desenvolvemos uma API para gerenciar produtos utilizando padrões de projeto de software. Essa abordagem facilita a manutenção, escalabilidade e organização do código.

## Padrões de Projeto Utilizados
1. **Singleton**: Garantimos que determinadas classes tenham apenas uma instância e fornecemos um ponto global de acesso a ela.
2. **Factory Method**: Utilizamos este padrão para delegar a criação de objetos a subclasses, permitindo assim a escolha da implementação em tempo de execução.
3. **Observer**: Implementamos o padrão Observer para notificar os interessados sobre mudanças nos dados do produto.

## Estrutura do Projeto
- **Controllers**: Responsáveis por gerenciar as requisições recebidas e responder com os dados apropriados.
- **Services**: Contêm a lógica de negócio e utilizam os repositórios para acessar os dados.
- **Repositories**: Abstraem a lógica de acesso a dados, permitindo a troca de diferentes fontes de dados sem afetar a lógica de negócio.

## Conclusão
A utilização de padrões de projeto na construção da API de Produtos trouxe clareza e modularidade ao código, facilitando a colaboração e o entendimento da base de código.