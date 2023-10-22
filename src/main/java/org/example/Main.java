// TODO: Renomear p/ o nome do pacote criado, caso dê erro na compilação
package org.example;

import java.util.Scanner;

public class Main {

    private static int[][] criaMatriz(Scanner s, String nomeMatriz) {
        System.out.printf("Digite o número de linhas da matriz %s:", nomeMatriz);
        int linhas = s.nextInt();

        System.out.printf("Digite o número de colunas da matriz %s:", nomeMatriz);
        int colunas = s.nextInt();

        int[][] matriz = new int[linhas][colunas];

        System.out.printf("Digite os elementos da matriz %s:\n", nomeMatriz);
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matriz[i][j] = s.nextInt();
            }
        }

        return matriz;
    }

    private static void verificaOperacao(int colunas, int linhas) {
        if(colunas != linhas) {
            System.out.println("ERRO: As matrizes não podem realizar a operação de multiplicação.");
            System.out.println("INFO: O número de colunas da matriz A deve ser igual ao número de linhas da matriz B.");
            System.exit(1);
        }
    }

    private static void exibeMatriz(int[][] matriz, String nomeMatriz, int qntDeLinhas, int qntDeColunas) {
        System.out.printf("Matriz %s:\n", nomeMatriz);
        for (int i = 0; i < qntDeLinhas; i++) {
            System.out.print("[");
            for (int j = 0; j < qntDeColunas; j++) {
                System.out.print(" " + matriz[i][j] + " ");
            }
            System.out.print("]\n");
        }
        System.out.println();
    }

    private static void multiplicaMatrizes(int[][] matrizA, int[][] matrizB, int linhasMatrizA, int colunasMatrizA, int colunasMatrizB) {
        int[][] matrizResultante = new int[linhasMatrizA][colunasMatrizB];

        for(int i = 0; i < linhasMatrizA; i++) {
            for(int j = 0; j < colunasMatrizA; j++) {
                for(int k = 0; k < matrizResultante.length; k++) {
                    matrizResultante[i][j] += matrizA[i][k] * matrizB[k][j];
                }
            }
        }

        exibeMatriz(matrizResultante, "C", matrizResultante.length, matrizResultante[0].length);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        final int[][] matrizA = criaMatriz(s, "A");
        final int[][] matrizB = criaMatriz(s, "B");

        final int linhasMatrizA = matrizA.length;
        final int colunasMatrizA = matrizA[0].length;

        final int linhasMatrizB = matrizB.length;
        final int colunasMatrizB = matrizB[0].length;

        verificaOperacao(colunasMatrizA, linhasMatrizB);

        exibeMatriz(matrizA, "A", linhasMatrizA, colunasMatrizA);
        System.out.println("X\n");
        exibeMatriz(matrizB, "B", linhasMatrizB, colunasMatrizB);
        System.out.println("=\n");
        multiplicaMatrizes(matrizA, matrizB, linhasMatrizA, colunasMatrizA, colunasMatrizB);

        s.close();
    }
}
