package junit;

import static org.junit.Assert.*;
import jhlir.REngineException;

import org.junit.Before;
import org.junit.Test;

public class REngineServices_Test extends MyTestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test(expected=REngineException.class)
    public void testNullPointerException1() {        
        getRServices().evalVoid("rnorm(100");        
    }
}
