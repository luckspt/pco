package pt.lucks.pco.tps.serie3.ex18;

/**
 * Class whose objects represent drivers
 * @author PCO
 */
public class Driver {
    private String name;
    private Team team;

    /**
     * Gives initial values to the attributes of the new object
     * @param name The name of the driver
     * @param team The team to which the driver belongs
     * @requires team != null and name != null
     */
    public Driver(String name, Team team) {
        this.name = name;
        this.team = team;
    }

    /**
     * The name of this driver
     * @return The name of this driver
     */
    public String name() {
        return this.name;
    }

    /**
     * The team to which this driver belongs
     * @return The team to which this driver belongs
     */
    public Team team() {
        return this.team;
    }

    /**
     * The textual representation of this driver
     * @return The textual representation of this driver
     */
    public String toString() {
        return "Name: " + this.name + "   Team: " + this.team;
    }
}
