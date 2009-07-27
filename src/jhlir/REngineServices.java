package jhlir;

import java.rmi.RemoteException;

abstract public class REngineServices {
     abstract public void evalVoid(String expression) throws REngineException;
     abstract public RObj eval(String expression) throws REngineException;
     abstract public RRef evalAndGetRef(String expression) throws RemoteException;
     abstract public void assign(String varName, String expression) throws RemoteException;
//     public void callVoid(String function, Object... args) throws RemoteException;
     abstract public RObj call(String function, Object... args) throws RemoteException;
//     public RRef callAndGetRef(String function, Object... args) throws RemoteException;
//     public void callAndAssign(String varName, String function, Object... args) throws RemoteException;
     abstract public void put(String varName, Object obj) throws REngineException;
//     public boolean symbolExists(String symbol) throws RemoteException;
//     public void freeReference(RObj refObj) throws RemoteException;
//     public void freeAllReferences() throws RemoteException;

    public static Integer NA_RINTEGER;         
    public static Double NA_RNUMERIC;
    public static Boolean NA_RLOGICAL;
    public static String NA_CHAR;
    public static String NA_FACTOR;

}
