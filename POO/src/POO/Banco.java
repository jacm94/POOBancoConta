package POO;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome = "Banco Digital";
    private List<Conta> contas = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarClientes() {
        System.out.println("=== Lista de Clientes ===");
        int contador = 1;
        for (Conta conta : contas) {
            System.out.printf("%d - %s\n", contador++, conta.getCliente().getNome());
        }
    }
}

