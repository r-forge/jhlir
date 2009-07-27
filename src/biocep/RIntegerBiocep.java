package biocep;

import jhlir.RInteger;
import org.apache.commons.lang.ArrayUtils;

public class RIntegerBiocep
        extends RVectorBiocep<org.kchine.r.RInteger, org.kchine.r.RInteger, int[], Integer>
        implements jhlir.RInteger<org.kchine.r.RInteger> {

    public RIntegerBiocep(REngineServicesBiocep rs, org.kchine.r.RInteger wrapped) {
        super(rs, wrapped);
    }

    public int[] getData() {
        return getResolved().getValue();
    }

    public Integer[] getDataAsObjArr() {
        return ArrayUtils.toObject(getData());
    }

    public Integer get(int i) {
        return getResolved().getValue()[i];
    }

    public boolean isNA(int i) {
        return get(i).equals(RInteger.NA_VAL);
    }


//    public void _set(int i, Integer val) {
//        getObj().getValue()[i] = val;
//    }
//
//    protected int[] _getIndexNA() {
//        return getObj().getIndexNA();
//    }
//
//    public void setIndexNA(int[] ind) {
//        getObj().setIndexNA(ind);
//    }
//
//    public static boolean isNA(Integer v) {
//        return ObjectUtils.equals(v, NA_VAL);
//    }
//
//    public Integer getNaVal() {
//        return NA_VAL;
//    }
}

