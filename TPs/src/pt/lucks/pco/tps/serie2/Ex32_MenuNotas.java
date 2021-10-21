package pt.lucks.pco.tps.serie2;

import pt.lucks.pco.utils.UtilsPCO;

import java.util.Scanner;

public class Ex32_MenuNotas {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Insira a quantidade de alunos: ");
        int qtdAlunos = UtilsPCO.lerInteiro("Inteiro inválido. Tente novamente", leitor);

        System.out.print("Insira a quantidade de notas de cada aluno: ");
        int qtdNotas = UtilsPCO.lerInteiro("Inteiro inválido. Tente novamente", leitor);

        double[][] notas = new double[qtdAlunos][qtdNotas];

        System.out.print("Insira as notas de cada aluno: ");
        for (int i = 0; i < notas.length; i++)
            notas[i] = UtilsPCO.pedeVetorReais(qtdNotas, leitor);

        System.out.println("Insira o peso das notas: ");
        double[] pesos = UtilsPCO.pedeVetorReais(qtdNotas, leitor);
    }
}
