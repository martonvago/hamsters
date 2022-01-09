import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit 5 test cases for the HamsterBurrow hierarchy.
 * 
 * @author Marton Vago
 */
public class HamsterBurrowTest {

    @Test
    public void sizeReturnsCorrectHamsterBurrowSize() {
        // given
        HamsterBurrow hb = Coursework3Main.mkBurrow();

        // when
        int size = hb.size();

        // then
        assertEquals(9, size);
    }

    @Test
    public void sizeReturnsCorrectHamsterBurrowSizeWhenBurrowSingleDeadEnd() {
        // given
        HamsterBurrow hb = this.createDeadEndBurrow();

        // when
        int size = hb.size();

        // then
        assertEquals(1, size);
    }

    @Test
    public void totalFoodUnitsReturnsCorrectTotalFoodUnits() {
        // given
        HamsterBurrow hb = Coursework3Main.mkBurrow();

        // when
        int totalFoodUnits = hb.totalFoodUnits();

        // then
        assertEquals(280, totalFoodUnits);
    }

    @Test
    public void totalFoodUnitsReturnsCorrectTotalFoodUnitsWhenBurrowSingleDeadEnd() {
        // given
        HamsterBurrow hb = this.createDeadEndBurrow();

        // when
        int totalFoodUnits = hb.totalFoodUnits();

        // then
        assertEquals(30, totalFoodUnits);
    }

    @Test
    public void eatReturnsCorrectNumberOfFoodUnitsEatenByHamster() {
        // given
        HamsterBurrow hb = Coursework3Main.mkBurrow();
        Hamster h = new Hamster("Nibbler", 50);

        // when
        int eaten = hb.feedHungryHamster(h);

        // then
        assertEquals(60, eaten);
    }

    @Test
    public void eatReturnsCorrectNumberOfFoodUnitsEatenByHamsterWhenBurrowSingleDeadEnd() {
        // given
        HamsterBurrow hb = this.createDeadEndBurrow();
        Hamster h = new Hamster("Nibbler", 50);

        // when
        int eaten = hb.feedHungryHamster(h);

        // then
        assertEquals(30, eaten);
    }

    @Test
    public void hamsterAppetiteCorrectAfterVisitToBurrow() {
        // given
        HamsterBurrow hb = Coursework3Main.mkBurrow();
        Hamster h = new Hamster("Nibbler", 50);

        // when
        hb.feedHungryHamster(h);
        int appetite = h.getAppetite();

        // then
        assertEquals(-10, appetite);
    }

    @Test
    public void hamsterAppetiteCorrectAfterVisitToBurrowWhenBurrowSingleDeadEnd() {
        // given
        HamsterBurrow hb = this.createDeadEndBurrow();
        Hamster h = new Hamster("Nibbler", 50);

        // when
        hb.feedHungryHamster(h);
        int appetite = h.getAppetite();

        // then
        assertEquals(20, appetite);
    }

    @Test
    public void totalFoodUnitsReturnsCorrectTotalFoodUnitsAfterHamsterVisit() {
        // given
        HamsterBurrow hb = Coursework3Main.mkBurrow();
        Hamster h = new Hamster("Nibbler", 50);

        // when
        hb.feedHungryHamster(h);
        int totalFoodUnits = hb.totalFoodUnits();

        // then
        assertEquals(220, totalFoodUnits);
    }

    @Test
    public void totalFoodUnitsReturnsCorrectTotalFoodUnitsAfterHamsterVisitWhenBurrowSingleDeadEnd() {
        // given
        HamsterBurrow hb = this.createDeadEndBurrow();
        Hamster h = new Hamster("Nibbler", 50);

        // when
        hb.feedHungryHamster(h);
        int totalFoodUnits = hb.totalFoodUnits();

        // then
        assertEquals(0, totalFoodUnits);
    }

    @Test
    public void feedHungryHamsterThrowsIllegalArgumentExceptionWhenHamsterNull() {
        // given
        HamsterBurrow hb = Coursework3Main.mkBurrow();

        // when + then
        assertThrows(IllegalArgumentException.class, () -> hb.feedHungryHamster(null));
    }

    @Test
    public void feedHungryHamsterThrowsIllegalArgumentExceptionWhenHamsterNullAndBurrowSingleDeadEnd() {
        // given
        HamsterBurrow hb = this.createDeadEndBurrow();

        // when + then
        assertThrows(IllegalArgumentException.class, () -> hb.feedHungryHamster(null));
    }

    @Test
    public void feedHungryHamsterThrowsIllegalArgumentExceptionWhenHamsterNotHungry() {
        // given
        HamsterBurrow hb = Coursework3Main.mkBurrow();
        Hamster h = new Hamster("Happy", 0);

        // when + then
        assertThrows(IllegalArgumentException.class, () -> hb.feedHungryHamster(h));
    }

    @Test
    public void feedHungryHamsterThrowsIllegalArgumentExceptionWhenHamsterNotHungryAndBurrowSingleDeadEnd() {
        // given
        HamsterBurrow hb = this.createDeadEndBurrow();
        Hamster h = new Hamster("Happy", 0);

        // when + then
        assertThrows(IllegalArgumentException.class, () -> hb.feedHungryHamster(h));
    }

    /**
     * Builds a HamsterBurrow consisting of a single DeadEnd.
     *
     * @return a HamsterBurrow consisting of a single DeadEnd
     */
    private HamsterBurrow createDeadEndBurrow() {
        return new DeadEnd(new HamsterFood(30));
    }
}
