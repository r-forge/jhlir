package rengine;

import jhlir.RLogical;
import org.rosuda.REngine.REXPLogical;

public class RLogicalREngine
        extends RVectorREngine<org.rosuda.REngine.REXPLogical, boolean[], Boolean>
        implements jhlir.RLogical<REXPLogical>{

    public RLogicalREngine(REngineServicesREngine rs, org.rosuda.REngine.REXPLogical wrapped) {
        super(rs, wrapped);
    }

    public boolean[] getData() {
        byte[] bs = getWrapped().asBytes();
        boolean[] res = new boolean[getLength()];
        for (int i=0;i<res.length; i++)
            res[i] = bs[i] != 0;
        return res;
    }

    public byte[] getDataAsBytes() {
        return getWrapped().asBytes();
    }

    public Boolean[] getDataAsObjArr() {
        byte[] bs = getWrapped().asBytes();
        Boolean[] res = new Boolean[getLength()];
        for (int i = 0; i < res.length; i++)
            res[i] = REXPLogical.isNA(bs[i]) ? RLogical.NA_VAL : bs[i] != 0;
        return res;
    }

    public Boolean get(int i) {
        byte b = getWrapped().asBytes()[i];
        return REXPLogical.isNA(b) ? RLogical.NA_VAL : b != 0;
    }

    public Byte getAsByte(int i) {
        return getDataAsBytes()[i];
    }

    public boolean isNA(int i) {
        byte b = getWrapped().asBytes()[i];
        return REXPLogical.isNA(b);
    }
}
