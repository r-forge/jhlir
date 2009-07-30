package junit.biocep;

import biocep.REngineServicesBiocep;
import jhlir.RCallServices;
import org.kchine.r.server.DirectJNI;


public abstract class RServiceFactoryBiocep{
    private static RCallServices rServices;

    public static RCallServices getRServices() {
        if (rServices == null)
            rServices = new REngineServicesBiocep(DirectJNI.getInstance().getRServices());
        return rServices;
    }
}

