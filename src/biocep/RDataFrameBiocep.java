package biocep;


import org.apache.commons.lang.ArrayUtils;
import org.kchine.r.RDataFrame;

import java.util.Arrays;
import java.util.List;

public class RDataFrameBiocep 
        extends RObjectBiocep<org.kchine.r.RDataFrame>
    implements jhlir.RDataFrame<RDataFrame> {

    public RDataFrameBiocep(REngineServicesBiocep rs, RDataFrame wrapped) {
        super(rs, wrapped);
    }

    public int getRowNr() {
        return getWrapped().getRowNames().length;
    }

    public int getColNr() {
       return  getWrapped().getData().getValue().length;
    }

    public String[] getRowNames() {
        return getWrapped().getRowNames();
    }

    public String[] getColNames() {
        return getWrapped().getData().getNames();
    }

    public List<String> getRowNamesAsList() {
        return Arrays.asList(getRowNames());
    }

    public List<String> getColNamesAsList() {
        return Arrays.asList(getColNames());
    }

    public String getRowName(int i) {
        return getWrapped().getRowNames()[i];
    }

    public String getColName(int i) {
        return getWrapped().getData().getNames()[i];
    }

    public int getRowIndex(String name) {
        return ArrayUtils.indexOf(getRowNames(), name);
    }

    public int getColIndex(String name) {
        return ArrayUtils.indexOf(getColNames(), name);
    }


//    protected org.kchine.r.RObject getRowWrappedObj(int i) {
//        return getWrapped().getData().getValue()[i];
//    }
//
//    public RObj getRow(int i) {
//        return rs.wrapObject(getRowWrappedObj(i));
//    }
//
//    public RObj getRow(String name) {
//        return getRow(getRowIndex(name));
//    }


    protected org.kchine.r.RObject getColWrappedObj(int i) {
        return getWrapped().getData().getValue()[i];
    }

    public RVectorFactorBiocep getCol(int i) {
        return (RVectorFactorBiocep) rs.wrapObject(getColWrappedObj(i));
    }

    public RVectorFactorBiocep getCol(String name) {
        return getCol(getRowIndex(name));
    }

    public Object get(int row, int col) {
        return getCol(col).get(row);
    }


//    public void setCol(int i, RVectorFactorBiocep v) {
//        RList list = getWrapped().getData();
//        list.getValue()[i] = v.getWrapped();
//        getWrapped().setData(list);
//    }


//    public RObject getCol(RLegalName name) {
//        int i = getColIndex(name);
//        if (i == -1)
//            return null;
//        else
//            return getCol(i);
//    }
//
//    public RObjectBiocep getColW(RLegalName name) {
//        int i = getColIndex(name);
//        if (i == -1)
//            return null;
//        else
//            return getColW(i);
//    }


//    public boolean isRNum(int i) {
//        return getCol(i) instanceof RNumeric;
//    }
//
//    public boolean isRInt(int i) {
//        return getCol(i) instanceof RInteger;
//    }
//
//    public boolean isRFactor(int i) {
//        return getCol(i) instanceof RFactor;
//    }
//
//    public boolean isRChar(int i) {
//        return getCol(i) instanceof RChar;
//    }
//
//    public boolean isRLogical(int i) {
//        return getCol(i) instanceof RLogical;
//    }
//
//
//    public RNumericBiocep getAsRNumW(int i) {
//        return new RNumericBiocep(rs, (RNumeric) getCol(i));
//    }
//
//    public RLogicalBiocep getAsRIntW(int i) {
//        return new RLogicalBiocep(rs, (RInteger) getCol(i));
//    }
//
//    public RFactorBiocep getAsRFactorW(int i) {
//        return new RFactorBiocep(rs, (RFactor) getCol(i));
//    }
//
//    public RCharBiocep getAsRCharW(int i) {
//        return new RCharBiocep(rs, (RChar) getCol(i));
//    }
//
//    public RLogicalBiocep getAsRLogicalW(int i) {
//        return new RLogicalBiocep(rs, (RLogical) getCol(i));
//    }
//
//    public List<String> getNumericVars() {
//        List<String> result = new ArrayList<String>();
//        for (int i=0; i<getColNr(); i++)
//            if (isRNum(i))
//                result.add(getColName(i));
//        return result;
//    }
//
//    public List<RLegalName> getNumericVarsLN() {
//        return RLegalName.makeRLegalNamesUnchecked(getNumericVars());
//    }
//
//
//    public List<String> getFactorVars() {
//        List<String> result = new ArrayList<String>();
//        for (int i=0; i<getColNr(); i++)
//            if (isRFactor(i))
//                result.add(getColName(i));
//        return result;
//    }
//
//    public List<RLegalName> getFactorVarsLN() {
//        return RLegalName.makeRLegalNamesUnchecked(getFactorVars());
//    }
//
//    public List<String> getNumberVars() {
//        List<String> result = new ArrayList<String>();
//        for (int i=0; i<getColNr(); i++)
//            if (isRNum(i) || isRInt(i))
//                result.add(getColName(i));
//        return result;
//    }
//
//    public List<RLegalName> getNumberVarsLN() {
//        return RLegalName.makeRLegalNamesUnchecked(getNumberVars());
//    }
//
//    public List<String> getIntegerVars() {
//        List<String> result = new ArrayList<String>();
//        for (int i=0; i<getColNr(); i++) {
//            if (isRInt(i))
//                result.add(getColName(i));
//        }
//        return result;
//    }
//
//    public List<RLegalName> getIntegerVarsLN() {
//        return RLegalName.makeRLegalNamesUnchecked(getIntegerVars());
//    }


}
