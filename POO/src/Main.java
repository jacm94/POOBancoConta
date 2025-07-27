import POO.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Integer option;
        Banco banco = new Banco();

        while (true){
            System.out.println("\n=== Bem-vindo ao seu Banco ===");
            System.out.println("1 - Criar uma conta");
            System.out.println("2 - Exibir contas");
            System.out.println("3 - Exibir clientes");
            System.out.println("4 - Sacar");
            System.out.println("5 - Depositar");
            System.out.println("6 - Transferir");
            System.out.println("7 - Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Digite o nome do usuário: ");
                    Cliente cliente = new Cliente();
                    String nomeCliente = scanner.next();
                    cliente.setNome(nomeCliente);

                    System.out.print("Escolha o tipo de conta: Corrente (CC) ou Poupanca (CP): ");
                    String tipoConta = scanner.next();

                    Conta novaConta;
                    if (tipoConta.equalsIgnoreCase("CC")) {
                        novaConta = new ContaCorrente(cliente);
                    } else if (tipoConta.equalsIgnoreCase("CP")) {
                        novaConta = new ContaPoupanca(cliente);
                    } else {
                        System.out.println("Tipo de conta inválido.");
                        break;
                    }

                    banco.adicionarConta(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    novaConta.imprimirExtrato();
                    break;

                case 2:
                    System.out.println("=== Lista de Contas ===");
                    if (banco.getContas().isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada.");
                    } else {
                        for (Conta conta : banco.getContas()) {
                            conta.imprimirExtrato();
                        }
                    }
                    break;

                case 3:
                    banco.listarClientes();
                    break;

                case 4:
                    Conta contaSaque = selecionarConta(banco);
                    if (contaSaque != null) {
                        System.out.print("Digite o valor para sacar: ");
                        double valor = scanner.nextDouble();
                        contaSaque.sacar(valor);
                    }
                    break;

                case 5:
                    Conta contaDeposito = selecionarConta(banco);
                    if (contaDeposito != null) {
                        System.out.print("Digite o valor para depositar: ");
                        double valor = scanner.nextDouble();
                        contaDeposito.depositar(valor);
                        System.out.println("Depósito realizado com sucesso.");
                    }
                    break;

                case 6:
                    System.out.println("Escolha a conta de origem:");
                    Conta origem = selecionarConta(banco);
                    System.out.println("Escolha a conta de destino:");
                    Conta destino = selecionarConta(banco);

                    if (origem != null && destino != null && origem != destino) {
                        System.out.print("Digite o valor para transferir: ");
                        double valor = scanner.nextDouble();
                        origem.transferir(destino, valor);
                    } else {
                        System.out.println("Contas inválidas.");
                    }
                    break;

                case 7:
                    System.out.println("Obrigado por usar nosso banco!");
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    // Método auxiliar para listar contas e permitir seleção
    private static Conta selecionarConta(Banco banco) {
        List<Conta> contas = banco.getContas();

        if (contas.isEmpty()) {
            System.out.println("Nenhuma conta cadastrada.");
            return null;
        }

        for (int i = 0; i < contas.size(); i++) {
            System.out.printf("%d - %s (Conta Nº %d)\n", i, contas.get(i).getCliente().getNome(), contas.get(i).getNumero());
        }

        System.out.print("Escolha o número da conta: ");
        int index = scanner.nextInt();
        if (index < 0 || index >= contas.size()) {
            System.out.println("Conta inválida.");
            return null;
        }

        return contas.get(index);
    }
}
