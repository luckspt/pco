<!-- TOC -->

- [Nomenclatura](#nomenclatura)
  - [Classes](#classes)
  - [Variáveis e Métodos](#variáveis-e-métodos)
- [Comentários](#comentários)
  - [Documentação](#documentação)
- [Tipos de dados](#tipos-de-dados)
  - [Primitivos](#primitivos)
    - [Boolean](#boolean)
  - [Não primitivos](#não-primitivos)
    - [String](#string)
  - [Métodos](#métodos)
  - [Comparação de Objetos](#comparação-de-objetos)
- [STDOUT](#stdout)
- [Precedências](#precedências)
- [Declaração de variáveis](#declaração-de-variáveis)
- [Operadores](#operadores)
  - [Soma](#soma)
    - [Concatenação](#concatenação)
  - [Divisão](#divisão)
  - [Quociente e Resto](#quociente-e-resto)
- [Classes](#classes-1)
  - [Métodos](#métodos-1)
    - [Funções](#funções)
- [Condicionais](#condicionais)
  - [Comparação Números Reais](#comparação-números-reais)
  - [Switch](#switch)
  - [Expressões condicionais (ternary)](#expressões-condicionais-ternary)
- [Ciclos](#ciclos)
  - [Atalhos](#atalhos)
  - [While e Do...While](#while-e-dowhile)

<!-- /TOC -->

## Nomenclatura

CaSe sENsiTiVe

### Classes

Começam com letra maiúscula (UpperCamelCase) e as conjunções de palavras também: `NomeDaClasse`.

### Variáveis e Métodos

Métodos começam com letra minúscula (camelCase) e as conjunções começam com letra maiúscula: `taxaImposto`.

Podem começar por `$` ou `_` mas são usados em código de mais baixo nível.

Não podem ser palavras reservadas: `if`, `break`, ...

## Comentários

```java
// Uma linha

/*
    Bloco
*/

/** 
  * Java doc
  */
```

### Documentação

```java
/**
  * Descrição do método
  * @param nomeParametro descrição do parametro
  * @return Descrição do resultado da função (opcional. Para )
```

## Tipos de dados

### Primitivos

Tipos do Java. Não são classes.

- int
- double
- float
- boolean
- char (definido como `'a'`)
- ...

Exemplos

```java
10 // int
22.3 // double
250 + 120 // dois operandos int e o resultado é int
"Dias desde o inicio das aulas: 3" // string
```

#### Boolean

Universo de valores: `true` e `false`
Operações:

- `&&` and
- `&` and bit-a-bit
- `||` or
- `|` or bit-a-bit
- `!` not

Podem ser aplicados a numéricos o `>`, `<`, `>=`, `<=`, `==` e `!=` que retornam um `boolean`.

### Não primitivos

- Definidos por uma **Classe**.
- Valores (instâncias da classe) são **objetos**.
- Operações (tipo funções) são **métodos**.

Exemplos de tipos não primitivos:

- String
- Aluno
  - objeto que tem nome, número, turma, ...

#### String

```java
String s1 = "Tigre";
```

A variável `s1` não temo valor "Tigre" mas sim uma referência ao objeto que tem o conteúdo.

```java
String s2 = s1;
```

Como em java todos os objetos são referências, `s1` é uma referência. Quando atribuído ao `s2`, o valor da referência de `s1` é copiado para o `s2` e ficam ambos a apontar para o mesmo objeto em memória.

### Métodos

Os métodos não-estáticos chamam-se através de `nomeObjeto.nomeMétodo`
Os métodos estáticos chamam-se através de `NomeClasse.nomeMétodo`

```java
String s1 = "Tigre";
s1.charAt(0); //Caracter no índice 0. Valor: 'T'
s1.charAt(5); //Atira uma exceção `IndexOutOfBoundsException` porque o índice 5 não existe na String s1
s1.length(); //Comprimento da String. Valor: 5 

String s2 = s1.toLowerCase(); // "Tigre" em minúsculas. Valor: "tigre"
```

### Comparação de Objetos

```java
Boolean iguais = s1 == s2; // false.
```

Porquê? `s1` e `s2` são objetos. Comparação entre eles são feitos pela referência.
Para comparar `String`s teríamos de usar o método `String::equals`

## STDOUT

Classe `System.out`.

`System.out.println` escreve na consola com `\n` no fim. (o `print` do python)
`System.out.print` escreve na consola sem `\n`

```java
// 250 + 120 = 370
System.out.print("250 + 120"); // imprime o texto
System.out.println(250 + 120); // imprime o resultado e muda de linha
```

## Precedências

1. Mutliplicação e Divisão
2. Soma e Subtração

## Declaração de variáveis

Tipagem forte, é obrigatório definir o tipo (ao contrário do Python).
Sem atribuir, a variável não tem valor. Em classes, o valor é `null`.
Os nomes das variáveis são únicos no seu scope.

```java
// Declaração
//   T nome;
int x, y;
double z;

// Atribuição
x = 3;

// Declaração com atribuição
int a = x / 10;
```

## Operadores

### Soma

#### Concatenação

```java
"Resultado = " + 250 // "Resultado = 250"
```

Mas com a precedência,

```java
// Por causa das precedências serem as mesmas (duas somas), o Java faz da esquerda para a direita. Concatena o "Resultado = " com 250 e depois "Resultado = 250" com 120.
// Isto resolve-se com parêntesis.
"Resultado = " + 250 + 120 // "Resultado = 250120".
```

### Divisão

Quando um dos operadores é real, a divisão é real. Caso contrário, a divisão é inteira.

```java
// x = 470
int z = x / 10; // z = 4

double w = x / 10; // w = 4.0. A divisão foi inteira.
w = x / 10.0; // w = 4.7. A divisão foi real.
```

### Quociente e Resto

```java
// x = 470
(x / 10) * 10 //
x % 10 //
```

## Classes

### Métodos

#### Funções

Processam e precisam de retornar algo.

```java
// tipo_retorno nome (tipo_parametro parametro, ...) { }

/**
  * Java doc
  */
static double media (int n1, int n2, int n3) {
    // Corpo do método
    return (n1 + n2 + n3) / 3;
}
```

<hr/>

Calcular nota final

```java
static void main() {
  int nota = notaFinal(16.2, 18.3);
}

static int notaFinal (double exame, double trab) {
  double nota = exame * 0.70 + trab * 0.30;
  return (int)(nota + 0.5);
}

#### Procedimentos

Não retornam mas normalmente afetam o objeto.

O tipo de retorno é `void`.

```java
static void imprimeTresLinhas() {
  System.out.println("linha");
  System.out.println("linha");
  System.out.println("linha");
}
```

## Condicionais

```java
// Uma linha
if (expressao_booleana)
  bloco_condicional;

// Várias linhas
if (expressao_booleana) {
  bloco_condicional;
  bloco_condicional;
  bloco_condicional;
}

// If then Else
if (expressao_booleana)
  se_verdadeiro;
else
  se_falso;
```

```java
// Função "complicada".
static boolean ePar(int n) {
  boolean result;
  if (n % 2 == 0)
    result = true;
  else
    retult = false;
  
  return result;
}

// Podemos não ter uma variável "result" e simplificar a função.
static boolean ePar(int n) {
  if (n % 2 == 0)
    return true;
  else
    return false;
}

// Se o if avalia para true, vamos retornar true. Caso contrário, retorna false.
// Podemos então simplificar para
static boolean ePar(int n) {
  return n % 2 == 0;
}
```

### Comparação Números Reais

```java
double x = 10.1
double r = x / 1.1;
r = r * 1.1;

// São exatamente iguais?
if (r == x) // false
  System.out.println("iguais!");
else
  System.out.println("diferentes!");
```

O resultado é "diferentes!" porque x = 10.1 e r = 10.099999999999998

Isto acontece por causa da precisão.

Uma solução é haver um threshold da diferença entre os dois.

```java
public static boolean iguais(double x, double y, double delta) {
  return Math.abs(x - y) < delta;
}

iguais(x, r, 0.001); // true
```

### Switch

If... else if... else if... vários desses

```java
switch (mes) {
  case 1: System.out.println("Janeiro");
  break;
  case 2: System.out.println("Fevereiro");
  break;
  case 3: System.out.println("Marco");
  break;
  case 4: System.out.println("Abril");
  break;
  case 5: System.out.println("Maio");
  break;
  case 6: System.out.println("Junho");
  break;
  case 7: System.out.println("Julho");
  break;
  case 8: System.out.println("Agosto");
  break;
  case 9: System.out.println("Setembro");
  break;
  case 10: System.out.println("Outubro");
  break;
  case 11: System.out.println("Novembro");
  break;
  case 12: System.out.println("Dezembro");
  break;
  default: System.out.println("Valor inválido!");
  break;
}
```

O `break` faz com que o `case` acabe. Sem ele, podemos encadear cases e criar comportamento comulativo.

O `default` é o caso executado quando nenhum dos casos anteriores é executado, como se fosse o último `else`.

### Expressões condicionais (ternary)

x = se n > 10 põe 1. se não põe 2
=> `x = n > 10 ? 1 : 2;`

Estas expressões necessitam obrigatoriamente dos dois valores. Não é como o `if` que pode não ter o `else`.

```java
int n = 10;
int x;

// If simples. Podemos fazer isto numa linha
if (n > 10)
  x = 1;
else
  x = 2;

//  exp_bool ? valorTrue : valorFalse
x = n > 10 ? 1 : 2;
```

Escrever o numero e se é Par ou Impar

```java
int n = 43;
System.out.println(n + ePar(n) ? " e' Par" : "e' Impar");
```

## Ciclos

### Atalhos

- `var++`

  ```java
  int i = 5;
  i++;  // i = i+1; ou i += 1
  ```

- `var--`

  ```java
  int j = 6;
  j--; // j = j-1; ou j -= 1
  ```

- `var += valor`
- `var -= valor`
- `var *= valor`

  ```java
  i *= j + 7; // i = i * (j + 7)
- `var /= valor`
- `var %= valor`

### For

Principalmente utilizado quando sabemos a quantidade de vezes que o ciclo itera.

```java
for (inicializacao; guarda; progresso)
  bloco_instruções
```

As declarações de variáveis dentro do `for` (inclusive na inicialização) são limpas de memória quando o ciclo termina.

A inicialização, guarda, e progresso são opcionais. Podemos ter ciclos sem inicialização (usam variáveis já definidas), sem guarda (usam `break;` para terminar o ciclo no bloco_instruções), e/ou sem progresso (pode ser feito no bloco_instruções).

O progresso deve-se aproximar da falsificação da guarda.
O seguinte ciclo é "infinito" (faz underflow) pois não se aproxima da falsificação da guarda - começa a 1 e vai diminuindo, logo não chega a 10.

```java
for (int i=1; i<=10; i--) {
  System.out.println(i);
}
```

Exemplos:

- Imprime "la\n" 10 vezes
  1. Inicializa i como inteiro com valor 1
  2. Avalia a guarda. Se verdadeiro execucta o bloco. Cc acaba
  3. Progresso
  4. Voltar ao ponto 2.

  ```java
  for (int i=1; i<=10; i++)
    System.out.println("la");
  ```

- Imprimir os números pares de 1 a 20

  ```java
  for (int i=1; i<=20; i++) {
    if (i % 2 == 0)
      System.out.println(i);
  }
  ```

  Mas esta solução tem de fazer a pergunta "é par" a todas as iterações. Podemos ter antes:

  ```java
  for (int i=1; i<=10; i++) {
    System.out.println(i * 2);
  }
  ```

  Ou ter antes a seguinte solução para `i` ser sempre par no corpo do ciclo.

  ```java
  for (int i=2; i<=20; i+=2) {
    System.out.println(i);
  }
  ```

- Imprimir `n` asteriscos em 4 linhas

```java
int n = ?;
for (int i=1; i<=4; i++) {
  // Imprimir n asteriscos
  
  for (int j=1; j<=n; j++) {
    System.out.print("*");
  }

  // Mudança de linha, se não os asteriscos ficam todos na mesma linha
  System.out.print("\n");
}
```

- Menor divisor de n que seja maior que um

```java
static int menorDivisorMaiorQueUm(int n) {
  int resultado = n;
  for (int i=2; i<=n/2 && resultado == n; i++) {
    // Verificar se é divisor de n
    if (n % i == 0)
      resultado = i;
  }

  return resultado;
}
```

### While e Do...While

Principalmente utilizado quando não sabemos a quantidade de vezes que o ciclo itera.

- While

  ```java
  while (expressao_booleana) //Enquanto verdade faz "bloco_instrucoes"
    bloco_instrucoes
  ```

  Exemplo:

  ```java
  static int algarismoEsq(int num) {
    while (num >= 10)
      num /= 10;
    
    return num;
  }

  algarismoEsq(123); // 1
  ```

  ```java
  static int qtdAlgarismos(int num) {
    int cnt = 1;
    while (num >= 10) {
      num /= 10;
      cnt++;
    }
    
    return cnt;
  }

  qtdAlgarismos(123); // 3
  ```

- Do...While
  A diferença entre o `while` e o `do...while` é que o primeiro executa a guarda no início. O `do...while` executa no fim, portanto o corpo é executado pelo menos uma vez.

  ```java
  do {
    bloco_instrucoes
  } while (expressao);
  ```

  Exemplo:

  ```java
  static int qtdAlgarismos(int num) {
    int cnt = 0;
    do {
      num /= 10;
      cnt++;
    }
    while (num >= 10) {
    
    return cnt;
  }

  qtdAlgarismos(123); // 3
  ```
