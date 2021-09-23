package pt.fc.ul.alunos.fc56926.pco.semana1;

public class Exerc1 {
    public static void main(String[] args) {
        // 1. Escreva um programa que declara e inicializa quatro variáveis que representem o dia da semana, o dia do mês, o nome do mês e o ano, respetivamente. Decida os tipos das variáveis. Execute o seu programa, corrigindo eventuais erros.
        int diaMes, ano;
        String diaSemana, nomeMes;

        diaMes = 22;
        ano = 2021;
        diaSemana = "Quarta-Feira";
        nomeMes = "Setembro";

        // 2. Acrescente instruções para imprimir no ecrã o valor de cada variável, um por linha.
        System.out.println(diaSemana + "\n" + diaMes + "\n" + nomeMes + "\n" + ano);

        // 3. Acrescente instruções para imprimir a data representada pelas variáveis no formato Quarta-feira, 22 de Setembro de 2021.
        printFormatoLongo(diaSemana, diaMes, nomeMes, ano);

        // 4. Acrescente instruções para também imprimir a data representada pelas variáveis no formato Quarta-feira, Setembro 22, 2021.
        printFormatoCurto(diaSemana, diaMes, nomeMes, ano);
    }

    static void printFormatoLongo(String diaSemana, int diaMes, String nomeMes, int ano) {
        System.out.println(diaSemana + ", " + diaMes + " de " + nomeMes + " de " + ano);
    }

    static void printFormatoCurto(String diaSemana, int diaMes, String nomeMes, int ano) {
        System.out.println(diaSemana + ", " + nomeMes + " " + diaMes + ", " + ano);
    }
}
