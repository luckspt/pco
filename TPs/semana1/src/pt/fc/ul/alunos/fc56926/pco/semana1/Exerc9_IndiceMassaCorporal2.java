package pt.fc.ul.alunos.fc56926.pco.semana1;

public class Exerc9_IndiceMassaCorporal2 {
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
        String descricao;
        if (imc < 15) descricao = "muito abaixo do peso";
        else if(imc < 19) descricao = "abaixo do peso";
        else if (imc < 25) descricao = "peso normal";
        else if (imc < 30) descricao = "acima do peso";
        else if (imc < 40) descricao = "obeso";
        else descricao = "muito obeso";

        System.out.println(String.format("O seu IMC e': %.5f\nDescricao: %s", imc, descricao));
    }
}
