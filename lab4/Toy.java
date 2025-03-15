package labs.lab4;
/**
 * Represents a toy
 */
public class Toy {
// ADD INSTANCE VARIABLES HERE
    /**
     * Constructor that constructs the Toy object
     *
     * @param name name of the toy
     * @param description description of the toy
     * @param destroyed whether or not this toy is destroyed
     */
    private String name ;
    private String description;
    private boolean destroyed;

    public Toy(String name, String description, boolean destroyed) {
// FILL IN
        this.name = name;
        this.description = description;
        this.destroyed = destroyed;
    }
    /**
     *
     * @return name of the toy
     */
    public String getName() {
        return this.name; // FIX ME
    }
    /**
     * Sets the name to the given name
     *
     * @param name new name
     */
    public void setName(String name) {
// FILL IN
        this.name = name;
    }
    /**
     *
     * @return description of the toy
     */
    public String getDescription() {
        return this.description; // FIX ME
    }
    /**
     * Sets the description to the given description
     *
     * @param description new description
     */
    public void setDescription(String description) {
// FILL IN
        this.description = description;

    }
    /**
     *
     * @return true if the toy is destroyed, false otherwise
     */
    public boolean isDestroyed() {
        return destroyed; // FIX ME
    }
    /**
     * Sets the destroyed property to the given value
     *
     * @param destroyed new destroyed property
     */
    public void setDestroyed(boolean destroyed) {
// FILL IN
        this.destroyed = destroyed;

    }
}
