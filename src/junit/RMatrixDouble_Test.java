package junit;

import jhlir.REngineServices;
import jhlir.RMatrixDouble;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class RMatrixDouble_Test extends MyTestCase{
    private RMatrixDouble rMat1;

     @Before
     protected void setUp() throws Exception {
        super.setUp();
        rMat1 = getRServices().eval("matrix(c(1.1,2,3,NA,5.1,66), 2, 3)").asRMatrixDouble();
     }

     @Test
     public void testAt()  {
         assertEquals(rMat1.getRowNr(), 2);
         assertEquals(rMat1.getColNr(), 3);

         assertEquals(rMat1.get(0,0), 1.1);
         assertEquals(rMat1.get(1,0), 2.0);
         assertEquals(rMat1.get(0,1), 3.0);
         assertEquals(rMat1.get(1,1), REngineServices.NA_RNUMERIC);
         assertEquals(rMat1.get(0,2), 5.1);
         assertEquals(rMat1.get(1,2), 66.0);

         assertFalse(rMat1.isNA(0,0));
         assertFalse(rMat1.isNA(1,0));
         assertFalse(rMat1.isNA(0,1));
         assertTrue (rMat1.isNA(1,1)); 
         assertFalse(rMat1.isNA(0,2));
         assertFalse(rMat1.isNA(1,2));

         assertEquals(rMat1.getData()[0][0], 1.1);
         assertEquals(rMat1.getData()[1][0], 2.0);
         assertEquals(rMat1.getData()[0][1], 3.0);
         assertEquals((Double)rMat1.getData()[1][1], (Double)REngineServices.NA_RNUMERIC);
         assertEquals(rMat1.getData()[0][2], 5.1);
         assertEquals(rMat1.getData()[1][2], 66.0);

         assertEquals(rMat1.getDataAsObjArr()[0][0], 1.1);
         assertEquals(rMat1.getDataAsObjArr()[1][0], 2.0);
         assertEquals(rMat1.getDataAsObjArr()[0][1], 3.0);
         assertEquals(rMat1.getDataAsObjArr()[1][1], REngineServices.NA_RNUMERIC);
         assertEquals(rMat1.getDataAsObjArr()[0][2], 5.1);
         assertEquals(rMat1.getDataAsObjArr()[1][2], 66.0);
     }

}
