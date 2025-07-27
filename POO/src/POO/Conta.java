package POO;

public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;

    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    private Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para saque.");
        } else {
            saldo -= valor;
            System.out.printf("Saque de %.2f realizado com sucesso.\n", valor);
        }
    }

    @Override
    public void depositar(double valor) {
        saldo = saldo + valor;
    }

    @Override
    public void transferir(Conta contaDestino, double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente para transferência.");
        } else {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.printf("Transferência de %.2f realizada com sucesso.\n", valor);
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() { return cliente; }

    protected void imprimirInfoComum() {
        System.out.printf("Titular: %s \n", this.cliente.getNome());
        System.out.printf("Agencia: %d \n", this.agencia);
        System.out.printf("Número da conta: %d \n", this.numero);
        System.out.printf("Saldo na conta: %.2f \n", this.saldo);
        System.out.println("=== ----------------------- ===");
    }

}
