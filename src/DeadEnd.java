/**
 * A DeadEnd is a HamsterBurrow which stores HamsterFood and does not branch
 * into any further HamsterBurrows.
 *
 * @author Carsten Fuhs
 * @author Marton Vago
 */
public class DeadEnd extends FoodBurrow {

    /**
     * Constructs a new DeadEnd which stores HamsterFood.
     * 
     * @param food the HamsterFood to store in this DeadEnd; must not be null
     */
    public DeadEnd(HamsterFood food) {
        super(food);
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        return ".(" + super.toString() + ")";
    }
}
