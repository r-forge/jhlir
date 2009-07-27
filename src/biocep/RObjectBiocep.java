package biocep;

import jhlir.REnvironment;
import jhlir.RObj;

public class RObjectBiocep<WRAPPED_TYPE extends org.kchine.r.RObject> implements RObj<WRAPPED_TYPE> {
    protected REngineServicesBiocep rs;
    private WRAPPED_TYPE wrapped;
//    private ROBJ_TYPE extracted;
//    private String rClass = null;
//    public static enum RType {NUMERIC, INTEGER, FACTOR, CHAR, LOGICAL}

    // TODO find a way that this is never called
    protected RObjectBiocep(REngineServicesBiocep rs, WRAPPED_TYPE wrapped) {
        if (wrapped == null)
            throw new RuntimeException("Tried to create RObhjectWrapper on null!");
        this.rs = rs;
        this.wrapped = wrapped;
//        if (obj instanceof ReferenceInterface)
//            extracted = (ROBJ_TYPE)((ReferenceInterface)obj).extractRObject();
    }

//    public static RObjectBiocep makeW(RServices rs, RObject obj, String rClass) {
//        if (obj == null)
//            return null;
//        RObjectBiocep w = new RObjectBiocep(rs, obj);
//        w.rClass = rClass;
//        if (obj instanceof RInteger)
//            return w.asIntW();
//        else if (obj instanceof RNumeric)
//            return w.asNumW();
//        else if (obj instanceof RLogical)
//            return w.asLogW();
//        else if (obj instanceof RChar)
//            return w.asCharW();
//        else if (obj instanceof RFactor)
//            return w.asFactorW();
//
//        else if (obj instanceof RList)
//            return w.asListW();
//
//        else if (obj instanceof RDataFrameRef)
//            return w.asDfRefW();
//        else if (obj instanceof RDataFrame)
//            return w.asDfW();
//        else if (obj instanceof RMatrix)
//            return w.asRMatrixW();
//
//        return w;
//    }
//
//    public static RObjectBiocep makeW(RServices rs, RObject obj) {
//        return makeW(rs, obj, null);
//    }
//

    public WRAPPED_TYPE getWrapped() {
        return wrapped;
    }

//    public ROBJ_TYPE getObj() {
//        if (obj instanceof ReferenceInterface)
//            return extracted;
//        else
//            return obj;
//    }
//
//    public ROBJ_TYPE getReference() {
//        if (obj instanceof ReferenceInterface)
//            return obj;
//        else
//            return null;
//    }
//
//    public void setRObj(ROBJ_TYPE ro) {
//        obj = ro;
//        if (obj instanceof ReferenceInterface)
//            extracted = (ROBJ_TYPE)((ReferenceInterface) obj).extractRObject();
//    }
//
//    public RNumeric asNum() {
//        return (RNumeric) getObj();
//    }
//
    public RNumericBiocep asRNumeric() {
        return new RNumericBiocep(rs, (org.kchine.r.RNumeric) getWrapped());
    }

    public RIntegerBiocep asRInteger() {
        return new RIntegerBiocep(rs, (org.kchine.r.RInteger) getWrapped());
    }

    public RLogicalBiocep asRLogical() {
        return new RLogicalBiocep(rs, (org.kchine.r.RLogical) getWrapped());
    }

    public RCharBiocep asRChar() {
        return new RCharBiocep(rs, (org.kchine.r.RChar) getWrapped());
    }

    public RFactorBiocep asRFactor() {
        return new RFactorBiocep(rs, (org.kchine.r.RFactor) getWrapped());
    }


    public RMatrixDoubleBiocep asRMatrixDouble() {
        return new RMatrixDoubleBiocep(rs, (org.kchine.r.RMatrix) getWrapped());
    }

    public RListBiocep asRList() {
        return new RListBiocep(rs, (org.kchine.r.RList) getWrapped());
    }

    public RDataFrameBiocep asRDataFrame() {
        return new RDataFrameBiocep(rs, (org.kchine.r.RDataFrame) getWrapped());
    }

    public REnvironment asREnvironment() {
        return new REnvironmentBiocep(rs, (org.kchine.r.REnvironment) getWrapped());
    }

    public S3ObjBiocep asS3Obj() {
        return new S3ObjBiocep(rs, (org.kchine.r.RS3) getWrapped());
    }

//
//    public RListRef asListRef() {
//        return (RListRef) getObj();
//    }
//
//    public RListW asListW() {
//        return new RListW(rs, asList());
//    }
//
//    public RListRefW asListRefW() {
//        return new RListRefW(rs, asListRef());
//    }
//
//    public RDataFrame asDf() {
//        return (RDataFrame) getObj();
//    }
//
//    public RDataFrameBiocep asDfW() {
//        return new RDataFrameBiocep(rs, asDf());
//    }
//
//    public RDataFrameRef asDfRef() {
//        return (RDataFrameRef) getObj();
//    }
//
//
//    public RMatrix asRMatrix() {
//        return (RMatrix) getObj();
//    }
//
//    public RMatrixW asRMatrixW() {
//        return new RMatrixW(rs, asRMatrix());
//    }
//
//
//
//    public String getRConverterMethod(Class type) {
//        if (type == RNumeric.class) return "as.numeric";
//        if (type == RInteger.class) return "as.integer";
//        if (type == RFactor.class) return "as.factor";
//        if (type == RChar.class) return "as.character";
//        if (type == RLogical.class) return "as.logical";
//        return null;
//    }
//
//    public <E extends RObject> E convert(Class<E> type) throws RemoteException {
//        String m = getRConverterMethod(type);
//        return (E) rs.call(m, getObj());
//    }



}