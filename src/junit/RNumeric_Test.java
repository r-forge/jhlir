package junit;

import jhlir.RNumeric;
import org.junit.Test;

import java.util.List;

public abstract class RNumeric_Test extends MyTestCase {
    private RNumeric rNumW1;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        rNumW1 = getRServices().eval("c(1.1, 5, NA, 3, 10.1, NA)").asRNumeric();
    }

    @Test
    public void testAt()  {
        double[] xs = rNumW1.getData();
        assertEquals(rNumW1.getLength(), 6);

        assertEquals(rNumW1.get(0), 1.1);
        assertFalse(rNumW1.isNA(0));

        assertEquals(rNumW1.get(1), 5.0);
        assertFalse(rNumW1.isNA(1));

        assertEquals(rNumW1.get(2), RNumeric.NA_VAL);
        assertTrue(rNumW1.isNA(2));

        assertEquals(rNumW1.get(3), 3.0);
        assertFalse(rNumW1.isNA(3));

        assertEquals(rNumW1.get(4), 10.1);
        assertFalse(rNumW1.isNA(4));

        assertEquals(rNumW1.get(5), RNumeric.NA_VAL);
        assertTrue(rNumW1.isNA(5));

    }

    @Test(expected=IndexOutOfBoundsException.class) public void outOfBounds() {
    	rNumW1.get(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class) public void outOfBounds2() {
    	rNumW1.get(6);
    }

    @Test
    public void testGetDataAsObjArr()  {
        Double[] xs = rNumW1.getDataAsObjArr();
        assertEquals(xs.length, 6);
        assertEquals(xs[0], 1.1);
        assertEquals(xs[1], 5.0);
        assertEquals(xs[2], RNumeric.NA_VAL);
        assertEquals(xs[3], 3.0);
        assertEquals(xs[4], 10.1);
        assertEquals(xs[5], RNumeric.NA_VAL);
    }


    @Test
    public void testAsList()  {
        List<Double> xs = rNumW1.getDataAsList();
        assertEquals(xs.size(), 6);
        assertEquals(xs.get(0), 1.1);
        assertEquals(xs.get(1), 5.0);
        assertEquals(xs.get(2), RNumeric.NA_VAL);
        assertEquals(xs.get(3), 3.0);
        assertEquals(xs.get(4), 10.1);
        assertEquals(xs.get(5), RNumeric.NA_VAL);
    }

}