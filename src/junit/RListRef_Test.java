package junit;

import jhlir.RListRef;

public class RListRef_Test extends RList_Test {


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        rList1 = (RListRef)getRServices().evalAndGetRef("rlist1");
    }

}
