package rengine;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPReference;

public class RObjectRefREngine<WRAPPED_REF extends REXPReference, WRAPPED_TYPE extends REXP>
        extends RObjectREngine<WRAPPED_REF, RESOLVED_TYPE>
        implements RRefREngine<WRAPPED_REF, WRAPPED_TYPE> {

    private WRAPPED_TYPE cached = null;

    public RObjectRefREngine(REngineServicesREngine rs, WRAPPED_REF wrapped) {
        super(rs, wrapped);
    }

    public WRAPPED_TYPE deref() {
        if (cached == null)
            cached = (WRAPPED_TYPE) getWrapped().resolve();
        return cached;
    }
}
