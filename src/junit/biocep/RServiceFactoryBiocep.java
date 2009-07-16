package junit.biocep;

import biocep.REngineServicesBiocep;
import jhlir.REngineServices;
import org.kchine.r.server.DirectJNI;


public abstract class RServiceFactoryBiocep{
    private static REngineServices rServices;

    public static REngineServices getRServices() {
        if (rServices == null)
            rServices = new REngineServicesBiocep(DirectJNI.getInstance().getRServices());
        return rServices;
    }
}

