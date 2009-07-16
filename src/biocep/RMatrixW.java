//package biocep;
//
//import org.kchine.r.RDataFrame;
//import org.kchine.r.RMatrix;
//import org.kchine.r.server.RServices;
//
//import java.rmi.RemoteException;
//
//public class RMatrixW extends RObjectBiocep {
//    public RMatrixW(RServices rs, RMatrix obj) {
//        super(rs, obj);
//    }
//
//    @Override
//    public RMatrix getObj() {
//        return (RMatrix)super.getObj();
//    }
//
//    public int getRowNr() {
//        return getObj().getDim()[0];
//    }
//
//    public int getColNr() {
//        return getObj().getDim()[0];
//    }
//
//    public RDataFrameBiocep asRDataFrameW() throws RemoteException {
//        return new RDataFrameBiocep(rs, (RDataFrame) rs.call("as.data.frame", getObj())) ;
//    }
//}
