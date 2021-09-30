package pt.fc.ul.alunos.fc56926.pco.semana1;

/* Neste exercício pode e deve usar a função sqrt da classe Math.
   Exemplo: Math.sqrt(25) é uma expressão cujo valor é 5.0.
   O seu valor é calculado pelo método public static double sqrt (double a) fornecido pela classe Math (API da classe Math aqui.)

   Observe o excerto de programa definido pela classe Raizes.java (https://moodle.ciencias.ulisboa.pt/pluginfile.php/369190/mod_page/content/11/Raizes.java).
   Crie uma classe igual no seu projeto Eclipse.

   Sabendo que as raízes de uma equação de 2º grau da forma ax2 + bx + c = 0 são dadas pela fórmula x = (-b +- sqrt(b^2 - 4ac)) / 2a,
    complete o programa Raizes para que calcule e imprima no ecrã as raízes da equação definida pelas variáveis a, b e c.
   Compile e execute o seu programa, corrigindo erros se necessário.

   Experimente alterar os valores usados para inicializar as variáveis, compilando e executando de novo o programa.

   Teste com valores críticos. Quais são eles? O que acontece?
 */
public class Exerc4_FormulaResolvente {
    public static void main(String[] args) {
        double a = 1;
        double b = -4;
        double c = 3;

        double raiz = Math.sqrt(b*b - 4*a*c);
        double resMais = (-b + raiz) / (2*a);
        double resMenos = (-b - raiz) / (2*a);

        System.out.println(String.format("Resultados:\n%.5f\n%.5f", resMais, resMenos));
    }
}
