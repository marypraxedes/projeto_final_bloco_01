# 🎮 Hatake Games - Sistema de E-commerce de Jogos

## 📌 Sobre o Projeto

O **Hatake Games** é um sistema de e-commerce desenvolvido em **Java**, com o objetivo de gerenciar uma loja de jogos digitais e físicos.

O projeto foi criado aplicando os principais conceitos de **Programação Orientada a Objetos (POO)**, como:

* Abstração
* Herança
* Polimorfismo
* Encapsulamento
* Interfaces
* Collections
* CRUD completo

O sistema permite cadastrar, listar, consultar, atualizar e remover jogos de uma coleção.

---

## 🚀 Funcionalidades

### 🎮 Cadastro de Jogos

O sistema permite cadastrar dois tipos de jogos:

### Jogo Digital

Possui informações específicas como:

* Tamanho do download
* Loja digital

Exemplos de lojas:

* Steam
* Epic Games

### Jogo Físico

Possui informações específicas como:

* Tipo de mídia

Exemplos:

* DVD
* Cartucho

---

## 📋 Operações disponíveis

O sistema possui um menu interativo com as seguintes opções:

```
1 - Cadastro de Jogo
2 - Listar Todos os Jogos
3 - Consultar Jogo por ID
4 - Atualizar Jogo
5 - Apagar Jogo
6 - Sobre o Projeto
0 - Sair
```

---

## 🧱 Estrutura do Projeto

O projeto foi organizado seguindo uma estrutura baseada em camadas:

```
projeto_final_bloco_01
│
├── controller
│   └── JogoController
│
├── model
│   ├── Jogo
│   ├── JogoDigital
│   └── JogoFisico
│
├── repository
│   └── JogoRepository
│
└── Menu
```

---

## 🧩 Conceitos de POO aplicados

### Abstração

A classe `Jogo` foi criada como uma classe abstrata, contendo os atributos e comportamentos comuns de todos os jogos.

### Herança

As classes:

* `JogoDigital`
* `JogoFisico`

herdam características da classe `Jogo`.

### Polimorfismo

Os diferentes tipos de jogos são tratados como objetos do tipo `Jogo`, permitindo que o sistema trabalhe com diferentes implementações.

Exemplo:

```java
List<Jogo> listaJogos;
```

A lista consegue armazenar tanto jogos digitais quanto físicos.

### Encapsulamento

Os atributos das classes possuem modificadores de acesso privados e são manipulados através de métodos getters e setters.

---

## 🛠️ Tecnologias utilizadas

* Java
* Programação Orientada a Objetos
* Java Collections Framework
* Git e GitHub

---

## 🎯 Objetivo do Projeto

Este projeto foi desenvolvido como parte da formação em **Java Full Stack**, com o objetivo de aplicar na prática os conceitos fundamentais da linguagem Java e da Programação Orientada a Objetos através da construção de um sistema completo.

---

## 👩‍💻 Desenvolvido por

**Maryane Praxedes**

GitHub:
github.com/marypraxedes
