import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        String nome = "Guilherme";
        String tipoConta = "Corrente";
        double saldo = 3200.00;
        double emprestimo = 0;
        boolean emprestimoDisponivel = true;
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        String menu = """
                ** Digite a sua opção **
                1 - Ver saldo
                2 - Transferir
                3 - receber
                4 - Empréstimo
                5 - Sair
                """;

        System.out.println("****************************");
        System.out.println("\nNome do cliente: " + nome);
        System.out.println("Tipo de conta: " + tipoConta);
        System.out.println("Saldo atual: R$ " + saldo);
        System.out.println("Empréstimo disponível: R$" + emprestimo);
        System.out.println("\n****************************");

        while (option != 5) {
            System.out.println(menu);
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("O saldo atualizado é de R$ " + saldo + " reais");
                    break;
                case 2:
                    System.out.println("Quanto você vai transferir?");
                    System.out.print("Valor: ");
                    double dinheiroDescontado = scanner.nextDouble();
                    scanner.nextLine();
                    if (dinheiroDescontado < 0) {
                        System.out.println("Valor inválido!");
                    } else if (dinheiroDescontado > saldo) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        System.out.print("Nome do titular que vai receber a transferência: ");
                        String nomeDoRecebedor = scanner.nextLine();
                        saldo -= dinheiroDescontado;
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
                        saldo += valorAReceber;
                        System.out.println("Você recebeu uma transferência de R$ " + valorAReceber + " reais");
                    }
                    break;
                case 4:
                    if (emprestimoDisponivel && emprestimo == 0) {
                        System.out.print("Quanto é o seu salário atual por mês: ");
                        double salario = scanner.nextDouble();
                        emprestimo = salario * 6;
                        System.out.println("baseado no seu salário, você pode pedir até R$ " + emprestimo + " reais de empréstimo");
                        System.out.println("Cada empréstimo que você fizer vai ser descontado do limite do teto previsto para o seu empréstimo que é de R$ " + emprestimo);
                    }
                    if (!emprestimoDisponivel) {
                        System.out.println("Empréstimo indisponível no momento, espere por seis meses para realizar um novo empréstimo");
                        break;
                    }
                    System.out.println("Quanto você quer receber?");
                    System.out.print("Valor: ");
                    double valorDoEmprestimo = scanner.nextDouble();
                    if (valorDoEmprestimo > emprestimo) {
                        System.out.println("Valor Acima do limite, coloque um valor abaixo do limite disponível!");
                        System.out.println("Valor disponível: R$ " + emprestimo);
                    } else {
                        emprestimo -= valorDoEmprestimo;
                        saldo += valorDoEmprestimo;
                        System.out.println("Empréstimo realizado com sucesso, empréstimo disponível agora é de R$ " + emprestimo);
                        if (emprestimo == 0) {
                            emprestimoDisponivel = false;
                            System.out.println("você chegou no limite previsto de empréstimos, e ele estará indisponível por seis meses");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Programa encerrado");
                    break;
                default:
                    System.out.println("Opção indisponível! Tente novamente");
                    break;
            }
        }
    }
}
