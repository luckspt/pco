package pt.fc.ul.alunos.fc56926.pco.semana1;

public class Exerc8_NotasIf {
    public static void main(String[] args) {
        // Escreva um programa que
        // declare 3 variáveis com o tipo int representando notas (entre 0 e 20) de 3 exercícios práticos;
        // inicialize estas variáveis com valores apropriados e
        int nota1 = 19;
        int nota2 = 8;
        int nota3 = 20;

        int qtdPositivas = 0;

        if (nota1 >= 10) qtdPositivas++;
        if (nota2 >= 10) qtdPositivas++;
        if (nota3 >= 10) qtdPositivas++;

        int maior;
        if (nota1 > nota2) {
             if (nota1 > nota3)
                 maior = nota1;
             else
                 maior = nota3;
        } else {
            if (nota2 > nota3) maior = nota2;
            else maior = nota3;
        }

        // imprima no ecrã a nota do melhor exercício e quantas foram as notas positivas (>= 10).
        System.out.println("Maior nota: " + maior);
        System.out.println("Qtd notas positivas: " + qtdPositivas);
    }
}
