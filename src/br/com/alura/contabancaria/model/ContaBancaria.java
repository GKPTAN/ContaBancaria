package br.com.alura.contabancaria.model;

public class ContaBancaria {
    private String nome;
    private String tipoDeConta;
    protected double saldo = 0.00;
    private double emprestimo = 0.00;
    private boolean emprestimoDisponivel = true;
    public int option = 0;
    private String menu;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setTipoDeConta(String tipoDeConta) {
        if (tipoDeConta.equalsIgnoreCase("corrente") || tipoDeConta.equalsIgnoreCase("poupança")) {
            this.tipoDeConta = tipoDeConta;
        } else {
            System.out.println("Erro: Escolha entre conta corrente ou conta poupança, por favor!");
        }
    }

    public String getTipoDeConta() {
        return tipoDeConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getEmprestimo() {
        return emprestimo;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public boolean isEmprestimoDisponivel() {
        return emprestimoDisponivel;
    }

    public void setEmprestimoDisponivel(boolean emprestimoDisponivel) {
        this.emprestimoDisponivel = emprestimoDisponivel;
    }

    public void transferirDinheiro(double valor) {
        saldo -= valor;
    }

    public void sacarDinheiro(double valor) {
        saldo += valor;
    }

    public void gerarEmprestismo(double valor) {
        emprestimo = valor * 6;
    }

    public void sacarEmprestimo(double valor) {
        emprestimo -= valor;
    }
}
