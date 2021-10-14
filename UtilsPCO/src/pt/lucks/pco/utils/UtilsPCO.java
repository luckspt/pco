package pt.lucks.pco.utils;

import java.util.Random;

public class UtilsPCO {
    public static void main(String[] args) {
        int[] v = new int[] {7,0,1,3,6,12};
        UtilsPCO.imprimeVetor( UtilsPCO.maxMin(v) );
//        System.out.println(res);
    }

    /**
     * Se o inteiro x está presente no vetor v
     * @param v Vetor a procurar
     * @param x Inteiro a encontrar
     * @return Se x está presente em v
     */
    public static boolean existe (int[] v, int x) {
        for (int i=0; i<v.length; i++)
            if (v[i] == x)
                return true;
        return false;
    }

    /**
     * Conta as ocorrências de x em v
     * @param v Vetor onde procurar
     * @param x Inteiro a encontrar
     * @return Ocorrências de x em v
     */
    public static int quantos (int[] v, int x) {
        int qtd = 0;
        for (int i=0; i<v.length; i++) {
            if (v[i] == x)
                qtd++;
        }

        return qtd;
    }

    /**
     * Imprime os valores de v, entre parêntesis retos, separados por vírgulas
     * @param v Vetor a imprimir
     */
    public static void imprimeVetor (int[] v) {
        for (int i=0; i<v.length; i++) {
            System.out.print(String.format("[%d]", v[i]));

            if (i != v.length-1)
                System.out.print(", ");
        }
    }

    /**
     * Concatena os vetores v com w
     * @param v Vetor base
     * @param w Vetor a concatenar
     * @return Vetor concatenado de v com w
     */
    public static int[] junta (int[] v, int[] w) {
        int[] concatenado = new int[v.length + w.length];
        for (int i=0; i<v.length; i++)
            concatenado[i] = v[i];

        for (int i=0; i<w.length; i++)
            concatenado[v.length + i] = w[i];

        return concatenado;
    }

    /**
     * Concatena dois vetores ordenados
     * @requires v e w sejam vetores ordenados
     * @param v Vetor a concatenar
     * @param w Vetor a concatenar
     * @return Vetor ordenado
     */
    public static int[] juntaOrdenado (int[] v, int[] w) {
        int[] result = new int[v.length + w.length];
        int i=0, j=0, k=0;

        while (i<v.length && j<w.length) {
            if (v[i] < w[j]) {
                result[k] = v[i];
                i++;
            } else {
                result[k] = w[j];
                j++;
            }
            k++;
        }

        while (j<w.length) {
            result[k] = w[j];
            j++; k++;
        }

        while(i<v.length) {
            result[k] = v[i];
            i++; k++;
        }

        return result;
    }

    /**
     * Substitui as entradas em v iguais a valAntes com o valor valDepois
     * @param v Array com valores a substituir
     * @param valAntes Valor a procurar
     * @param valDepois Valor a substituir
     */
    public static void substitui (int[] v, int valAntes, int valDepois) {
        for (int i=0; i<v.length; i++) {
            if (v[i] == valAntes)
                v[i] = valDepois;
        }
    }

    /**
     * Inverte o array v
     * @param v Array a inverter
     */
    public static void inverte (int[] v) {
        for (int i=0; i < v.length / 2; i++) {
            int tmp = v[i];
            v[i] = v[v.length - i - 1];
            v[v.length - i - 1] = tmp;
        }
    }

    /**
     * Procura os extremos de v
     * @param v Array a encontrar os extremos
     * @return Array com o índice do maior e menor valor, respetivamente
     */
    public static int[] maxMin (int[] v) {
        int[] pos = new int[2];

        for (int i=1; i<v.length; i++) {
            if (v[i] > v[pos[0]])
                pos[0] = i;
            if (v[i] < v[pos[1]])
                pos[1] = i;
        }

        return pos;
    }

    /**
     * Compara se os vetores são iguais
     * @param v Vetor a comparar
     * @param w Vetor a comparar
     * @return Se os vetores v e w são iguais
     */
    public boolean iguais (int[] v, int[] w) {
        boolean iguais = v.length == w.length;
        for (int i=0; i<v.length && iguais; i++)
            if (v[i] != w[i])
                iguais = false;
        return iguais;
    }

    /**
     * Gera uma melodia aleatória a partir das notas, com n notas
     * @param notas Notas possívels na melodia
     * @param n Quantidade de notas na melodia
     * @return Uma melodia de notas separadas por ponto
     */
    public static String melodia (String[] notas, int n) {
        Random gerador = new Random();
        StringBuilder melodia = new StringBuilder();

        for (int i=0; i<n; i++) {
            melodia.append(notas[gerador.nextInt(notas.length)]);
            if (i != n-1)
                melodia.append(".");
        }

        return melodia.toString();
    }

    /**
     * Cria uma nova palavra a partir dos índices v e a palavra fonte
     * @param v Índices para originar a palavra
     * @param fonte Palavra fonte
     * @return Nova palavra
     */
    public static String palavrasNovas (int[] v, String fonte) {
        StringBuilder palavraNova = new StringBuilder();
        int comprimento = fonte.length();

        for (int idx : v)
            palavraNova.append(fonte.charAt(idx >= comprimento ? comprimento-1 : idx));

        return palavraNova.toString();
    }

    /**
     * Cria uma família com todas as strings presentes em v que contenham s
     * @param s String a conter
     * @param v Strings a adicionar à família
     * @return Strings da familia separadas por ponto
     */
    public static String familia(String s, String[] v) {
        StringBuilder familia = new StringBuilder();

        for (int i=0; i<v.length; i++) {
            if (v[i].indexOf(s) != -1) {
                familia.append(v[i]);

                if (i != v.length-1)
                    familia.append(".");
            }
        }

        return familia.toString();
    }

    /**
     * Conta as ocorrências dos valores [0, top[ em v
     * @param v Valores a contar as ocorrências
     * @param top Até que valor contar (exclusivo)
     * @return Ocorrências dos valores
     */
    public static int[] contaOcorrencias (int[] v, int top) {
        int[] ocorrencias = new int[top];

        for (int valor : v) {
            if (valor >= 0 && valor < top)
                ocorrencias[valor]++;
        }

        return ocorrencias;
    }

}
