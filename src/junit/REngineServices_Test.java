package junit;

import static org.junit.Assert.*;
import jhlir.REngineException;
import jhlir.RErrorException;

import org.junit.Before;
import org.junit.Test;

public class REngineServices_Test extends MyTestCase {

    @Before
    public void setUp() throws Exception {
        super.setUp();
    }
    
    @Test
    public void testWarnings() {
    	getRServices().evalVoid("warning(\"Warning!\")");
    	String warning = ""; // getRServices().getWarning();
    	assertEquals("Warning", warning);
    }
    
    @Test
    public void testErrors() {
    	try {
    		getRServices().evalVoid("stop(\"error\")");
    	} catch(REngineException re) {
    		String error = ""; // re.getErrorMessage();
        	assertEquals("error", error);	
    	}    	
    }

    @Test(expected=RErrorException.class)
    public void testMissingBracket1() {        
        getRServices().evalVoid("rnorm(100");
        /* missing bracket ) */
    }

    @Test(expected=RErrorException.class)
    public void testMissingBracket2() {        
        getRServices().evalVoid("{rnorm(100)");
        /* missing bracket } */
    }
    
    @Test(expected=RErrorException.class)
    public void testUnexpected() {        
        getRServices().evalVoid("()");
        /* Fehler: Unerwartetes ')' in "()" */
    }    

    @Test(expected=RErrorException.class)
    public void testUnknownObject() {        
        getRServices().evalVoid("unknown()");
        /* Fehler: konnte Funktion "unknown" nicht finden */
    }
    
    @Test(expected=RErrorException.class)
    public void testunusedArguments() {        
        getRServices().evalVoid("rnorm(x=100)");
        /* Fehler in rnorm(x = 100) : unbenutzte(s) Argument(e) (x = 100) */
    }
    
    @Test(expected=RErrorException.class)
    public void testStop() {        
        getRServices().evalVoid("stop(\"error\")");        
    }
    
}
