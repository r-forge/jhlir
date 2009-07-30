package junit.biocep;

import org.af.jhlir.backends.biocep.REngineServicesBiocep;
import org.af.jhlir.call.RCallServices;
import org.kchine.r.server.DirectJNI;


public abstract class RServiceFactoryBiocep{
    private static RCallServices rServices;

    public static RCallServices getRServices() {
        if (rServices == null)
            rServices = new REngineServicesBiocep(DirectJNI.getInstance().getRServices());
        return rServices;
    }
}

