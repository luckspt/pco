```java
import java.util.Arrays;

// 9. Considere a classe `Point` que representa pontos do plano, descrita pela seguinte documentação.
// a) Programe esta classe de acordo com a documentação.
public class Point {
    private double x;
    private double y;

    /**
     * Builds and initializes a point at the specified (x, y) location in the coordinate space.
     * @param x X coordinate
     * @param y Y coordinate
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x (cartesian) coordinate of this point in double precision.
     * @return
     */
    public double x() {
        return this.x;
    }

    /**
     * Returns the y (cartesian) coordinate of this point in double precision.
     * @return
     */
    public double y() {
        return this.y;
    }

    /**
     * Determines whether or not this point and two others are colinear.
     * @param p1 A point to check if its colinear
     * @param p2 A point to check if its colinear
     * @return If the 3 points are colinear
     */
    public boolean colinear(Point p1, Point p2) {
        return true;
    }

    /**
     * Returns a copy of this point.
     * @return Copy of this point
     */
    public Point copy() {
        return new Point(this.x(), this.y());
    }

    /**
     * Returns the distance from this Point to a specific point.
     * @param p Point to calculate the distance.
     * @return The distance between the points.
     */
    public double distance(Point p) {
        return Math.sqrt(
                Math.pow(this.x() - p.x(), 2)
                        + Math.pow(this.y() - p.y(), 2));
    }

    /**
     * Moves this point by dx along the x axis and by dy along the y axis.
     * @param dx How much to move the point in the x axis
     * @param dy How much to move the point in the y axis
     */
    public void translate(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Determines whether or no this point is equal to another point.
     * @param p Point to compare
     * @return if the points are equal
     */
    public boolean equalsPoint(Point p) {
        return Math.abs(this.x() - p.x()) < 0.0001
                && Math.abs(this.y() - p.y()) < 0.0001;
    }

    /**
     * Returns a string representation of this point and its location in the (x, y) coordinate space
     * @return it's location (x, y) in the coordinate space
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}

// b) Escreva uma classe de nome `TestPoint` contendo um método `main` que (i) crie dois pontos, (ii) imprima a representação textual desses dois pontos, (iii) faça a translação do segundo ponto de 5 unidades na horizontal e 4 na vertical, (iv) imprima os dois pontos de novo e (v) imprima a distância entre os dois pontos.
public class TestPoint {
    public static void main(String[] args) {
        // (i) crie dois pontos
        Point a = new Point(5, 7);
        Point b = new Point(0, 7);

        // (ii) imprima a representação textual desses dois pontos
        System.out.printf("Ponto a: %s\nPonto b: %s\n", a, b);

        // (iii) faça a translação do segundo ponto de 5 unidades na horizontal e 4 na vertical
        b.translate(5, 4);

        // (iv) imprima os dois pontos de novo
        System.out.printf("Ponto a: %s\nPonto b: %s\n", a, b);

        // (v) imprima a distância entre os dois pontos
        double distancia = a.distance(b);
        System.out.printf("Distancia dos pontos: %f\n", distancia);
    }


}

// 10. Um polígono é uma região do plano fechada, delimitada por segmentos de reta. Defina uma classe `Polygon` cujos objetos representam polígonos e que ofereça as seguintes funcionalidades:
public class Polygon {
    private Point[] verts;

    // a) um construtor que crie um polígono a partir dum vetor de pontos com os seus vértices, assumindo que o vetor dado é válido (ver alínea f);
    public Polygon(Point[] v) {
        this.verts = new Point[v.length];
        for (int i=0; i<v.length; i++)
            this.verts[i] = v[i].copy();
    }

    // b) um método com a assinatura `double perimeter()` que retorne o perímetro deste polígono;
    public double perimeter() {
        // começar pela distância do primeiro com o último
        double sum = this.verts[0].distance(this.verts[this.verts.length-1]);
        
        for (int i=0; i<this.verts.length - 1; i++)
            sum += this.verts[i].distance(this.verts[i+1]);
        
        return sum;
    }

    // c) um método com a assinatura `Point closestOrigin()` que devolva o vértice deste polígono mais próximo da origem;
    public Point closestOrigin() {

    }

    // d) um método com a assinatura `void translate(double dX, double dY)` que efetue uma translação deste polígono segundo o vetor definido por (dX,dY);
    public void translate(double dx, double dy) {
        for (Point p : this.v)
            p.translate(dx, dy);
    }

    // e) um método com a assinatura `String toString()` que devolva uma representação textual deste polígono
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Point p : this.verts)
            sb.append(p.toString() + ",");

        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // f) um método de classe com a assinatura `static boolean valid(Point[] vertex)` que verifique se: 1) o vetor vertex tem mais do que 2 vértices; 2) o vetor vertex está todo preenchido; 3) o vetor vertex não tem 3 pontos consecutivos colineares. Note que estas são propriedades exigidas aos vértices de qualquer polígono, considerando que cada dois pontos consecutivos definem uma aresta, bem como o primeiro e o último (estas propriedades, não sendo suficientes, servem o propósito do exercício)
    public static boolean valid(Point[] v) {
//      todo a partir do 3
        boolean result = v != null && v.length > 2;
        int colinearCnt =  result && v[0].colinear(v[1], v[v.length-1]);

        for (int i = 0; result && i < v.length; i++) {
            if (v[i] == null)
                result = false;

            int idx = (i + j + 1) % v.length;
        }
    }
}
```