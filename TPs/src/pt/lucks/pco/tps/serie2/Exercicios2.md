# Série 2

4. Escreva um método que, dada uma frase `f` e um valor positivo `n` menor que metade do comprimento
da frase, devolva a string resultante de concatenar os `n` primeiros carateres de `f` com os últimos `n`.  
Construa um programa que invoque o método para uma dada frase e inteiro e imprima no ecrã o seu resultado em maiúsculas.

```java
public class ConcatenaFrase {
    public static void main(String []args){
        String f = "ola_batata-fixe";
        int n = 4;
        
        String novaFrase = concatenaFrase(f, n);
        System.out.println(novaFrase);
    }
     
    /**
     * @requires n < s.length()/2 && s != null
     */
    static String concatenaFrase(String f, int n) {
        return f.substring(0, n) + f.substring(f.length()-n);
    }
}
```

5. Escreva um programa que, começando numa palavra definida por si, imprima no ecrã as palavras resultantes de ir retirando, um a um, os carateres do meio da  palavra anterior, até chegar a uma palavra com um só caráter. Se o número de carateres da palavra for par, será retirado o primeiro dos dois carateres do meio.

*Exemplo*:  se for *rapsodia* a palavra por si escolhida, o programa deverá imprimir as palavras *rapsodia*, *rapodia*, *rapdia*, *radia*, *raia*, *ria*, *ra* e *a*.

Para isso, construa uma função com a assinatura `static String semLetraMeio (String s)` que devolva a string resultante de "retirar" o caráter do meio de `s`.  

```java
public class SemLetrasMeio {

    public static void main(String []args){
        String f = "rapsodia";
        
        while(f.length() >= 1) {
            System.out.println(f);
            f = semLetraMeio(f);
        }
    }
     
    static String semLetraMeio(String s) {
        int metade = s.length() / 2;
        return s.substring(0, metade - (s.length() % 2 == 0 ? 1 : 0))
             + s.substring(s.length() - metade);
    }
}
```

14. Acrescente os seguintes métodos à classe `UtilsPCO`, não se esquecendo de, para cada um deles, apresentar um cabeçalho *javadoc* apropriado:
a) `boolean existe (int[] v, int x)` que verifica se existe alguma ocorrência de `x` em `v`;

```java
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
```

b) `int quantos (int[] v, int x)` que conta o número de ocorrências do valor `x` em `v`;

```java
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
```

c) `boolean iguais (int[] v, int[] w)` que verifica se os vetores v e w são iguais;

d) `int[] junta (int[] v, int[] w)` que devolve um vetor contendo os elementos de `v` seguidos dos elementos de `w`;

```java
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
```

e) `int[] juntaOrdenado (int[] v, int[] w)` que recebe dois vetores ordenados de forma crescente, e devolve um vetor ordenado da mesma forma cujos elementos são todos os que pertencem a `v` ou `w`;

```java
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
```

k) `void imprimeVetor (int[] v)` que escreve no *standard output* os elementos do vetor `v` entre parenteses retos, separados por vírgulas.

```java
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
```
