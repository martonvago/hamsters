/**
 * A Junction is a HamsterBurrow that stores food and that branches into
 * two further HamsterBurrows.
 *
 * @author 
 */
public class Junction extends FoodBurrow {

    /** The left HamsterBurrow. Non-null. */
    private HamsterBurrow leftBurrow;

    /** The right HamsterBurrow. Non-null. */
    private HamsterBurrow rightBurrow;

    /**
     * Constructs a new Junction which stores HamsterFood and branches
     * into two further burrows.
     * 
     * @param food the HamsterFood to store in this DeadEnd; must not be null
     * @param leftBurrow the left burrow into which this Junction branches;
     *  must not be null
     * @param rightBurrow the right burrow into which this Junction branches;
     *  must not be null
     */
    public Junction(HamsterFood food, HamsterBurrow leftBurrow, HamsterBurrow rightBurrow) {
        super(food);
        if (leftBurrow == null) {
            throw new IllegalArgumentException("Illegal null argument: leftBurrow");
        }
        if (rightBurrow == null) {
            throw new IllegalArgumentException("Illegal null argument: rightBurrow");
        }
        this.leftBurrow = leftBurrow;
        this.rightBurrow = rightBurrow;
    }



    @Override
    public String toString() {
        return "Y(" + super.toString() + ", "
                + this.leftBurrow + ", "
                + this.rightBurrow + ")";
    }
}
