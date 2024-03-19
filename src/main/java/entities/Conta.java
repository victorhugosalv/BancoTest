package entities;

public class Conta {

    private String cpfTitular;
    private String numeroConta;
    private String numeroAgencia;
    private Double saldo;

    public Conta(){}

    public Conta(String cpfTitular, String numeroConta, String numeroAgencia, double saldo){
        this.cpfTitular = cpfTitular;
        this.numeroConta = numeroConta;
        this.numeroAgencia = numeroAgencia;
        this.saldo = saldo;
    }

    public String getCpfTitular(){
        return cpfTitular;
    }

    public String getNumeroConta(){
        return numeroConta;
    }

    public String getNumeroAgencia(){
        return numeroAgencia;
    }

    public double getSaldo(){
        return saldo;
    }

    public void setCpfTitular(String novoCpf){
        this.cpfTitular = novoCpf;
    }

    public void setNumeroConta(String novoNumeroConta){
        this.numeroConta = novoNumeroConta;
    }

    public void setNumeroAgencia(String novoNumeroAgencia){
        this.numeroAgencia = novoNumeroAgencia;
    }

    public void setSaldo(double novoSaldo){
        this.saldo = novoSaldo;
    }

    public double creditar(double value){
        saldo += value;
        return saldo;
    }

    public double debitar(double value){
        saldo -= value;
        return saldo;
    }

    @Override
    public String toString(){
        return "Conta número: " + numeroConta + " do cliente de CPF: " + cpfTitular;
    }
}
