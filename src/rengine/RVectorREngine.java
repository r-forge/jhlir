package rengine;


abstract public class RVectorREngine<WRAPPED_TYPE extends org.rosuda.REngine.REXPVector, ARR_TYPE, EL_TYPE> 
        extends RVectorFactorREngine<WRAPPED_TYPE, ARR_TYPE, EL_TYPE> {

    protected RVectorREngine(REngineServicesREngine rs, WRAPPED_TYPE wrapped) {
        super(rs, wrapped);
    }

    public int getLength() {
        return getWrapped().length();
    }
}
