package jhlir;

import java.rmi.RemoteException;

public interface REngineServices {
     public void evalVoid(String expression) throws REngineException;
     public RObj eval(String expression) throws REngineException;
//     public RRef evalAndGetRef(String expression) throws RemoteException;
     public void assign(String varName, String expression) throws RemoteException;
//     public void callVoid(String function, Object... args) throws RemoteException;
     public RObj call(String function, Object... args) throws RemoteException;
//     public RRef callAndGetRef(String function, Object... args) throws RemoteException;
//     public void callAndAssign(String varName, String function, Object... args) throws RemoteException;
     public void put(String varName, Object obj) throws REngineException;
//     public boolean symbolExists(String symbol) throws RemoteException;
//     public void freeReference(RObj refObj) throws RemoteException;
//     public void freeAllReferences() throws RemoteException;
}
