package junit;

import jhlir.RFactor;
import org.junit.Test;

import java.util.List;

public class RFactor_Test extends MyTestCase {
    private RFactor rFact1;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        rFact1 = getRServices().eval("as.factor(c(\"b\", NA,\"b\", \"a\"))").asRFactor();
    }

    @Test
    public void testAt()  {
        assertEquals(rFact1.getLength(), 4);

        assertEquals(rFact1.get(0), "b");
        assertFalse(rFact1.isNA(0));

        assertEquals(rFact1.get(1), RFactor.NA_VAL);
        assertTrue(rFact1.isNA(1));

        assertEquals(rFact1.get(2), "b");
        assertFalse(rFact1.isNA(2));

        assertEquals(rFact1.get(3), "a");
        assertFalse(rFact1.isNA(3));
    }

    @Test(expected=IndexOutOfBoundsException.class) public void outOfBounds() {
    	rFact1.get(-1);
    }

    @Test(expected=IndexOutOfBoundsException.class) public void outOfBounds2() {
    	rFact1.get(4);
    }

    @Test
    public void testGetDataAsObjArr()  {
        String[] xs = rFact1.getDataAsObjArr();
        assertEquals(xs.length, 4);
        assertEquals(xs[0], "b");
        assertEquals(xs[1], RFactor.NA_VAL);
        assertEquals(xs[2], "b");
        assertEquals(xs[3], "a");
    }


    @Test
    public void testAsList()  {
        List<String> xs = rFact1.getDataAsList();
        assertEquals(xs.size(), 4);
        assertEquals(xs.get(0), "b");
        assertEquals(xs.get(1), RFactor.NA_VAL);
        assertEquals(xs.get(2), "b");
        assertEquals(xs.get(3), "a");
    }
 
}