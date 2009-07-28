package jhlir;

import java.rmi.RemoteException;

abstract public class REngineServices {
	
	/**
	 * Evaluates an expression.
	 * @param expression
	 * @throws REngineException
	 */
     abstract public void evalVoid(String expression) throws REngineException;
     
     /**
      * Evaluates an expression and returns the result.
      * @param expression expression to be evaluated
      * @return the result of evaluating the expression
      * @throws REngineException
      */
     abstract public RObj eval(String expression) throws REngineException;
     
     /**
      * Evaluates an expression and returns the result as a reference.
      * @param expression expression to be evaluated
      * @return a reference to the result of evaluating the expression
      * @throws RemoteException
      */
     abstract public RRef evalAndGetRef(String expression) throws RemoteException;
     
     /**
      * Assigns the result of evaluating the expression to a variable.
      * @param varName variable name that the result should be assigned to
      * @param expression expression to be evaluated
      * @throws RemoteException
      */
     abstract public void assign(String varName, String expression) throws RemoteException;
     
//     public void callVoid(String function, Object... args) throws RemoteException;
     
     /**
      * Calls a function with the given arguments.
      * The arguments can be of Type RObj ... TODO What is allowed to pass here? 
      * @param function name of the function to be called
      * @param args arguments to be part of the call
      * @throws RemoteException
      */
     abstract public RObj call(String function, Object... args) throws RemoteException;
     
//     public RRef callAndGetRef(String function, Object... args) throws RemoteException;
//     public void callAndAssign(String varName, String function, Object... args) throws RemoteException;
     
     /**
      * TODO
      * @param varname
      * @param obj
      * @throws RemoteException
      */     
     abstract public void put(String varName, Object obj) throws REngineException;
     
//     public boolean symbolExists(String symbol) throws RemoteException;
//     public void freeReference(RObj refObj) throws RemoteException;
//     public void freeAllReferences() throws RemoteException;

     /** Integer value that codes a NA */
    public static Integer NA_RINTEGER;   
    /** Double value that codes a NA */
    public static Double NA_RNUMERIC;
    /** Boolean value that codes a NA */
    public static Boolean NA_RLOGICAL;
    /** String value that codes a NA for a character */
    public static String NA_CHAR;
    /** String value that codes a NA for a factor */
    public static String NA_FACTOR;

}
