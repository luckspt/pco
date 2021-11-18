# Exercicios Série 4
## Herança
2. Considere as seguintes classes. Identifique os vários problemas que o compilador assinalará. Justifique a sua resposta.
```java
public class A {
    private int v;
    
    public A(int i) {
        this.v = i;
    }
    
    public int v() {
        return this.v + this.x;
    }
}
```
```java
public class B extends A {
    private int x;
    
    public B() {
        this.x = 1.0;
    }
    
    public B(int i, int j) {
        this.v = i;
        this.x = j;
    }
}
```
- Classe A
  - o atributo `x` não existe
- Classe B
  - o atributo `v` não existe em `B` (somente em `A`)
  - `1.0` é um literal de tipo `double` associado a um atributo do tipo `int`
  - os construtores não invocam o instrutor da superclasse
    - o compilador coloca, por omissão, `super()`, mas `A` não tem esse construtor 

3. Considere as seguintes classes.
```java
public class A {
    private int v;
    public static final int FIRST = 3;
 
    public A() {
        this.v = FIRST;
    }
    
    public A(int i) {
        this.v = i;
    }
 
    public int value() {
        return this.v;
    }
}
```
```java
public class B extends A {
    private double x;
    
    public B() {
        this.x = this.value() * 2;
    }
    
    public B(int i) {
        super();
        this.x = i;
    }
    
    public B(int i, int j) {
        super(i);
        this.x = j;
    }
    
    public double x() {
        return this.x;
    }
}
```

O que apareceria no ecrã caso se executasse cada uma das sequências de instruções que se seguem:
- a) `B b = new B(); System.out.println(b.value() + " " + b.x());`
  - 3 6.0
- b) `B b = new B(4); System.out.println(b.value() + " " + b.x());`
  - 3 4.0
- c) `B b = new B(3, 2); System.out.println(b.value() + " " + b.x());`
  - 3 2.0

4. Considere as classes `Adega` e `AdegaEspecial` definidas abaixo.
```java
public class Adega {
    private int[] quantidades;
    
    /**
    * Inicializa o novo objeto
    * @param nCubas O numero de cubas que a nova adega vai ter
    * @requires nCubas > 0
    */
    public Adega (int nCubas) {
        this.quantidades = new int [nCubas];
    }
    
    /**
    * Quantidade de líquido numa dada cuba
    * @param nCuba Numero de ordem da cuba
    * @return Quantidade de líquido na cuba numero nCuba
    * @requires nCuba >= 0 && nCuba < this.totalCubas()
    */
    public int quantidade(int nCuba) {
        return this.quantidades[nCuba];
    }
    
    /**
    * Acrescenta liquido a uma dada cuba
    * @param nCuba Numero de ordem da cuba
    * @param litros Numero de litros a acrescentar
    * @requires nCuba >= 0 && nCuba < this.totalCubas() && litros > 0
    */
    public void acrescenta(int nCuba, int litros) {
        this.quantidades[nCuba] += litros;
    }
    /**
    * Quantas cubas tem a adega?
    * @return
    */
    public int totalCubas() {
        return this.quantidades.length;
    }
}
```
```java
public class AdegaEspecial extends Adega {
    /**
    * Inicializa o novo objeto
    * @param nCubas O numero de cubas que a nova adega vai ter
    * @requires nCubas > 0
    */
    public AdegaEspecial (int nCubas) {
        super(nCubas);
    }
    
    /**
    * Acrescenta 'as cubas desta adega quantidades de liquido dadas
    * @param litros As quantidades a acrescentar 'as cubas, pela mesma
    * ordem da ordem das cubas
    * @requires litros != null && litros.length == this.totalCubas()
    */
    public void acrescentaACada(int[] litros) {
        for(int i = 0 ; i < this.totalCubas() ; i++) {
            this.acrescenta(i, litros[i]);
        }
    }
}
```

- a) Apresente um diagrama UML que capture a estrutura dessas classes e a forma como se relacionam.
```mermaid
classDiagram
  Adega <|-- AdegaEspecial
  
  class Adega {
    -int[] quantidades
    +quantidade(int nCuba) int
    +acrescenta(int nCuba, int litros) void
    +totalCubas() int
  }
  
  class AdegaEspecial {
    +acrescentaACada(int[] litros) void
  }
```
[Mermaid (gráfico)](https://mermaid-js.github.io/mermaid/#/./classDiagram)

- b) Diga, justificando, se as seguintes instruções são aceites pelo compilador.
  0. `int[] v = {25, 12, 30, 22, 60, 55};` sim
  1. `Adega a1 = new Adega(6);` sim
  2. `AdegaEspecial ea1 = new AdegaEspecial(4);` sim
  3. `Adega a2 = new AdegaEspecial(7);` sim
  4. `AdegaEspecial ea2 = new Adega(3);` não, `Adega` não é compatível com `AdegaEspecial`
  5. `ea1.acrescenta(1,25);` sim
  6. `ea1. acrescentaACada(v);` sim
  7. `a2.acrescenta(3,10);` sim
  8. `a1.acrescentaACada(v);` não, `Adega` não tem o método `acrescentaACada`
  9. `a2.acrescentaACada(v);` não, `Adega` não tem o método `acrescentaACada`
  10. `a2 = ea1;` sim
  11. `ea1 = a2;` não, `Adega` não é compatível com `AdegaEspecial`
  12. `int x = a1.quantidade(1);` sim
  13. `x = a2.quantidade(1);` sim
  14. `x = ea1.quantidade(1);` sim
  15. `a1.acrescenta(3,-10);` sim

- c) Contando somente com as instruções corretas, represente o estado do sistema à medida que as instruções são
  executadas.
- d) Que métodos podem ser invocados sobre `a1`, `ea1` e `a2`? Justifique.
Sobre `a1` e `a2` podem ser invocados os métodos públicos da classe `Adega` que incluem todos os métodos de `Object`
Sobre `ea1` podem ser invocados os métodos públicos da classe `AdegaEspecializada` que incluem todos os métodos públicos da classe `Adega`

5. Considere de novo a classe Adega definida no exercício 4
- a) Fazendo uso da herança, crie uma classe que represente uma adega comunitária (ver API) em que quando se acrescenta vinho a uma cuba, se o resultado de adicionar essa nova quantidade à quantidade já existente nessa cuba for superior à quantidade máxima existente nalguma cuba da adega, a quantidade a acrescentar deverá ser distribuída por todas as cubas da adega.

```java
public class Adega {
  private int[] quantidades;

  /**
   * Inicializa o novo objeto
   * @param nCubas O numero de cubas que a nova adega vai ter
   * @requires nCubas > 0
   */
  public Adega(int nCubas) {
    this.quantidades = new int[nCubas];
  }

  /**
   * Quantidade de líquido numa dada cuba
   * @param nCuba Numero de ordem da cuba
   * @return Quantidade de líquido na cuba numero nCuba
   * @requires nCuba >= 0 && nCuba < this.totalCubas()
   */
  public int quantidade(int nCuba) {
    return this.quantidades[nCuba];
  }

  /**
   * Acrescenta liquido a uma dada cuba
   * @param nCuba Numero de ordem da cuba
   * @param litros Numero de litros a acrescentar
   * @requires nCuba >= 0 && nCuba < this.totalCubas() && litros > 0
   */
  public void acrescenta(int nCuba, int litros) {
    this.quantidades[nCuba] += litros;
  }

  /**
   * Quantas cubas tem a adega?
   * @return
   */
  public int totalCubas() {
    return this.quantidades.length;
  }
}

public class EcoAdega extends Adega {
  public EcoAdega(int nCubas) {
    super(nCubas);
  }
  
  private int maxLitrosCubas() {
    int qtdCubas = this.totalCubas();
    int max = this.quantidade(0);

    for (int i=0; i<qtdCubas; i++) {
      int qtd = this.quantidade(i);
      if (qtd > max)
        max = qtd;
    }
    
    return max;
  }

  /**
   * 
   * @param nCuba Numero de ordem da cuba
   * @param litros Numero de litros a acrescentar
   * @requires nCuba >= 0 && nCuba < this.totalCubas() && litros > 0
   */
  @Override
  public void acrescenta(int nCuba, int litros) {
    int qtdCubas = this.totalCubas();
      
    if (this.quantidade(nCuba) + litros > this.maxLitrosCubas()) {
      int nLitros = litros / qtdCubas;
      
      for (int i=0; i<qtdCubas; i++)
          super.acrescenta(i, nLitros);
    } else
        super.acrescenta(nCuba, litros);
  }
}
```