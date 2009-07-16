package biocep;

import jhlir.REnvironment;
import jhlir.RObj;

import java.util.Arrays;
import java.util.List;


public class REnvironmentBiocep
            extends RObjectBiocep<org.kchine.r.REnvironment>
            implements REnvironment<org.kchine.r.REnvironment> {

    public REnvironmentBiocep(REngineServicesBiocep rs, org.kchine.r.REnvironment wrapped) {
        super(rs, wrapped);
    }

    public String[] getNames() {
        return getWrapped().getData().keySet().toArray(new String[0]);
    }

    public List<String> getNamesAsList() {
        return Arrays.asList(getNames());
    }

    public RObj get(String name) {
        return rs.wrapObject(getWrapped().getData().get(name));
    }

    public REnvironmentBiocep getParentEnv() {
//        return rs.wrapObject(getWrapped().getData().get(name));
        return null;
    }
}
