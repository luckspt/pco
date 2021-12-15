package pt.lucks.pco.tps.serie6.ex2;

public class Color {
    private final static int CTE = 2;

    // @invariant 0 <= r, g, b <= 255
    private int red;
    private int green;
    private int blue;

    // @requires 0 <= r, g, b <= 255
    public Color(int r, int g,int b) {
        red = r;
        green = g;
        blue = b;
    }

    public void darken() {
        red = Math.max(red - CTE, 0);
        blue = Math.max(blue - CTE, 0);
        green = Math.max(green - CTE, 0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Color)) return false;

        Color color = (Color) o;

        return this.red == color.red
            && this.green == color.green
            && this.blue == color.blue;
    }

    @Override
    public int hashCode() {
        int result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }
}