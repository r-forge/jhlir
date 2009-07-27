package rengine;

import jhlir.RDataFrameRef;
import org.rosuda.REngine.REXPGenericVector;
import org.rosuda.REngine.REXPReference;

public class RDataFrameRefREngine
        extends RDataFrameREngine
        implements RDataFrameRef<REXPReference, REXPGenericVector> {

    public RDataFrameRefREngine(REngineServicesREngine rs, REXPReference wrapped) {
        super(rs, wrapped);
    }
}