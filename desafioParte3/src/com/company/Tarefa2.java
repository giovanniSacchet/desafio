package com.company;

import com.company.model.Pessoa;

import java.util.Scanner;


public class Tarefa2 {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        Pessoa[] pessoas = new Pessoa[4];
        int idade, i;
        int idadeMulherMaisNova = 0, idadeMulherMaisVelha = 0, idadeHomemMaisNovo = 0, idadeHomemMaisVelho = 0;

        for(i = 0; i < 2; i++) {
            System.out.printf("Informe a idade dos 2 homens:");
            idade = ler.nextInt();
            pessoas[i] = new Pessoa();
            pessoas[i].setIdade(idade);
            pessoas[i].setSexo(true);
            if(i == 0) {
                idadeHomemMaisVelho = idade;
                idadeHomemMaisNovo = idade;
            }
            if(idadeHomemMaisVelho < idade) {
                idadeHomemMaisVelho = idade;
            }
            if(idadeHomemMaisNovo > idade) {
                idadeHomemMaisNovo = idade;
            }
        }
        System.out.println("\n");

        for(i = 2; i < 4; i++) {
            System.out.printf("Informe a idade das 2 mulheres:");
            idade = ler.nextInt();
            pessoas[i] = new Pessoa();
            pessoas[i].setIdade(idade);
            pessoas[i].setSexo(false);
            if(i == 2) {
                idadeMulherMaisVelha = idade;
                idadeMulherMaisNova = idade;
            }
            if(idadeMulherMaisVelha < idade) {
                idadeMulherMaisVelha = idade;
            }
            if(idadeMulherMaisNova > idade) {
                idadeMulherMaisNova = idade;
            }
        }

        System.out.println("\nSoma das idades do homem mais velho com a mulher mais nova.\n");
        System.out.println("Homem mais velho: "+ idadeHomemMaisVelho +" Mulher mais nova: "+ idadeMulherMaisNova +
                "\nSoma das idades: "+ (idadeHomemMaisVelho + idadeMulherMaisNova));

        System.out.println("\n\nProduto das idades do homem mais novo com a mulher mais velha.\n");
        System.out.println("Homem mais novo: "+ idadeHomemMaisNovo +" Mulher mais velha: "+ idadeMulherMaisVelha +
                "\n Produto das idades: "+ (idadeHomemMaisNovo * idadeMulherMaisVelha));

    }
}
