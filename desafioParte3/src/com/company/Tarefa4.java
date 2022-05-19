package com.company;


public class Tarefa4 {

    public static void main(String[] args) {
        int[] array1 = {1, 5, 9, 12}, array2 = {3, 7, 10, 15};
        int[] arrayFinal = new int[8];
        int i, aux;

        for(i = 0; i < 4; i++) {
            arrayFinal[i] = array1[i];
        }
        for(i = 0; i < 4; i++) {
            arrayFinal[i+4] = array2[i];
        }

        //Ordena ArrayFinal
        for(i = 0; i < 8; i++) {
            for(int j = 0; j < 7; j++) {
                if(arrayFinal[j] > arrayFinal[j + 1]) {
                    aux = arrayFinal[j];
                    arrayFinal[j] = arrayFinal[j+1];
                    arrayFinal[j+1] = aux;
                }
            }
        }

        System.out.println("Array Final Ordenado:");
        for(i = 0; i < 8; i++) {
            System.out.println(" "+arrayFinal[i]);
        }
    }
}
