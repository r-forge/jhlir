package junit;

import jhlir.REngineServices;
import jhlir.RInteger;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class RInteger_Test extends RVector_Test {
    private RInteger rInt1;
    private RInteger rInt2;


    @Before
    public void setUp() throws Exception {
        super.setUp();
        rInt1 = getRServices().eval("as.integer(c(1, 5, NA, 3, 10, NA))").asRInteger();
        rInt2 = getRServices().eval("1:3").asRInteger();
        registerVecs(rInt1, rInt2);
    }

    @Test
    public void testAt()  {
        int[] xs = rInt1.getData();
        assertEquals(rInt1.getLength(), 6);

        assertEquals(rInt1.get(0), 1);
        assertFalse(rInt1.isNA(0));

        assertEquals(rInt1.get(1), 5);
        assertFalse(rInt1.isNA(1));


        assertEquals(rInt1.get(2), REngineServices.NA_RINTEGER);
        assertTrue(rInt1.isNA(2));

        assertEquals(rInt1.get(3), 3);
        assertFalse(rInt1.isNA(3));

        assertEquals(rInt1.get(4), 10);
        assertFalse(rInt1.isNA(4));

        assertEquals(rInt1.get(5), REngineServices.NA_RINTEGER);
        assertTrue(rInt1.isNA(5));

    }

    @Test(expected=IndexOutOfBoundsException.class) public void outOfBounds() {
    	rInt1.get(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class) public void outOfBounds2() {
    	rInt1.get(6);
    }

    @Test
    public void testGetDataAsObjArr()  {
        Integer[] xs = rInt1.getDataAsObjArr();
        assertEquals(xs.length, 6);
        assertEquals((int)xs[0], 1);
        assertEquals((int)xs[1], 5);
        assertEquals((int)xs[2], (int)REngineServices.NA_RINTEGER);
        assertEquals((int)xs[3], 3);
        assertEquals((int)xs[4], 10);
        assertEquals((int)xs[5], (int)REngineServices.NA_RINTEGER);
    }


    @Test
    public void testAsList()  {
        List<Double> xs = rInt1.getDataAsList();
        assertEquals(xs.size(), 6);
        assertEquals(xs.get(0), (Double)1.0);
        assertEquals(xs.get(1), (Double)5.0);
        assertEquals(xs.get(2), REngineServices.NA_RINTEGER);
        assertEquals(xs.get(3), (Double)3.0);
        assertEquals(xs.get(4), (Double)10.0);
        assertEquals(xs.get(5), REngineServices.NA_RINTEGER);
    }

    
}
