package biocep;

import jhlir.RVectorFactor;
import org.kchine.r.RObject;

import java.util.Arrays;
import java.util.List;

abstract public class RVectorFactorBiocep<WRAPPED_TYPE extends RObject, ARR_TYPE, EL_TYPE>
        extends RObjectBiocep<WRAPPED_TYPE> implements RVectorFactor<WRAPPED_TYPE, ARR_TYPE, EL_TYPE>{

    protected RVectorFactorBiocep(REngineServicesBiocep rs, WRAPPED_TYPE wrapped) {
        super(rs, wrapped);
    }

    public List<EL_TYPE> getDataAsList() {
        return Arrays.asList(getDataAsObjArr());
    }


//    public RVectorFactorBiocep(RServices rs, RVector rVector) {
//        super(rs, rVector);
//    }

    // just set to a raw internal data to a value
    // does not handle if val is NA or to remove the NA index if el "i" NA before
//
//    protected abstract void _set(int i, JAVA_TYPE val);
//
//
//    // val could be NA_VAL too
//    public void set(int i, JAVA_TYPE val) {
//        if (ObjectUtils.equals(val, getNaVal()))
//            setNA(i);
//        else {
//            _set(i, val);
//            setNonNA(i);
//        }
//    }
}
