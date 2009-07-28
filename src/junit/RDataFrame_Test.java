package junit;

import jhlir.RDataFrame;
import jhlir.RInteger;
import jhlir.RNumeric;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RDataFrame_Test extends MyTestCase{
    protected RDataFrame rDf1;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        getRServices().assign("rdf1", "data.frame(xx=1:3, c(1.5, 5, -4), zz=c(\"foo\", \"bar\", \"bla\"), yy=4:6)");
        rDf1 = getRServices().eval("rdf1").asRDataFrame();
    }

    @Test
    public void testAt()  {
        assertEquals(rDf1.getRowNr(), 3);
        assertEquals(rDf1.getColNr(), 4);

        Object[] cns = rDf1.getColNames();

        assertEquals(cns[0], "xx");
//        assertEquals(cns[1], "xx");
        assertEquals(cns[2], "zz");
        assertEquals(cns[3], "yy");

        cns = rDf1.getColNamesAsList().toArray();

        assertEquals(cns[0], "xx");
//        assertEquals(cns[1], "xx");
        assertEquals(cns[2], "zz");
        assertEquals(cns[3], "yy");

        assertEquals(rDf1.get(0,0), 1);
        assertEquals(rDf1.get(1,0), 2);
        assertEquals(rDf1.get(2,0), 3);
        assertEquals(rDf1.get(0,1), 1.5);
        assertEquals(rDf1.get(1,1), 5.0);
        assertEquals(rDf1.get(2,1), -4.0);
        assertEquals(rDf1.get(0,2), "foo");
        assertEquals(rDf1.get(1,2), "bar");
        assertEquals(rDf1.get(2,2), "bla");
        assertEquals(rDf1.get(0,3), 4);
        assertEquals(rDf1.get(1,3), 5);
        assertEquals(rDf1.get(2,3), 6);

        RInteger ri = rDf1.getCol(0).asRInteger();
        assertEquals(ri.get(0), 1);
        assertEquals(ri.get(1), 2);
        assertEquals(ri.get(2), 3);
        RNumeric rn = rDf1.getCol(1).asRNumeric();
        assertEquals(rn.get(0), 1.5);
        assertEquals(rn.get(1), 5.0);
        assertEquals(rn.get(2), -4.0);
    }

}
