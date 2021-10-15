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
```java
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
```

d) `int[] junta (int[] v, int[] w)` que devolve um vetor contendo os elementos de `v` seguidos dos elementos de `w`;

```java
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

f) `void substitui (int[] v, int valAntes, int valDepois)` que substitui todas as ocorrências do valor `valAntes` em `v` pelo valor `valDepois`;

```java
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
```

g) `void inverte (int[] v)` que inverte a ordem dos elementos de `v`. Faça-o de duas formas diferentes:
- recorrendo a um vetor auxiliar;

```java
/**
 * Inverte o array v
 * @param v Array a inverter
 */
public static void inverte (int[] v) {
    int[] invertido = new int[v.length];

    for (int i=0; i<v.length; i++)
        invertido[v.length - i - 1] = v[i];

    for (int i=0; i<invertido.length; i++)
        v[i] = invertido[i];
}
```

- sem recorrer a outro vetor;

```java
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
```

h) `int[] maxMin (int[] v)` que constrói e devolve um vetor com 2 inteiros, correspondentes às posições onde se encontram, no vetor `v`, os seus valores máximo e mínimo, respetivamente;

```java
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
```

i) `int[] doisMaiores (int[] v)` que constrói e devolve um vetor de duas posições contendo os dois máximos do vetor `v`, assumindo que `v` tem pelo menos duas posições;

```java
/**
 * Procura os dois maiores números de v
 * @param v Vetor a procurar
 * @return Dois maiores números do vetor por ordem crescente
 */
public static int[] doisMaiores (int[] v) {
    int[] maiores = new int[] { v[0], v[1] };

    for (int i=2; i<v.length; i++) {
        if (maiores[0] > maiores[1])
            UtilsPCO.inverte(maiores);

        if (v[i] > maiores[0])
            maiores[0] = v[i];
        else if (v[i] > maiores[1])
            maiores[1] = v[i];
    }

    // não fica muito bem aqui
    if (maiores[0] > maiores[1])
        UtilsPCO.inverte(maiores);

    return maiores;
}
```

j) `int[] pedeVetor (int n, Scanner sc)` que, assumindo que `n` é positivo e `sc` não é `null`, pede ao utilizador `n` valores inteiros e devolve um vetor com esses valores;

```java
/**
 * Primeiro inteiro no canal de leitura
 * @param errMess - mensagem a escrever no System.out caso o valor
 *              acessivel no canal de leitura nao seja um inteiro
 * @param sc - canal de leitura
 * @return valor inteiro
 * @requires errMess != null && sc != null
 */
public static int lerInteiro (String errMess, Scanner sc) {
    int valor = 0;
    boolean erro = true;
    do {
        if (sc.hasNextInt()) {
            valor = sc.nextInt();  // consome o inteiro
            erro = false;
        } else {
            sc.next(); // consome o que lah esteja
            System.out.println(errMess);
        }
    } while (erro);

    return valor;
}

/**
 * Pede n inteiros
 * @param n Quantidade de inteiros a pedir
 * @param sc Scanner de onde ler os inteiros
 * @return Inteiros recebidos
 */
public static int[] pedeVetor (int n, Scanner sc) {
    int[] nums = new int[n];
    System.out.printf("Insira %d:\n", n);

    for (int i=0; i<n; i++)
        nums[i] = lerInteiro("Formato de inteiro errado, tente novamente.", sc);

    return nums;
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

19. Acrescente à classe `UtilsPCO` o método `String palavrasNovas (int[] v, String fonte)` que constrói e devolve uma *string* contendo uma palavra com tantas letras quantas o tamanho de `v`, formada por letras da *string* `fonte`;
o conteúdo do vetor *v* indica as posições na *string* `fonte` onde se devem ir buscar as letras para formar a nova *string*;
se a posição indicada não existe na *string* `fonte`, a letra a usar deverá ser a da última posição de `fonte`.
Use a classe `StringBuilder`. Apresente também um cabeçalho *javadoc* apropriado.
Exemplo: se `v` for `{5,0,4,3,15,7,5,4}` e `fonte` for `"ABEDILOGUY"`, o resultado será `"LAIDYGLI"`.
```java
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
```

20. Acrescente à classe `UtilsPCO` o método `static String melodia (String[] notas, int n)` que constrói e devolve uma *string* resultante de juntar aleatoriamente `n` *strings* do vetor notas separadas por pontos.
 
Exemplo: se `notas` for `{"la", "mi", "sol"}` e `n` for `7`, um possível resultado será `"mi.mi.sol.la.mi.la.la"`.

Use as classes `Random` e `StringBuilder`. Apresente também um cabeçalho *javadoc* apropriado.
```java
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
```

21. Acrescente à classe `UtilsPCO` o método `int[] contaOcorrencias (int[] v, int top)` que devolve um vetor com `top` elementos, contendo em cada posição o número de ocorrências no vetor `v` do valor correspondente à *posição* (onde *posição* varia entre `0` e `top-1`).
Caso `v` tenha valores fora do intervalo `0` a `top-1` (inclusive) estes não serão contabilizados.

Por exemplo, se o procedimento for chamado com o vetor `{0,-1,3,1,6,0,5,2,12,3,0}` e valor `top` `6`, então o resultado será `{3,1,1,2,0,1}`(zero tem três ocorrências, um e dois têm uma ocorrência cada, três tem duas ocorrências, quatro não tem ocorrências, cinco tem uma ocorrência).

Assuma que o vetor a analisar não é vazio e que `top` é um valor positivo. Apresente também um cabeçalho *javadoc* apropriado.
```java
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
```


23. Acrescente à classe `UtilsPCO` o método `static String familia(String s, String[] v)` que constrói e devolve uma *string* resultante de juntar as *strings* do vetor `v` que contêm `s`, separadas por pontos.
Exemplo: se `v` for `{"mareado", "longe", "Pai Natal", "amarelo", "rema"}` e `s` for `"mar"`, o resultado será `"mareado.amarelo"`.

Apresente também um cabeçalho javadoc apropriado.

Use a classe `StringBuilder`.

Use também o método `public int indexOf (String str)`, da classe `String`, que retorna a posição da primeira ocorrência de `str` na *string* alvo da invocação, ou -1 se `str` não ocorre.
Exemplos: Se `String alvo = "OlaAdeus"`, então `alvo.indexOf("Ola")` retorna `0`, `alvo.indexOf("Adeus")` retorna `3` e `alvo.indexOf("ela")` retorna `-1`.
```java
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
```