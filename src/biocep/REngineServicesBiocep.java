package biocep;

import jhlir.REngineException;
import jhlir.REngineServices;
import jhlir.RObj;
import jhlir.RRef;
import org.kchine.r.RMatrix;
import org.kchine.r.server.RServices;

import java.rmi.RemoteException;

public class REngineServicesBiocep implements REngineServices {

    private RServices rs;

    public REngineServicesBiocep(RServices rs) {
        this.rs = rs;
    }

    public RServices getRServices() {
        return rs;
    }

    public void evalVoid(String expression) throws REngineException {
        try {
            rs.evaluate(expression);
        } catch (RemoteException e) {
            throw new REngineException(e);
        }
    }

    public RObj eval(String expression) throws REngineException {
        org.kchine.r.RObject robj = null;
        try {
            robj = rs.getObject(expression);
        } catch (RemoteException e) {
            throw new REngineException(e);
        }
        return wrapObject(robj);
    }

    public RRef evalAndGetRef(String expression) throws RemoteException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    //
    public void assign(String varName, String expression) throws RemoteException {
        evalVoid(varName + "<-" + expression);
    }
//
//    public void callVoid(String function, Object... args) throws RemoteException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }

    //
    public RObj call(String function, Object... args) throws RemoteException {
        org.kchine.r.RObject robj = null;
        robj = rs.call(function, args);
        return wrapObject(robj);
    }
//
//    public RRef callAndGetRef(String function, Object... args) throws RemoteException {
//        return null;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public void callAndAssign(String varName, String function, Object... args) throws RemoteException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//

    public void put(String varName, Object obj) throws REngineException {
        try {
            rs.putAndAssign(obj, varName);
        } catch (RemoteException e) {
            throw new REngineException(e);
        }
    }

//
//    public boolean symbolExists(String symbol) throws RemoteException {
//        return false;  //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public void freeReference(RObj refObj) throws RemoteException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }
//
//    public void freeAllReferences() throws RemoteException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }


    public RObjectBiocep wrapObject(org.kchine.r.RObject robj) {
        if (robj == null)
            return null;
//        RObjectBiocep w = new RObjectBiocep(rs, obj);
//        w.rClass = rClass;

        else if (robj instanceof org.kchine.r.RNumeric)
            return new RNumericBiocep(this, (org.kchine.r.RNumeric) robj);
        else if (robj instanceof org.kchine.r.RInteger)
            return new RIntegerBiocep(this, (org.kchine.r.RInteger) robj);
        else if (robj instanceof org.kchine.r.RLogical)
            return new RLogicalBiocep(this, (org.kchine.r.RLogical) robj);
        else if (robj instanceof org.kchine.r.RChar)
            return new RCharBiocep(this, (org.kchine.r.RChar) robj);
        else if (robj instanceof org.kchine.r.RFactor)
            return new RFactorBiocep(this, (org.kchine.r.RFactor) robj);

        else if (robj instanceof RMatrix)
            return new RMatrixDoubleBiocep(this, (org.kchine.r.RMatrix) robj);

        else if (robj instanceof org.kchine.r.RList)
            return new RListBiocep(this, (org.kchine.r.RList) robj);
        else if (robj instanceof org.kchine.r.RDataFrame)
            return new RDataFrameBiocep(this, (org.kchine.r.RDataFrame) robj);

        else if (robj instanceof org.kchine.r.REnvironment)
            return new REnvironmentBiocep(this, (org.kchine.r.REnvironment) robj);

//
//        else if (obj instanceof RDataFrameRef)
//            return w.asDfRefW();
//
//        return w;
        return null;
    }

}
