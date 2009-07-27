package rengine;

import org.apache.commons.lang.ArrayUtils;
import org.rosuda.REngine.REXPInteger;

public class RIntegerREngine
        extends RVectorREngine<REXPInteger, REXPInteger, int[], Integer>
        implements jhlir.RInteger<org.rosuda.REngine.REXPInteger>{

    public RIntegerREngine(REngineServicesREngine rs, org.rosuda.REngine.REXPInteger wrapped) {
        super(rs, wrapped);
    }

    public int[] getData() {
        return getResolved().asIntegers();
    }

    public Integer[] getDataAsObjArr() {
        return ArrayUtils.toObject(getData());
    }

    public Integer get(int i) {
        return getData()[i];
    }

    public boolean isNA(int i) {
        return REXPInteger.isNA(get(i));
    }

}
