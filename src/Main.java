//import br.com.alura.contabancaria.model.ContaBancaria;
import br.com.alura.contabancaria.model.ContaCorrente;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ContaBancaria conta = new ContaBancaria();
        ContaCorrente contaCorrente = new ContaCorrente();
        //conta.setNome("Guilherme");
        contaCorrente.setNome("Gustavo");
        //conta.setTipoDeConta("Poupança");
        contaCorrente.setTipoDeConta("Corrente");
        System.out.println("Bem-vindo " + contaCorrente.getNome() + " , escolha uma das opções da sua contaCorrente " + contaCorrente.getTipoDeConta() + " abaixo:");
        /*conta.setMenu("""
                ********** Digite a sua opção **********
                1 - Ver informações da contaCorrente e saldo
                2 - Transferir
                3 - receber
                4 - Empréstimo
                5 - Sair
                """);

         */
        contaCorrente.setMenu("""
                ********** Digite a sua opção **********
                1 - Ver informações da conta e saldo
                2 - Transferir
                3 - receber
                4 - Empréstimo
                5 - pagar Tarifa Mensal
                6 - Sair
                """);

        while (contaCorrente.option != 6) {
            //System.out.println(conta.getMenu());
            System.out.println(contaCorrente.getMenu());
            //conta.option = scanner.nextInt();
            contaCorrente.option = scanner.nextInt();

            switch (contaCorrente.option) {
                case 1:
                    System.out.println("****************************");
                    System.out.println("\nNome do cliente: " + contaCorrente.getNome());
                    System.out.println("Tipo de conta: " + contaCorrente.getTipoDeConta());
                    System.out.println("Saldo atual: R$ " + contaCorrente.getSaldo());
                    System.out.println("Empréstimo disponível: R$" + contaCorrente.getEmprestimo());
                    System.out.println("\n****************************");
                    break;
                case 2:
                    System.out.println("Quanto você vai transferir?");
                    System.out.print("Valor: ");
                    double dinheiroDescontado = scanner.nextDouble();
                    scanner.nextLine();
                    if (dinheiroDescontado < 0) {
                        System.out.println("Valor inválido!");
                    } else if (dinheiroDescontado > contaCorrente.getSaldo()) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        System.out.print("Nome do titular que vai receber a transferência: ");
                        String nomeDoRecebedor = scanner.nextLine();
                        contaCorrente.transferirDinheiro(dinheiroDescontado);
                        System.out.println("Transferência de R$ " + dinheiroDescontado + " reais para o titular " + nomeDoRecebedor + " realizado com sucesso");
                    }
                    break;
                case 3:
                    System.out.println("Quanto você vai receber?");
                    System.out.print("Valor: ");
                    double valorAReceber = scanner.nextDouble();
                    if (valorAReceber < 0) {
                        System.out.println("Valor inválido!");
                    } else {
                        contaCorrente.sacarDinheiro(valorAReceber);
                        System.out.println("Você recebeu uma transferência de R$ " + valorAReceber + " reais");
                    }
                    break;
                case 4:
                    if (contaCorrente.isEmprestimoDisponivel() && contaCorrente.getEmprestimo() == 0) {
                        System.out.print("Quanto é o seu salário atual por mês: ");
                        double salario = scanner.nextDouble();
                        contaCorrente.gerarEmprestismo(salario);
                        System.out.println("baseado no seu salário, você pode pedir até R$ " + contaCorrente.getEmprestimo() + " reais de empréstimo");
                        System.out.println("Cada empréstimo que você fizer vai ser descontado do limite do teto previsto para o seu empréstimo que é de R$ " + contaCorrente.getEmprestimo());
                    }
                    if (!contaCorrente.isEmprestimoDisponivel()) {
                        System.out.println("Empréstimo indisponível no momento, espere por seis meses para realizar um novo empréstimo");
                        break;
                    }
                    System.out.println("Quanto você quer receber?");
                    System.out.print("Valor: ");
                    double valorDoEmprestimo = scanner.nextDouble();
                    if (valorDoEmprestimo > contaCorrente.getEmprestimo()) {
                        System.out.println("Valor Acima do limite, coloque um valor abaixo do limite disponível!");
                        System.out.println("Valor disponível: R$ " + contaCorrente.getEmprestimo());
                    } else {
                        contaCorrente.sacarEmprestimo(valorDoEmprestimo);
                        contaCorrente.sacarDinheiro(valorDoEmprestimo);
                        System.out.println("Empréstimo realizado com sucesso, empréstimo disponível agora é de R$ " + contaCorrente.getEmprestimo());
                        if (contaCorrente.getEmprestimo() == 0) {
                            contaCorrente.setEmprestimoDisponivel(false);
                            System.out.println("você chegou no limite previsto de empréstimos, e ele estará indisponível por seis meses");
                        }
                    }
                    break;
                case 5:
                    contaCorrente.setTarifaMensal(25);
                    contaCorrente.cobrarTarifaMensal();
                case 6:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção indisponível! Tente novamente");
                    break;
            }
        }
    }
}
