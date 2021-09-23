# PCO

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

## Tipos de dados

### Primitivos

Tipos do Java. Não são classes.

- int
- double
- float
- boolean
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

Classes criadas (por nós, por ex.)

- String
- Aluno
  - objeto que tem nome, número, turma, ...

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
