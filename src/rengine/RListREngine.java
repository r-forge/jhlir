package rengine;

import jhlir.RList;
import org.apache.commons.lang.ArrayUtils;
import org.rosuda.REngine.REXPGenericVector;

import java.util.Arrays;
import java.util.List;


public class RListREngine
        extends RObjectREngine<REXPGenericVector>
        implements RList<REXPGenericVector> {


    public RListREngine(REngineServicesREngine rs, REXPGenericVector rList) {
        super(rs, rList);
    }

    public int getLength() {
        return getWrapped().length();
    }

    public RObjectREngine get(int i) {
        return rs.wrapObject(getWrapped().asList().at(i));
    }

    public RObjectREngine get(String name) {
        int i = ArrayUtils.indexOf(getNames(), name);
        return i == -1 ? null : get(i);
    }

    public String getName(int i) {
        return getWrapped().asList().keys()[i];
    }

    public String[] getNames() {
        return getWrapped().asList().keys();
    }

    public List<String> getNamesAsList() {
        return Arrays.asList(getNames());
    }
}


