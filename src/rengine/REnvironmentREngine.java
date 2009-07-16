package rengine;

import jhlir.RObj;
import org.rosuda.REngine.REXPEnvironment;
import org.rosuda.REngine.REngineException;

import java.util.Arrays;
import java.util.List;

//todo handle excs
public class REnvironmentREngine
            extends RObjectREngine<REXPEnvironment>
            implements jhlir.REnvironment<REXPEnvironment> {

    public REnvironmentREngine(REngineServicesREngine rs, REXPEnvironment wrapped) {
        super(rs, wrapped);
    }

    public String[] getNames() {
        try {
            //todo bad!!!! and exc !!!
            rs.put("tmp", getWrapped());
            String[] res = rs.eval("ls(tmp)").asRChar().getData();
            rs.evalVoid("rm(tmp)");
            return res;
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public List<String> getNamesAsList() {
        return Arrays.asList(getNames());
    }

    public RObj get(String name) {
        try {
            return rs.wrapObject(getWrapped().get(name));
        } catch (REngineException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }

    public REnvironmentREngine getParentEnv() {
        try {
            return (REnvironmentREngine) rs.wrapObject(getWrapped().parent());
        } catch (REngineException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return null;
    }
}
