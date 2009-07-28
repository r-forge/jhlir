package junit;

import jhlir.RChar;
import jhlir.REngineServices;
import jhlir.RInteger;
import jhlir.RList;
import jhlir.RMatrix;
import org.junit.Test;

public class RList_Test extends MyTestCase {
    protected RList rList1;
    protected RList rList2;
    protected RList rList3;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getRServices().assign("rlist1", "list(xx=1:3, yy=list(), matrix(c(1,2,3,4),4,1), zz=\"foo\")");
        rList1 = getRServices().eval("rlist1").asRList();
        getRServices().assign("rlist2", "list(1:3, list(1,2,3), matrix(c(1,2,3,4),4,1), \"foo\")");
        rList2 = getRServices().eval("rlist2").asRList();
        getRServices().assign("rlist3", "list()");
        rList3 = getRServices().eval("rlist3").asRList();
        
    }

    @Test
    public void testAt()  {
        assertEquals(rList1.getLength(), 4);
        assertEquals(rList2.getLength(), 4);
        assertEquals(rList3.getLength(), 0);

        assertEquals(rList1.getName(0), "xx");
        assertEquals(rList1.getName(1), "yy");
        assertEquals(rList1.getName(2), "");
        assertEquals(rList1.getName(3), "zz");

        assertEquals(rList2.getName(0), REngineServices.NA_CHAR);
        assertEquals(rList2.getName(1), REngineServices.NA_CHAR);
        assertEquals(rList2.getName(2), REngineServices.NA_CHAR);
        assertEquals(rList2.getName(3), REngineServices.NA_CHAR);        
        
        assertEquals(rList1.getNames()[0], "xx");
        assertEquals(rList1.getNames()[1], "yy");
        assertEquals(rList1.getNames()[3], "zz");
        
        assertEquals(rList2.getNames(), REngineServices.NA_CHAR);
        assertEquals(rList3.getNames(), REngineServices.NA_CHAR);
        
        assertTrue(rList1.get("xx") instanceof RInteger);
        assertTrue(rList1.get("yy") instanceof RList);        
        assertTrue(rList1.get("zz") instanceof RChar);
        
        assertTrue(rList1.get(0) instanceof RInteger);
        assertTrue(rList1.get(1) instanceof RList);
        assertTrue(rList1.get(2) instanceof RMatrix);
        assertTrue(rList1.get(3) instanceof RChar);
        
        assertEquals(rList1.getNamesAsList().size(), 4);
        assertEquals(rList1.getNamesAsList().get(0), "xx");
    }    

    @Test(expected=IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException1() {
    	rList3.get(1);
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsException2() {
    	rList1.get("blah");
    }


}
