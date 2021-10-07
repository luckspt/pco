public class UtilsPCO {
    public static void main(String[] args) {
        int[] v = { 11, 43, 64 };

        UtilsPCO.imprimeVetor( UtilsPCO.juntaOrdenado(v, v) );
//        System.out.println(res);
    }

    /**
     * Se o inteiro x está presente no vetor v
     * @param v Vetor a procurar
     * @param x Inteiro a encontrar
     * @return Se x está presente em v
     */
    static boolean existe (int[] v, int x) {
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
    static int quantos (int[] v, int x) {
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
    static void imprimeVetor (int[] v) {
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
    static int[] junta (int[] v, int[] w) {
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
    static int[] juntaOrdenado (int[] v, int[] w) {
        int[] concatenado = new int[v.length + w.length];
        int iV = 0, iW = 0;

        for (int i=0; i < concatenado.length; i++) {
            if (iV >= v.length)
                concatenado[i] = w[iW];
            else if(iW >= w.length)
                concatenado[i] = v[iV];
            else if (v[iV] < w[iW])
                concatenado[i] = v[iV++];
            else
                concatenado[i] = w[iW++];
        }

        return concatenado;
    }

    /**
     * Compara se os vetores são iguais
     * @param v Vetor a comparar
     * @param w Vetor a comparar
     * @return Se os vetores v e w são iguais
     */
    boolean iguais (int[] v, int[] w) {
        boolean iguais = v.length == w.length;
        for (int i=0; i<v.length && iguais; i++)
            if (v[i] != w[i])
                iguais = false;
        return iguais;
    }
}
