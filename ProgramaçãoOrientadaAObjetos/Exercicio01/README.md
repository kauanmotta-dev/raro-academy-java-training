# Exercício de Máquina de Venda

Este exercício consiste em criar uma simulação de uma máquina de venda automática que permite aos usuários interagir e realizar compras de produtos.

## Funcionalidades Principais:
- **Exibir Produtos**: A máquina deve listar os produtos disponíveis para compra, incluindo o nome, o preço e a quantidade disponível.
- **Aceitar Pagamento**: A máquina deve permitir que o usuário insira moedas para realizar o pagamento dos produtos selecionados.
- **Dispensar Produtos**: Após o pagamento, a máquina deve entregar o produto solicitado e atualizar a quantidade disponível.
- **Devolver Troco**: Caso o pagamento exceda o valor do produto, a máquina deve devolver o troco apropriado ao usuário.

## Destaques da Implementação:
1. **Encapsulamento**: A classe `MaquinaDeVenda` encapsula todos os comportamentos e estados da máquina, promovendo uma separação clara de responsabilidades.
2. **Uso de Enum**: Os produtos disponíveis são representados como enumerações, possibilitando uma gestão fácil e organizada dos itens.
3. **Tratamento de Erros**: Implementação de verificações para garantir que a máquina não permita ações inválidas, como selecionar um produto que não está mais disponível ou inserir notas de valor inadequado.

Este exercício ajuda a praticar conceitos importantes de Programação Orientada a Objetos (POO), tais como encapsulamento, polimorfismo e abstração, ao mesmo tempo em que simula uma operação do mundo real.