package org.af.jhlir.backends.rengine;

import org.af.jhlir.call.*;
import org.af.jhlir.call.REngineException;
import org.rosuda.REngine.*;

import java.rmi.RemoteException;


public class RCallServicesREngine extends RCallServices {

    static {
        RCallServices.NA_RINTEGER = Integer.MIN_VALUE;
        RCallServices.NA_RNUMERIC = Double.NaN;
        RCallServices.NA_RLOGICAL = null;
        RCallServices.NA_CHAR = "NA";
        RCallServices.NA_FACTOR = null;
    }

    private REngine rs;
    private REXP globalEnv;

    public RCallServicesREngine(REngine rs) {
        this.rs = rs;
        try {
            globalEnv = rs.parseAndEval(".GlobalEnv");
        } catch (org.rosuda.REngine.REngineException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (REXPMismatchException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        try {
			rs.parseAndEval("options(error = function() {sgtk.global.err <<- geterrmessage()})");
		} catch (org.rosuda.REngine.REngineException e) {
			throw new REngineException(e);
		} catch (REXPMismatchException e) {
			throw new REngineException(e);
		}
    }

    public REngine getREngine() {
        return rs;
    }
    
    public void beforeCall() throws REngineException {
    	try {
    		rs.parseAndEval("sgtk.global.err <<- NULL");
    		rs.parseAndEval("warning(\"NO_WARNING\")");
    	} catch (Exception e) {
            throw new REngineException(e);
        }	
    }
    
    public void afterCall() throws REngineException {
    	String error = null;
    	try {
    		REXP rexp = rs.parseAndEval("sgtk.global.err");
    		if (rexp instanceof REXPNull) return;
    		error = rs.parseAndEval("sgtk.global.err").asString();
    	} catch (Exception e) {
            throw new REngineException(e);
    	}	
    	if (error != null) {
    		RErrorException e = new RErrorException(error);
    		throw e;
    	}
    }

    public void evalVoid(String expression) throws REngineException {
    	beforeCall();
        try {
            rs.parseAndEval(expression);
        } catch (Exception e) {
            throw new REngineException(e);
        }
        afterCall();
    }

    public RObj eval(String expression) throws REngineException {
    	beforeCall();
        org.rosuda.REngine.REXP robj = null;
        try {
            robj = rs.parseAndEval(expression);
        } catch (Exception e) {
            throw new REngineException(e);
        }
        afterCall();
        return wrapObject(robj);
    }

    public RRef evalAndGetRef(String expression) throws RemoteException {
    	beforeCall();
        REXPReference rr = null;
        try {
            rr = (REXPReference) rs.parseAndEval(expression, globalEnv, false);
        } catch (Exception e) {
            throw new REngineException(e);
        }
        afterCall();
        return wrapObject(rr);
    }

    public void assign(String varName, String expression) throws RemoteException {
        evalVoid(varName + "<-" + expression);
    }

    //
//
//    public void callVoid(String function, Object... args) throws RemoteException {
//        //To change body of implemented methods use File | Settings | File Templates.
//    }

    //

    public RObj call(String function, Object... args) throws RemoteException {
        return null;
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
            if (obj instanceof RObjectREngine) {
                rs.assign(varName, ((RObjectREngine)obj).getWrapped());
            }
        } catch (Exception e) {
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


    public RRef wrapObject(REXPReference ref) {
        REXP robj = ref.resolve();
        if (robj instanceof org.rosuda.REngine.REXPGenericVector) {
            if (robj.hasAttribute("class") && ((REXPString)robj.getAttribute("class")).asStrings()[0].equals("data.frame"))
                return new RDataFrameRefREngine(this, ref);
//            if (robj.hasAttribute("class")) // should we better call is.object here?
//                return new S3ObjREngine(this, (org.rosuda.REngine.REXPGenericVector) robj);
//            // default
            return new RListRefREngine(this, ref);
        }
        return null;
    }


    public RObjectREngine wrapObject(org.rosuda.REngine.REXP robj) {
        if (robj == null)
            return null;
//        RObjectBiocep w = new RObjectBiocep(rs, obj);
//        w.rClass = rClass;
//        if (obj instanceof RInteger)
//            return w.asIntW();
        else if (robj instanceof org.rosuda.REngine.REXPDouble) {
            try {
                if (robj.hasAttribute("dim") && robj.getAttribute("dim").asIntegers().length == 2)
                    return new RMatrixDoubleREngine(this, (org.rosuda.REngine.REXPDouble) robj);
            } catch (REXPMismatchException e) {
            }
            // default
            return new RNumericREngine(this, (org.rosuda.REngine.REXPDouble) robj);
        } else if (robj instanceof org.rosuda.REngine.REXPFactor)
            return new RFactorREngine(this, (org.rosuda.REngine.REXPFactor) robj);
            // factor inherist from integer in REngine
        else if (robj instanceof org.rosuda.REngine.REXPInteger && !(robj instanceof org.rosuda.REngine.REXPFactor))
            return new RIntegerREngine(this, (org.rosuda.REngine.REXPInteger) robj);
        else if (robj instanceof org.rosuda.REngine.REXPLogical)
            return new RLogicalREngine(this, (org.rosuda.REngine.REXPLogical) robj);

        else if (robj instanceof org.rosuda.REngine.REXPString)
            return new RCharREngine(this, (org.rosuda.REngine.REXPString) robj);
//        else if (obj instanceof RFactor)
//            return w.asFactorW();
//
        else if (robj instanceof org.rosuda.REngine.REXPGenericVector) {
            if (robj.hasAttribute("class") && ((REXPString)robj.getAttribute("class")).asStrings()[0].equals("data.frame"))
                return new RDataFrameREngine(this, (org.rosuda.REngine.REXPGenericVector) robj);
            if (robj.hasAttribute("class")) // should we better call is.object here?
                return new S3ObjREngine(this, (org.rosuda.REngine.REXPGenericVector) robj);
            // default
            return new RListREngine(this, (org.rosuda.REngine.REXPGenericVector) robj);
        } else if (robj instanceof org.rosuda.REngine.REXPEnvironment)
            return new REnvironmentREngine(this, (org.rosuda.REngine.REXPEnvironment) robj);
        return null;
    }

	@Override
	public String[] getWarning() {
		String[] warning;
		try {
			warning = rs.parseAndEval("names(warnings())").asStrings();
		} catch (Exception e) {
			throw new REngineException(e);
		}
		if (warning.length>0 && !warning[0].equals("NO_WARNING")) return warning;	
		return null;
	}


}
