package rengine;

import jhlir.RListRef;
import org.rosuda.REngine.REXPGenericVector;
import org.rosuda.REngine.REXPReference;

public class RListRefREngine
        extends RListREngine
    implements RListRef<REXPReference, REXPGenericVector> {

    public RListRefREngine(REngineServicesREngine rs, REXPReference rListRef) {
        super(rs, rListRef);
    }

    public REXPGenericVector deref() {
        return (REXPGenericVector) ref.resolve();
    }
}
