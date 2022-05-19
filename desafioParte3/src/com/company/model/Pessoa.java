package com.company.model;

public class Pessoa {
    private int idade;

    //True = Homem, False = Mulher
    private boolean sexo;

    public Pessoa() {
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
