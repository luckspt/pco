package pt.fc.ul.alunos.fc56926.pco.semana1;

// O Índice de Massa Corporal (IMC) permite perceber se um indivíduo está com excesso de peso. O IMC calcula-se dividindo o peso pelo quadrado da altura.
public class Exerc6_IndiceMassaCorporal {
    /**
     * Este metodo invoca o metodo valorIMC e escreve no
     * standard output mensagem de acordo com o valor do IMC
     * @param args Nao sao usados
     */
    public static void main(String[] args) {
        // inicializar as variáveis com o seu peso e altura;
        double peso = 55;
        double altura = 1.70;

        // imprimir no ecrã o seu IMC (deve invocar o método valorIMC);
        // calcular e imprimir IMC
        double imc = peso / (altura * altura);
        valorIMC(imc);
    }


    /**
     * Imprime o IMC no ecra
     * @param imc Valor do IMC
     */
    public static void valorIMC (double imc) {
        System.out.println(String.format("O seu IMC e': %.5f", imc));
    }
}
