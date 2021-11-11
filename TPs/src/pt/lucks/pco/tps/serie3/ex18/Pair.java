package pt.lucks.pco.tps.serie3.ex18;

/**
 * Represents pairs of objects of any types
 * @author PCO
 */
public class Pair<F,S> {
    private F primeiro;
    private S segundo;

    /**
     * Gives initial values to the attributes of the new object
     * @param first The first element of the new pair
     * @param second The second element of the new pair
     * @ensures this.first().equals(first) and
     *          this.second().equals(second)
     */
    public Pair (F first, S second) {
        this.primeiro = first;
        this.segundo = second;
    }

    /**
     * The first element of this pair
     * @return The first element of this pair
     */
    public F first() {
        return this.primeiro;
    }

    /**
     * The second element of this pair
     * @return The second element of this pair
     */
    public S second() {
        return this.segundo;
    }

    /**
     * Textual representation of this pair
     */
    public String toString() {
        return "(" + this.primeiro + "," + this.segundo + ")";
    }

}
