package rengine;

import jhlir.RDataFrame;
import jhlir.REnvironment;
import jhlir.RObj;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPReference;


public class RObjectREngine<WRAPPED_TYPE extends org.rosuda.REngine.REXP>
        implements RObj<WRAPPED_TYPE> {

    protected REngineServicesREngine rs;
    private WRAPPED_TYPE wrapped;
    private REXP cached;
    protected REXPReference ref;

    protected RObjectREngine(REngineServicesREngine rs, WRAPPED_TYPE wrapped) {
        if (wrapped == null)
            throw new RuntimeException("Tried to create RObhjectWrapper on null!");
        this.rs = rs;
        this.wrapped = wrapped;
//        if (obj instanceof ReferenceInterface)
//            extracted = (ROBJ_TYPE)((ReferenceInterface)obj).extractRObject();
    }


    protected RObjectREngine(REngineServicesREngine rs, REXPReference ref) {
        if (ref == null)
            throw new RuntimeException("Tried to create RObhjectWrapper on null!");
        this.rs = rs;
        this.ref = ref;
    }

    protected REXP getResolved() {
//        if (getWrapped() instanceof REXPReference)
//            return cached;
//        else
//            return getWrapped();
        return null;
    }

    protected WRAPPED_TYPE getRef() {
//        if (getWrapped() instanceof REXPReference)
//            return getWrapped();
//        else
            return null;
    }



//    public WRAPPED_TYPE getWrapped() {
//        return wrapped;
//    }

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

    public boolean isRef() {
        return ref != null;
    }


    public RNumericREngine asRNumeric() {
        return new RNumericREngine(rs, (org.rosuda.REngine.REXPDouble) getWrapped());
    }

    public RIntegerREngine asRInteger() {
        return new RIntegerREngine(rs, (org.rosuda.REngine.REXPInteger) getWrapped());
    }

    public RLogicalREngine asRLogical() {
        return new RLogicalREngine(rs, (org.rosuda.REngine.REXPLogical) getWrapped());
    }

    public RCharREngine asRChar() {
        return new RCharREngine(rs, (org.rosuda.REngine.REXPString) getWrapped());
    }

    public RFactorREngine asRFactor() {
        return new RFactorREngine(rs, (org.rosuda.REngine.REXPFactor) getWrapped());
    }

    public RMatrixDoubleREngine asRMatrixDouble() {
        return new RMatrixDoubleREngine(rs, (org.rosuda.REngine.REXPDouble) getWrapped());
    }

    public RListREngine asRList() {
        return new RListREngine(rs, (org.rosuda.REngine.REXPGenericVector) getWrapped());
    }

    public RDataFrame asRDataFrame() {
        return new RDataFrameREngine(rs, (org.rosuda.REngine.REXPGenericVector) getWrapped());
    }

    public REnvironment asREnvironment() {
        return new REnvironmentREngine(rs, (org.rosuda.REngine.REXPEnvironment) getWrapped());
    }

    public S3ObjREngine asS3Obj() {
        return new S3ObjREngine(rs, (org.rosuda.REngine.REXPGenericVector) getWrapped());
    }
}

