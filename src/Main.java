import br.com.alura.contabancaria.model.ContaBancaria;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria();
        conta.setNome("Guilherme");
        conta.setTipoDeConta("Corrente");
        System.out.println("Bem-vindo " + conta.getNome() + " , escolha uma das opções da sua conta " + conta.getTipoDeConta() + " abaixo:");
        conta.setMenu("""
                ********** Digite a sua opção **********
                1 - Ver informações da conta e saldo
                2 - Transferir
                3 - receber
                4 - Empréstimo
                5 - Sair
                """);

        while (conta.option != 5) {
            System.out.println(conta.getMenu());
            conta.option = scanner.nextInt();

            switch (conta.option) {
                case 1:
                    System.out.println("****************************");
                    System.out.println("\nNome do cliente: " + conta.getNome());
                    System.out.println("Tipo de conta: " + conta.getTipoDeConta());
                    System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    System.out.println("Empréstimo disponível: R$" + conta.getEmprestimo());
                    System.out.println("\n****************************");
                    break;
                case 2:
                    System.out.println("Quanto você vai transferir?");
                    System.out.print("Valor: ");
                    double dinheiroDescontado = scanner.nextDouble();
                    scanner.nextLine();
                    if (dinheiroDescontado < 0) {
                        System.out.println("Valor inválido!");
                    } else if (dinheiroDescontado > conta.getSaldo()) {
                        System.out.println("Saldo insuficiente!");
                    } else {
                        System.out.print("Nome do titular que vai receber a transferência: ");
                        String nomeDoRecebedor = scanner.nextLine();
                        conta.transferirDinheiro(dinheiroDescontado);
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
                        conta.sacarDinheiro(valorAReceber);
                        System.out.println("Você recebeu uma transferência de R$ " + valorAReceber + " reais");
                    }
                    break;
                case 4:
                    if (conta.isEmprestimoDisponivel() && conta.getEmprestimo() == 0) {
                        System.out.print("Quanto é o seu salário atual por mês: ");
                        double salario = scanner.nextDouble();
                        conta.gerarEmprestismo(salario);
                        System.out.println("baseado no seu salário, você pode pedir até R$ " + conta.getEmprestimo() + " reais de empréstimo");
                        System.out.println("Cada empréstimo que você fizer vai ser descontado do limite do teto previsto para o seu empréstimo que é de R$ " + conta.getEmprestimo());
                    }
                    if (!conta.isEmprestimoDisponivel()) {
                        System.out.println("Empréstimo indisponível no momento, espere por seis meses para realizar um novo empréstimo");
                        break;
                    }
                    System.out.println("Quanto você quer receber?");
                    System.out.print("Valor: ");
                    double valorDoEmprestimo = scanner.nextDouble();
                    if (valorDoEmprestimo > conta.getEmprestimo()) {
                        System.out.println("Valor Acima do limite, coloque um valor abaixo do limite disponível!");
                        System.out.println("Valor disponível: R$ " + conta.getEmprestimo());
                    } else {
                        conta.sacarEmprestimo(valorDoEmprestimo);
                        conta.sacarDinheiro(valorDoEmprestimo);
                        System.out.println("Empréstimo realizado com sucesso, empréstimo disponível agora é de R$ " + conta.getEmprestimo());
                        if (conta.getEmprestimo() == 0) {
                            conta.setEmprestimoDisponivel(false);
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
