package entities;

import java.util.ArrayList;

public class BancoList {
    private String nome;
    private String cnpj;
    ArrayList<Conta> contas = new ArrayList<>();
    ArrayList<Conta> contasNegativadas = new ArrayList<>();

    public BancoList(String nome, String cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public void transferir(String numContaO, String numAgenciaO, String numContaD, String numAgenciaD, double valor) {
        if (!(this.contas.isEmpty())) {
            for (Conta conta : contas) {
                if (conta.getNumeroConta().equals(numContaO) && conta.getNumeroAgencia().equals(numAgenciaO)) {
                    conta.debitar(valor);
                    System.out.println("TRANSFERÊNCIA CONCLUIDA! ");
                }
            }
        } else {
            System.out.println("TRANSFERÊNCIA NÃO CONCLUIDA");
        }
    }

    public void abrirConta(String cpfTitular, String numConta, String numAgencia, double valorInicial) {
        contas.add(new Conta(cpfTitular, numConta, numAgencia, valorInicial));
        System.out.println("Conta Criada com sucesso.");
    }

    public ArrayList<Conta> contasNegativadas() {
        ArrayList<Conta> contasNegativadas = new ArrayList<>();
        for (Conta conta : contas) {
            if (conta.getSaldo() <= 0 & !contasNegativadas.contains(conta)) {
                contasNegativadas.add(conta);
            }
        }
        return contasNegativadas;
    }

    public double consultarSaldo(String numConta, String numAgencia) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numConta) && conta.getNumeroAgencia().equals(numAgencia)) {
                System.out.print("Saldo da conta de CPF: " + conta.getCpfTitular() + " é de: R$ " + String.format("%.2f", conta.getSaldo()) + "\n");
                return conta.getSaldo();
            }
        }
        System.out.println("Essa conta não foi encontrada! ");
        return 0.0;
    }

    public double sacarDaConta(String numConta, String numAgencia, double value) {
        boolean podeSacar = false;
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numConta) && conta.getNumeroAgencia().equals(numAgencia)) {
                if (conta.getSaldo() < value) {
                    System.out.println("Saldo insuficiente! ");
                    return -1;
                } else {
                    System.out.println("CONCLUIDO O SAQUE!");
                    podeSacar = true;
                }
                if (podeSacar) {
                    conta.debitar(value);
                    System.out.printf("O novo saldo da conta de CPF: %s, é de: R$ %.2f \n", conta.getCpfTitular() , conta.getSaldo());
                }
                return conta.getSaldo();
            }
        }
        return consultarSaldo(numConta, numAgencia);
    }

    public double depositarEmConta(String numConta, String numAgencia, double value) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numConta) && conta.getNumeroAgencia().equals(numAgencia)) {
                conta.creditar(value);
                consultarSaldo(numConta, numAgencia);
                return conta.getSaldo();
            }
        }
        return consultarSaldo(numConta, numAgencia);
    }

    public ArrayList<Conta> pesquisarContasDoCliente(String cpf) {
        ArrayList<Conta> contasCliente = new ArrayList<>();
        if (contas.isEmpty()) {
            throw new RuntimeException("Não há contas.");
        } else {
            for (Conta conta : contas) {
                if (conta.getCpfTitular().equals(cpf)) {
                    contasCliente.add(conta);
                }
            }
            return contasCliente;
        }
    }

}