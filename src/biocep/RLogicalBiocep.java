package biocep;

import jhlir.RLogical;
import org.apache.commons.lang.ArrayUtils;

public class RLogicalBiocep
        extends RVectorBiocep<org.kchine.r.RLogical, boolean[], Boolean>
        implements jhlir.RLogical<org.kchine.r.RLogical> {

    // NB: biocep does return boolean:false for NAs

    public RLogicalBiocep(REngineServicesBiocep rs, org.kchine.r.RLogical wrapped) {
        super(rs, wrapped);
    }

    public boolean[] getData() {
        return getWrapped().getValue();
    }

    public Boolean[] getDataAsObjArr() {
        Boolean[] bs = ArrayUtils.toObject(getData());
        int[] naInds = getWrapped().getIndexNA();
        for (int i=0; i<naInds.length; i++)
            bs[naInds[i]] = RLogical.NA_VAL;
        return bs;
    }

    public Boolean get(int i) {
        return isNA(i) ?  RLogical.NA_VAL : getWrapped().getValue()[i];
    }


    public boolean isNA(int i) {
        return ArrayUtils.contains(getWrapped().getIndexNA(), i);
    }


//    protected void _set(int i, Boolean val) {
//        getObj().getValue()[i] = val;
//    }
//
//    protected int[] _getIndexNA() {
//        return getObj().getIndexNA();
//    }
//
//    public static boolean isNA(Boolean v) {
//        return ObjectUtils.equals(v, NA_VAL);
//    }
//
//    public Boolean getNaVal() {
//        return NA_VAL;
//    }
//
//    public void setIndexNA(int[] ind) {
//        getObj().setIndexNA(ind);
//    }
}
