package biocep;


import jhlir.RList;
import org.apache.commons.lang.ArrayUtils;

import java.util.Arrays;
import java.util.List;


public class RListBiocep extends RObjectBiocep<org.kchine.r.RList>
    implements RList<org.kchine.r.RList> {

    public RListBiocep(REngineServicesBiocep rs, org.kchine.r.RList rList) {
        super(rs, rList);
    }

    public int getLength() {
        return getWrapped().getValue().length;
    }

    public RObjectBiocep get(int i) {
        return rs.wrapObject(getWrapped().getValue()[i]);
    }

    public RObjectBiocep get(String name) {
        int i = ArrayUtils.indexOf(getNames() ,name);
        return i == -1 ? null : get(i);
    }

    public String getName(int i) {
        return getWrapped().getNames()[i];
    }

    public String[] getNames() {
        return getWrapped().getNames();
    }

    public List<String> getNamesAsList() {
        return Arrays.asList(getNames());
    }
}