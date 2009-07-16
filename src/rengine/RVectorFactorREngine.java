package rengine;

import jhlir.RVectorFactor;

import java.util.Arrays;
import java.util.List;

abstract public class RVectorFactorREngine<WRAPPED_TYPE extends org.rosuda.REngine.REXP, ARR_TYPE, EL_TYPE>
        extends RObjectREngine<WRAPPED_TYPE> implements RVectorFactor<WRAPPED_TYPE, ARR_TYPE, EL_TYPE> {

    protected RVectorFactorREngine(REngineServicesREngine rs, WRAPPED_TYPE wrapped) {
        super(rs, wrapped);
    }

    public List<EL_TYPE> getDataAsList() {
        return Arrays.asList(getDataAsObjArr());
    }


}
