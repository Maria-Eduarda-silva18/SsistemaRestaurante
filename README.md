# 🍔 Sistema de Restaurante

Projeto desenvolvido em Java como parte do Projeto 1 do programa Elas Tech.

O sistema permite realizar o gerenciamento de pedidos de um restaurante por meio de um menu interativo no console, com personalização de lanches, adicionais e fechamento de vendas.

## 🚀 Funcionalidades

- Cadastro de pedidos com nome do cliente.
- Numeração automática dos pedidos.
- Cardápio com X-Burger, X-Salada e X-Bacon.
- Personalização dos lanches, permitindo retirar ingredientes.
- Adicionais de cheddar e bacon extra.
- Cálculo automático do valor dos pedidos.
- Listagem de pedidos cadastrados.
- Busca de pedidos pelo número.
- Remoção de lanches de um pedido.
- Cancelamento de pedidos.
- Fechamento do restaurante com total de vendas.
- Identificação dos diferentes lanches vendidos.
- Tratamento de entradas inválidas no menu.

## 🛠️ Tecnologias utilizadas

- Java 21
- Maven
- JUnit 5.10.2
- IntelliJ IDEA
- Git e GitHub

## 📁 Organização do projeto

O projeto está organizado nos seguintes pacotes:

- **app:** contém a classe principal, o menu do console e a coordenação do sistema.
- **cardapio:** contém os lanches, a interface de itens do cardápio, a fábrica e os decoradores.
- **pedido:** contém as classes responsáveis pelo gerenciamento dos pedidos.

## 🧩 Padrões de projeto utilizados

**Factory Method / Factory**

A classe `LancheFactory` centraliza a criação dos tipos de lanches disponíveis no cardápio.

**Decorator**

As classes `ComCheddar` e `ComBaconExtra` permitem adicionar complementos aos lanches e atualizar seus preços sem modificar a classe original.

## 🧪 Testes

Foram desenvolvidos testes automatizados utilizando JUnit 5 para verificar:

- A rejeição de preços negativos.
- O cálculo correto do preço de um X-Bacon com cheddar.

## ▶️ Como executar o projeto

1. Clone este repositório.
2. Abra o projeto no IntelliJ IDEA.
3. Aguarde o Maven carregar as dependências.
4. Localize a classe `Main`, no pacote `app`.
5. Execute o método `main`.

## 👩‍💻 Desenvolvimento

Projeto acadêmico desenvolvido durante o programa Elas Tech, com o objetivo de praticar conceitos de programação orientada a objetos, coleções, interfaces, tratamento de exceções, padrões de projeto e testes automatizados.

## 🎥 Vídeo de apresentação

Assista à demonstração do projeto Sistema de Restaurante, desenvolvida durante o programa Elas Tech.

[▶️ Assistir ao vídeo no LinkedIn](https://lnkd.in/p/eFEkRgqw)