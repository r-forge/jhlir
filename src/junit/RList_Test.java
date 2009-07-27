package junit;

import jhlir.RChar;
import jhlir.RInteger;
import jhlir.RList;
import jhlir.RMatrix;
import org.junit.Test;

public class RList_Test extends MyTestCase {
    protected RList rList1;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getRServices().assign("rlist1", "list(xx=1:3, yy=list(), matrix(c(1,2,3,4),4,1), zz=\"foo\")");
        rList1 = getRServices().eval("rlist1").asRList();
    }

    @Test
    public void testAt()  {
        assertEquals(rList1.getLength(), 4);

        assertEquals(rList1.getName(0), "xx");
        assertEquals(rList1.getName(1), "yy");
        assertEquals(rList1.getName(3), "zz");

        assertEquals(rList1.getNames()[0], "xx");
        assertEquals(rList1.getNames()[1], "yy");
        assertEquals(rList1.getNames()[3], "zz");

        assertEquals(rList1.getNames()[0], "xx");
        assertEquals(rList1.getNames()[1], "yy");
        assertEquals(rList1.getNames()[3], "zz");

        assertTrue(rList1.get(0) instanceof RInteger);
        assertTrue(rList1.get(1) instanceof RList);
        assertTrue(rList1.get(2) instanceof RMatrix);
        assertTrue(rList1.get(3) instanceof RChar);



    }

}
