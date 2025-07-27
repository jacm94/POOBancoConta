# 💳 Banco Digital em Java

Este é um projeto prático desenvolvido para reforçar os conceitos de **Programação Orientada a Objetos (POO)** em Java. O sistema simula as principais funcionalidades de um banco digital, permitindo a criação de contas, saques, depósitos, transferências e listagem de clientes.

---

## 🚀 Funcionalidades

- Criar conta corrente ou conta poupança para um cliente
- Realizar depósitos e saques com verificação de saldo
- Transferir saldo entre contas
- Listar todas as contas registradas
- Exibir lista de clientes únicos do banco

---

## 🧱 Estrutura do Projeto

- `Main.java` – Interface principal de interação via terminal
- `Banco.java` – Armazena e gerencia as contas do banco
- `Cliente.java` – Representa os dados do cliente
- `Conta.java` – Classe abstrata que define a estrutura comum de contas
- `ContaCorrente.java` e `ContaPoupanca.java` – Implementações específicas de contas
- `IConta.java` – Interface que define operações bancárias padrão

---

## 🛠️ Conceitos de POO Utilizados

- **Abstração:** modelagem de contas e clientes
- **Encapsulamento:** uso de modificadores de acesso para proteger os dados
- **Herança:** `ContaCorrente` e `ContaPoupanca` herdam de `Conta`
- **Polimorfismo:** métodos sobrescritos (`imprimirExtrato`, por exemplo)

---

## 📦 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
