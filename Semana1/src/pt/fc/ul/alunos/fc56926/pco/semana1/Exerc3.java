package pt.fc.ul.alunos.fc56926.pco.semana1;

public class Exerc3 {
    public static void main(String[] args) {
        // 1. Desenvolva um programa que:
        // declara e inicializa três variáveis representando um instante do dia, dado pelas horas, minutos e segundos;
        int horas, minutos, segundos, totalSegundos;

        horas = 2;
        minutos = 21;
        segundos = 13;

        // calcula e imprime no ecrã o número de segundos que passaram desde a meia-noite; o formato de apresentação do resultado deverá estar de acordo com o seguinte exemplo: São 2h 21m 13s. Passaram 8473 segundos desde a meia-noite
        totalSegundos = horas * 3600 + minutos * 60 + segundos;

        printInstanteDia(horas, minutos, segundos);
        printSegundosPassados(totalSegundos);

        System.out.println("-------------");

        // 2. Desenvolva agora um programa para efetuar a conversão no sentido oposto, ou seja, que:
        // declara e inicializa uma variável que representa o número de segundos que passaram desde a meia-noite;
        totalSegundos = 4563;

        // calcula e imprime o instante do dia, dado pelas horas, minutos e segundos; o formato de apresentação do resultado deverá estar de acordo com o seguinte exemplo: Passaram 8473 segundos desde a meia-noite, logo sao 2h 21m 13s.
        horas = totalSegundos / 3600;
        minutos = (totalSegundos % 3600) / 60;
        segundos = totalSegundos % 60;

        printInstanteDia(horas, minutos, segundos);
        printSegundosPassados(totalSegundos);
    }

    static void printInstanteDia(int horas, int minutos, int segundos) {
        System.out.println("São " + horas + "h " + minutos + "m " + segundos + "s.");
    }

    static void printSegundosPassados(int segundos) {
        System.out.println("Passaram " + segundos + " segundos desde a meia-noite");
    }
}
