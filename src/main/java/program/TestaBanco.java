package program;

import entities.BancoList;
import entities.Conta;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;

public class TestaBanco {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        BancoList banco = new BancoList("VictorBanks", "212/232");
        System.out.print("Deseja adicionar uma conta [S/N]? ");
        String vontade = input.nextLine();

        if (vontade.toUpperCase().charAt(0) == 'S') {
            int numeroMenu;
            do {

                System.out.println();

                System.out.println("----------------MENU DO BANCO----------------");
                System.out.print("1. ADICIONAR CONTA \n"
                + "2. TRANSFERÊNCIA \n"
                + "3. CONTAS NEGATIVADAS \n"
                + "4. CONSULTAR SALDO \n"
                + "5. SACAR DA CONTA \n"
                + "6. DEPOSITAR NA CONTA \n"
                + "7. PESQUISAR CONTAS DE UM CLIENTE \n"
                + "8. SAIR DO APLICATIVO DO BANCO \n");

                System.out.println();

                System.out.print("DIGITE O NUMERO DE UMA DAS OPÇÕES: ");
                numeroMenu = input.nextInt();
                input.nextLine();
                System.out.println();

                String cpfDoTitular = "";
                String numDaConta = "";
                String numDaAgencia = "";
                double valor = 0.0;


                switch (numeroMenu) {
                    case 1:

                        System.out.println("------------ADICIONAR CONTA---------------");
                        System.out.println();

                        System.out.println("DIGITE O CPF DO TITULAR DA CONTA: ");
                        cpfDoTitular = input.nextLine();
                        System.out.println("DIGITE O NUMERO DA CONTA: ");
                        numDaConta = input.nextLine();
                        System.out.println("DIGITE O NUMERO DA AGENCIA DA CONTA: ");
                        numDaAgencia = input.nextLine();
                        System.out.println("DIGITE O SALDO INICIAL DA CONTA: ");
                        valor = input.nextInt();
                        input.nextLine();
                        System.out.println();

                        banco.abrirConta(cpfDoTitular, numDaConta, numDaAgencia, valor);
                        break;

                    case 2:

                        System.out.println("---------TRANSFERENCIA-----------");
                        System.out.println();

                        System.out.println("DIGITE O NUMERO DA CONTA QUE IRÁ ENVIAR O VALOR: ");
                        numDaConta = input.nextLine();
                        System.out.println("DIGITE O NUMERO DA AGENCIA DA CONTA QUE IRÁ ENVIAR O VALOR: ");
                        numDaAgencia = input.nextLine();
                        System.out.println("DIGITE O NUMERO DA CONTA QUE IRÁ RECEBER O VALOR: ");
                        String numDaContaD = input.nextLine();
                        System.out.println("DIGITE O NUMERO DA AGENCIA DA CONTA QUE IRÁ RECEBER O VALOR: ");
                        String numDaAgenciaD = input.nextLine();
                        System.out.println("VALOR A SER TRANSFERIDO: ");
                        valor = input.nextInt();
                        input.nextLine();
                        System.out.println();

                        banco.transferir(numDaConta, numDaAgencia, numDaContaD, numDaAgenciaD, valor);
                        System.out.println();
                        break;


                    case 3:

                        System.out.println("=======LISTA CONTAS NEGATIVADA=======");
                        ArrayList<Conta> listNegativados = banco.contasNegativadas();
                        System.out.println();

                        if(!listNegativados.isEmpty()) {
                            for (Conta negativos : listNegativados) {
                                System.out.println(negativos);
                            }
                        } else {
                            System.out.println("LISTA DE NEGATIVADOS VAZIA");
                        }

                        break;

                    case 4:

                        System.out.print("DIGITE O NUMERO DA CONTA QUE VOCÊ DESEJA PESQUISAR: ");
                        numDaConta = input.nextLine();
                        System.out.print("DIGITE O NUMERO DA AGENCIA QUE VOCÊ DESEJA PESQUISAR: ");
                        numDaAgencia = input.nextLine();
                        System.out.println();

                        banco.consultarSaldo(numDaConta,numDaAgencia);

                        break;

                    case 5:

                        System.out.print("DIGITE O NUMERO DA CONTA QUE VOCE VAI SACAR: ");
                        numDaConta = input.nextLine();
                        System.out.print("DIGITE O NUMERO DA AGENCIA: ");
                        numDaAgencia= input.nextLine();
                        System.out.print("DIGITE O VALOR DO SAQUE: ");
                        valor = input.nextDouble();
                        input.nextLine();

                        banco.sacarDaConta(numDaConta,numDaAgencia,valor);

                        break;

                    case 6:

                        System.out.print("DIGITE O NUMERO DA CONTA QUE VOCE VAI DEPOSITAR: ");
                        numDaConta = input.nextLine();
                        System.out.print("DIGITE O NUMERO DA AGENCIA: ");
                        numDaAgencia = input.nextLine();
                        System.out.print("DIGITE O VALOR DO DEPOSITO: ");
                        valor = input.nextDouble();
                        input.nextLine();

                        banco.depositarEmConta(numDaConta,numDaAgencia,valor);

                        break;
                    case 7:

                        System.out.println("DIGITE O CPF DO TITULAR DA CONTA: ");
                        cpfDoTitular = input.nextLine();
                        ArrayList<Conta> contasDaConta = banco.pesquisarContasDoCliente(cpfDoTitular);

                        for (Conta c: contasDaConta){
                            System.out.println(c);
                        }

                        break;
                    case 8:

                        System.out.println("APLICATIVO FINALIZADO!");
                        break;

                    default:
                        System.out.println("DIGITE UMA OPÇÃO VALIDA");
                }
            } while (numeroMenu != 8);
        }
        input.close();
    }
}
