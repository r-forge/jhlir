package test;


import org.af.jhlir.backends.biocep.REngineServicesBiocep;
import org.af.jhlir.call.RCallServices;
import org.kchine.r.server.DirectJNI;

public class TestREngineServices {
    public static void main(String[] args) {
    	RCallServices rs = new REngineServicesBiocep(DirectJNI.getInstance().getRServices());
    	rs.eval("warning(\"Warning!\")");
    	String[] warnings = rs.getWarning();
    	for (String s : warnings) {
    		System.out.println(s);
    	}
    	
    }
}
