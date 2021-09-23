package pt.fc.ul.alunos.fc56926.pco.semana1;

public class Exerc7_EspelhoNumero {
    public static void main(String[] args) {
        int valor = 123;

        printValorEspelho(valor, espelhoValor(valor));
    }

    /**
     * Espelha um valor
     * @param valor Valor a espelhar
     * @return Valor espelhado
     */
    static int espelhoValor(int valor) {
        int espelho;

        espelho = valor % 10;
        espelho *= 10;

        espelho += (valor / 10) % 10;
        espelho *= 10;

        espelho += (valor / 100) % 10;
        return espelho;
    }

    /**
     * Imprime o valor e o seu espelho no ecra
     * @param valor Valor
     * @param espelho Espelho do valor
     */
    static void printValorEspelho(int valor, int espelho) {
        System.out.println(String.format("Imagem de %d ao espelho e' %d", valor, espelho));
    }
}
