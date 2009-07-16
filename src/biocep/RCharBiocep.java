package biocep;

import jhlir.RChar;

public class RCharBiocep
        extends RVectorBiocep<org.kchine.r.RChar, String[], String>
        implements RChar<org.kchine.r.RChar> {


    public RCharBiocep(REngineServicesBiocep rs, org.kchine.r.RChar wrapped) {
        super(rs, wrapped);
    }

    public String[] getData() {
        return getWrapped().getValue();
    }

    public String[] getDataAsObjArr() {
        return getWrapped().getValue();
    }

    public String get(int i) {
        return getWrapped().getValue()[i];
    }


    public boolean isNA(int i) {
        // todo this is wrong.
        return get(i) == null;
    }

    //    protected void _set(int i, String val) {
//        getObj().getValue()[i] = val;
//    }
//
//    public String stringVal() {
//        if (length() != 1)
//            throw new RuntimeException("Cannot convert RCharBiocep to String if length is " + length());
//        return at(0);
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
//    public static boolean isNA(String v) {
//        return ObjectUtils.equals(v, NA_VAL);
//    }
//
//    public String getNaVal() {
//        return NA_VAL;
//    }

}
