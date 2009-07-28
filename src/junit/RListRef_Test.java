package junit;

import jhlir.RListRef;
import org.junit.BeforeClass;

public class RListRef_Test extends RList_Test {


    @BeforeClass
    protected void setUp() throws Exception {
        super.setUp();
        rList1 = (RListRef)getRServices().evalAndGetRef("rlist1");
    }

}
