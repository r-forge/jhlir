package org.af.jhlir.backends.biocep;

import org.af.jhlir.call.*;
import org.kchine.r.RMatrix;
import org.kchine.r.server.RServices;

import java.rmi.RemoteException;

public class REngineServicesBiocep extends RCallServices {

    static {
        RCallServices.NA_RINTEGER = Integer.MIN_VALUE;
        RCallServices.NA_RNUMERIC = Double.NaN;
        RCallServices.NA_RLOGICAL = null;
        RCallServices.NA_CHAR = "NA";
        RCallServices.NA_FACTOR = null;
    }

    private RServices rs;

    public REngineServicesBiocep(RServices rs) {
        this.rs = rs;
        try {
			rs.evaluate("options(error = function() {sgtk.global.err <<- geterrmessage()})");
		} catch (RemoteException e) {
			throw new REngineException(e);
		}
    }

    public RServices getRServices() {
        return rs;
    }
    
    
    public void beforeCall() throws REngineException {
    	try {
    		rs.evaluate("sgtk.global.err <<- NULL");
    		rs.evaluate("warning(\"NO_WARNING\")");
    	} catch (Exception e) {
            throw new REngineException(e);
        }	
    }
    
    public void afterCall() throws REngineException {
    	String error = null;
    	try {
    		error = (String) rs.getObjectConverted("sgtk.global.err");    		
    	} catch (Exception e) {
            throw new REngineException(e);
    	}	
    	if (error != null && !error.equals("")) {
    		RErrorException e = new RErrorException(error);
    		throw e;
    	}
    }

    public void evalVoid(String expression) throws REngineException {
    	beforeCall();
        try {
            rs.evaluate(expression);
        } catch (RemoteException e) {
            throw new REngineException(e);
        }
        afterCall();
    }

    public RObj eval(String expression) throws REngineException {
    	beforeCall();
        org.kchine.r.RObject robj = null;
        try {
            robj = rs.getObject(expression);
        } catch (RemoteException e) {
            throw new REngineException(e);
        }
        afterCall();
        return wrapObject(robj);
    }

    public RRef evalAndGetRef(String expression) throws RemoteException {
    	beforeCall();
        org.kchine.r.server.ReferenceInterface ref = null;
        try {
            ref = (org.kchine.r.server.ReferenceInterface) rs.getReference(expression);
        } catch (Exception e) {
            throw new REngineException(e);
        }
        afterCall();
        return wrapObject(ref);
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
    	beforeCall();
        org.kchine.r.RObject robj = null;
        robj = rs.call(function, args);
        afterCall();
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
    	beforeCall();
        try {
            if (obj instanceof RObjectBiocep) {
                rs.putAndAssign(((RObjectBiocep) obj).getWrapped(), varName);
            }
        } catch (RemoteException e) {
            throw new REngineException(e);
        }
        afterCall();
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

    public RRef wrapObject(org.kchine.r.server.ReferenceInterface ref) {
        if (ref instanceof org.kchine.r.RListRef)
            return new RListRefBiocep(this, (org.kchine.r.RListRef) ref);
        return null;
    }

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

	@Override
	public String[] getWarning() {
		String[] warning;
		try {
			warning = (String[]) rs.callAndConvert("names(warnings())");
		} catch (Exception e) {
			throw new REngineException(e);
		}
		if (warning.length>0 && !warning[0].equals("NO_WARNING")) return warning;	
		return null;
	}

}
