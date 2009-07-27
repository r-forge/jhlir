package biocep;

import jhlir.RListRef;


public class RListRefBiocep
        extends RListBiocep
        implements RListRef<org.kchine.r.RListRef, org.kchine.r.RList> {

    protected RListRefBiocep(REngineServicesBiocep rs, org.kchine.r.RListRef wrapped) {
        super(rs, wrapped);
    }
}
