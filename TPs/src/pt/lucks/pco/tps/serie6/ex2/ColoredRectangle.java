package pt.lucks.pco.tps.serie6.ex2;

public class ColoredRectangle extends Rectangle {
    // @invariant 0 <= red, green, blue <= 255
    private Color color;

    // @requires h, w > 0
    // @requires 0 <= red, green, blue <= 255
    public ColoredRectangle (int h, int w, int red, int green, int blue) {
        super(h,w);
        color = new Color(red, green, blue);
    }

    public void darken() {
        color.darken();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle)) return false;

        ColoredRectangle coloredRectangle = (ColoredRectangle) o;

        return super.equals(coloredRectangle)
                && this.color.equals(coloredRectangle.color);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}