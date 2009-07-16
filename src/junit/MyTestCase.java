package junit;

import biocep.REngineServicesBiocep;
import jhlir.REngineServices;
import junit.framework.TestCase;
import org.kchine.r.server.DirectJNI;
import org.rosuda.REngine.JRI.JRIEngine;
import rengine.REngineServicesREngine;

public abstract class MyTestCase extends TestCase {
    private static REngineServices rs;

    @Override
    protected void setUp() throws Exception {
        if (rs == null) {
            if (this.getClass().toString().startsWith("class junit.biocep")) {
                rs = new REngineServicesBiocep(DirectJNI.getInstance().getRServices());
            }
            if (this.getClass().toString().startsWith("class junit.JRI")) {
                rs = new REngineServicesREngine(new JRIEngine());
            }
        }
    }

    public REngineServices getRServices() {
        return rs;
    }


//    protected void tearDown() {
//        try {
//            if (this.getClass().toString().startsWith("class junit.biocep")) {
//                ((REngineServicesBiocep) rs).getRServices().stop();
//            }
//            if (this.getClass().toString().startsWith("class junit.JRI")) {
//                boolean b = ((JRIEngine)((REngineServicesREngine) rs).getREngine()).close() ;
//                System.out.println(b);
//            }
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }

}
