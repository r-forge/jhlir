package junit;

import jhlir.RListRef;
import org.junit.Before;

public class RListRef_Test extends RList_Test {


    @Before
    public void setUp() throws Exception {
        super.setUp();
        rList1 = (RListRef)getRServices().evalAndGetRef("rlist1");
    }

}
