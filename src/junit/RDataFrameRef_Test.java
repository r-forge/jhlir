package junit;

import jhlir.RDataFrameRef;

public class RDataFrameRef_Test extends RDataFrame_Test {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        rDf1 = (RDataFrameRef) getRServices().evalAndGetRef("rdf1");
    }
}
