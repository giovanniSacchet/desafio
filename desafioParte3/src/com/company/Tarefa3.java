package com.company;

public class Tarefa3 {

    public static void main(String[] args) {
        int primeiroNumero = 1;
        String sequencia = "1 2 3 4 5 6 7 8 9 10";

        for(int i = 0; i < 5; i++) {
            System.out.println("("+ primeiroNumero +", "+ sequencia +")");
            primeiroNumero += 2;
        }

        System.out.println("\n(10, "+ sequencia +") Nao entra por 10 ser par.");
    }
}
