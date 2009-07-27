package rengine;

import org.apache.commons.lang.ArrayUtils;
import org.rosuda.REngine.REXPDouble;


public class RNumericREngine
        extends RVectorREngine<REXPDouble, REXPDouble, double[], Double>
        implements jhlir.RNumeric<org.rosuda.REngine.REXPDouble>{

    public RNumericREngine(REngineServicesREngine rs, org.rosuda.REngine.REXPDouble wrapped) {
        super(rs, wrapped);
    }

    public double[] getData() {
        return getWrapped().asDoubles();
    }

    public Double[] getDataAsObjArr() {
        return ArrayUtils.toObject(getData());
    }

    public Double get(int i) {
        return getData()[i];
    }

    public boolean isNA(int i) {
        return Double.isNaN(get(i));
    }

}
