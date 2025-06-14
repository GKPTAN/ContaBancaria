package br.com.alura.contabancaria.model;

public class ContaCorrente extends ContaBancaria {
    private double tarifaMensal;

    public void setTarifaMensal(double tarifaMensal) {
        this.tarifaMensal = tarifaMensal;
    }

    public void cobrarTarifaMensal() {
        saldo -= tarifaMensal;
        System.out.println("Tarifa mensal de R$" + tarifaMensal + " reais cobrada. Saldo atual: " + saldo);
    }
}
