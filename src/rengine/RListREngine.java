package rengine;

import jhlir.RList;
import org.apache.commons.lang.ArrayUtils;
import org.rosuda.REngine.REXPGenericVector;
import org.rosuda.REngine.REXPReference;

import java.util.Arrays;
import java.util.List;


public class RListREngine
        extends RObjectREngine<REXPGenericVector, REXPGenericVector>
        implements RList<REXPGenericVector> {


    protected RListREngine(REngineServicesREngine rs, REXPGenericVector wrapped) {
        super(rs, wrapped);
    }

    protected RListREngine(REngineServicesREngine rs, REXPReference wrapped) {
        super(rs, wrapped);
    }

    public int getLength() {
        return getResolved().length();
    }

    public RObjectREngine get(int i) {
        return rs.wrapObject(getResolved().asList().at(i));
    }

    public RObjectREngine get(String name) {
        int i = ArrayUtils.indexOf(getNames(), name);
        return i == -1 ? null : get(i);
    }

    public String getName(int i) {
        return getResolved().asList().keys()[i];
    }

    public String[] getNames() {
        return getResolved().asList().keys();
    }

    public List<String> getNamesAsList() {
        return Arrays.asList(getNames());
    }
}


