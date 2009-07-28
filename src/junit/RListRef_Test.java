package junit;

import jhlir.RListRef;
import org.junit.Before;

public class RListRef_Test extends RList_Test {


    @Before
    protected void setUp() throws Exception {
        super.setUp();
        rList1 = (RListRef)getRServices().evalAndGetRef("rlist1");
    }

}
