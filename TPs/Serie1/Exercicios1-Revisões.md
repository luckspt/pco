# I – Tipos, operadores, variáveis, expressões, abstração procedimental

1. O que é um tipo de dados
    Um conjunto de valores e as operações que se podem fazer sobre esses valores.
2. Que tipos de dados conhece? Quais os valores e as operações de cada um desses tipos?
    String (não primitivo), int, double, char, float, boolean. Soma, subtração, multiplicação e divisão.
3. O que é uma variável? O que significa “declarar uma variável”? E “inicializar uma variável”?
    - Representação num programa que refere uma memória.
    - Reservar espaço para a variável.
    - Primeira vez que damos um valor a uma variável

4. Como se atribui um valor a uma variável? E como se “lê” o valor de uma variável?

    ```java
    nome = expressao;
    ```

    - usando o nome
5. O que é um literal?
    Uma constante (`3` é uma constante do tipo `int`)
6. O que é uma expressão?
    Algo que ao ser avaliado tem um valor e um tipo (um literal, o nome de uma variável, uma chamada a uma função, uma operação, ...)
7. O que é a precedência de operadores?

8. Em que situações se devem criar métodos (procedimentos ou funções)?
    - Para que não se repitam instruções.
    - Para estruturar (tornar o código mais legível).
9. Qual o papel dos parâmetros na definição dos métodos?
    Generaliza um método para ser utilizado em mais situações. Cria pontos de variação.
10. Qual o âmbito dos parâmetros e das variáveis definidos num método? (Onde podem ser usados)
    No corpo do método.
11. Como se invocam os métodos?

```java
nomeMetodo(argumento1, argumento2, ...);
```

13. Escreva um método que converta euros em dólares e devolva o resultado, considerando que um euro vale 1.18 dólares. Construa um programa que invoque esse método e imprima no ecrã `"<valor1> euros = <valor2> dolares"` para um valor `valor1` escolhido por si.

```java
public static void main() {
    double valor1 = 3.4;
    System.out.println(valor1 + " euros = " eurosToDollars(valor1) + "dolares");
}

static double eurosToDollars(double valor) {
    return valor * 1.18;
}
```

14. Generalize o método do exercício anterior de modo a que a taxa de câmbio possa variar.

```java
public static void main() {
    double valor1 = 3.4;
    System.out.println(valor1 + " euros = " toDollars(valor1, 1.18) + "dolares");
}

static double toDollars(double valor, double taxaCambio) {
    return valor * taxaCambio;
}
```

# II – boolean e condicionais

23. Assuma que `i` e `j` são duas variáveis de tipo `int` e `x` e `y` duas variáveis do tipo `double`. Escreva expressões java que exprimam os seguintes valores:
    - O resultado de testar a igualdade entre o dobro de `i` e a soma de `j` com `i`;
        `i*2 == j+i`
    - O resultado de testar se a soma de i com metade de x é menor que 3.5;
    - O resultado de testar se i é diferente do dobro de j;
        `i != 2*j`
    - O resultado de testar se i e j estão ambos no intervalo ]-6,6];
    - O resultado de testar se x é positivo ou está no intervalo ]-1,0[;
        `x > 0 || (x > -1 && x < 0)`
    - O resultado de testar se x é igual a y;

24. Considere os seguintes fragmentos de código. Que comentários escreveria em substituição dos `???`?

```java
if (i != 3 && j <= 4) {  // i é diferente de 3 e j menor ou igual a 4
    System.out.println("Olah"); 
} else {                 // ??? - i é igual a 3 e j é maior que 4 
    System.out.println("Adeus"); 
} 
```

```java
if (i != 3 || j <= 4) {  // i é diferente de 3 ou j menor ou igual a 4 
    System.out.println("Bom dia"); 
} else {
    if (z > j) {    // ??? i é igual a 3 e j é maior que 4 E z é maior que j
        System.out.println("Boa tarde"); 
    } else {        // ??? i é igual a 3 e j é maior que 4 E z é menor ou igual a j
        System.out.println("Boa noite"); 
    } 
}
```

25. Considere o fragmento de código abaixo. Qual destas instruções provocará um erro de compilação?

```java
int i = 0;  
System.out.println (i); 
if (i == 0) { 
    int j = 1; 
    System.out.println (i + j); 
} 
System.out.println (j); // esta. O `j` está definida no scope do if
```

# III – Ciclos

38. Escreva métodos para:
    - dado um inteiro positivo `n`, calcular a soma dos números positivos menores que `n`

    ```java
    int somaMenoresN(int n) {
        int soma = 0;
        for (int i=1; i<n; i++)
            soma += i;
        return soma;
    }
    ```

    - dado um inteiro positivo `n`, calcular a soma dos números positivos pares menores que `n`

    ```java
    int somaMenoresNPares(int n) {
        int soma = 0;
        for (int i=2; i<n; i+=2)
            soma += i;
        return soma;
    }
    ```

    - dados dois inteiros positivos `n` e `m`, calcular a soma dos números positivos maiores que `n` e menores que `m`

    ```java
    int somaEntreNM(int n, int m) {
        int soma = 0;
        for (; n<m; n++)
            soma += n;
        return soma;
    }
    ```

    - dado um inteiro positivo `n`, calcular o fatorial de `n` (`n`!)

    ```java
    int fatorial(int n) {
        int mult = 1;
        for (int i=1; i<n; i++)
            mult *= i;
        return mult;
    }
    ```

    - dado um inteiro positivo `n`, calcular o fatorial duplo de `n` (`n!!`); o fatorial duplo de `n` é `1×3×5× ... ×n` se `n` for ímpar e é `2×4×6× ... ×n` se `n` for par

    ```java
    int fatorialDuplo(int n) {
        int mult = 1;
        for (int i = (n%2 == 0 ? 2 : 1); i<n; i+=2)
            mult *= i;
        return mult;
    }
    ```

40. Escreva métodos para:
    - dado um inteiro positivo `n`, imprimir no ecrã uma linha com `n` asteriscos

    ```java
    void escreveNAsteriscos(int n) {
        for (int i=1; i<=n; i++)
            System.out.print("* ");
        System.out.println();
    }
    ```

    - dados dois inteiros positivos `n` e `m`, imprimir no ecrã um retângulo com `n` x `m` asteriscos

    ```java
    void escreveRetanguloAsteriscos(int n, int m) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++)
                System.out.print("* ");
            System.out.println();
        }
    }
    ```

    - dados dois inteiros positivos `n` e `m`, imprimir no ecrã um retângulo com `n` linhas cada uma com os números de 1 a `m`

    ```java
    void escreveRetanguloNumeros(int n, int m) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }
    ```

    - dados dois inteiros positivos `n` e `m`, imprimir no ecrã um retângulo com `n` linhas e `m` colunas, com os números de 1 a (`n` x `m`), ordenados da esquerda para a direita e de cima para baixo

    ```java
    void escreveRetanguloNumeros2(int n, int m) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++)
                System.out.print(j+i+(i*(n-1)) + 1 + " "); // ou ter um contador incrementado a cada iteração do ciclo interior
            System.out.println();
        }
    }
    ```

    - dados dois inteiros positivos `n` e `m`, imprimir no ecrã um retângulo com `n` linhas oco, ou seja, em que a 1ª e a última linhas têm `m` asteriscos seguidos e as restantes têm um asterisco na primeira posição e um asterisco na `m`–ésima posição.

    ```java
    void escreveRetanguloAsteriscosOco(int n, int m) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (i == 1 || i == n
                    || j == 1 || j == m)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    ```

    - imprimir no ecrã os triângulos correspondentes às alíneas c) a f)

    ```java
    // C
    void escreveTrianguloNumeros(int n) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    // D
    void escreveTrianguloNumeros2(int n) {
        int cnt=1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(cnt + " ");
                cnt++;
            }
            System.out.println();
        }
    }

    // E
    void escreveRetanguloAsteriscosOco(int n) {
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                if (i == 1 || i == n
                    || j == 1 || j == i)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
    ```

43. Construa os seguintes métodos:
    - dado um inteiro positivo `n`, determinar se `n` é perfeito (um número é perfeito se e só se for igual à soma dos seus divisores próprios; os divisores próprios de um número são todos os seus divisores exceto ele próprio; Ex: 6 – a soma de 1, 2 e 3 dá 6)
    - dado um inteiro positivo `n`, calcular o número de números perfeitos menores que `n`
    - dado um inteiro positivo `n`, calcular a soma dos dois números formados pela metade esquerda e pela metade direita dos algarismos de `n`. Se `n` tiver um número ímpar de algarismos, então será a metade esquerda que contará com mais um algarismo. *Exemplo*: a função `somaPartes` aplicada ao número `1234` terá `46` como resultado; quando aplicada ao número `8` terá `8` como resultado e quando aplicada ao número `123` terá `15` como resultado.
    ```java
    int somaPartes(int n) {
        int length = digLength(n);
        int metade = length / 2;
        int metadeEsq = length % 2 == 0 ? metade : metade + 1;
        
    }

    int digLength(int n) {
        return (int)(Math.log10(number) + 1);
    }
    ```


lista exs:
43 c)
44
31p