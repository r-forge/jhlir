package junit;

import jhlir.RDataFrameRef;
import org.junit.Before;

public class RDataFrameRef_Test extends RDataFrame_Test {

    @Before
    protected void setUp() throws Exception {
        super.setUp();
        rDf1 = (RDataFrameRef) getRServices().evalAndGetRef("rdf1");
    }
}
