package junit;

import jhlir.RDataFrameRef;
import org.junit.BeforeClass;

public class RDataFrameRef_Test extends RDataFrame_Test {

    @BeforeClass
    protected void setUp() throws Exception {
        super.setUp();
        rDf1 = (RDataFrameRef) getRServices().evalAndGetRef("rdf1");
    }
}
