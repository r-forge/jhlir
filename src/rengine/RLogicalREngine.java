package rengine;

import jhlir.RLogical;
import org.rosuda.REngine.REXPLogical;

public class RLogicalREngine
        extends RVectorREngine<REXPLogical, REXPLogical, boolean[], Boolean>
        implements jhlir.RLogical<REXPLogical>{

    public RLogicalREngine(REngineServicesREngine rs, org.rosuda.REngine.REXPLogical wrapped) {
        super(rs, wrapped);
    }

    public boolean[] getData() {
        byte[] bs = getResolved().asBytes();
        boolean[] res = new boolean[getLength()];
        for (int i=0;i<res.length; i++)
            res[i] = bs[i] != 0;
        return res;
    }

    public byte[] getDataAsBytes() {
        return getResolved().asBytes();
    }

    public Boolean[] getDataAsObjArr() {
        byte[] bs = getResolved().asBytes();
        Boolean[] res = new Boolean[getLength()];
        for (int i = 0; i < res.length; i++) {
            if (REXPLogical.isNA(bs[i]))
                res[i] = RLogical.NA_VAL;
            else
                res[i] = (bs[i] != 0);
        }
        return res;
    }

    public Boolean get(int i) {
        byte b = getResolved().asBytes()[i];
        if (REXPLogical.isNA(b))
            return RLogical.NA_VAL;
        return b != 0;
    }

    public Byte getAsByte(int i) {
        return getDataAsBytes()[i];
    }

    public boolean isNA(int i) {
        byte b = getResolved().asBytes()[i];
        return REXPLogical.isNA(b);
    }
}