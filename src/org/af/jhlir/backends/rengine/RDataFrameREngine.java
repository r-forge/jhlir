package org.af.jhlir.backends.rengine;

import org.af.jhlir.call.RDataFrame;
import org.apache.commons.lang.ArrayUtils;
import org.rosuda.REngine.REXPGenericVector;
import org.rosuda.REngine.REXPReference;

import java.util.Arrays;
import java.util.List;


public class RDataFrameREngine
        extends RObjectREngine<REXPGenericVector, REXPGenericVector>
    implements RDataFrame<REXPGenericVector> {

    //todo: some row stuff, names, etc
    public RDataFrameREngine(REngineServicesREngine rs, REXPGenericVector wrapped) {
        super(rs, wrapped);
    }

    public RDataFrameREngine(REngineServicesREngine rs, REXPReference wrapped) {
        super(rs, wrapped);
    }

    public int getRowCount() {
        return getColumnCount() == 0 ? 0 : getCol(0).getLength(); 
//        return getWrapped().length();
    }

    public int getColumnCount() {
        return getResolved().length();
    }

    public String[] getRowNames() {
        return null;
    }

    public String[] getColNames() {
        return getResolved().asList().keys();
    }

    public List<String> getRowNamesAsList() {
        return Arrays.asList(getRowNames());
    }

    public List<String> getColNamesAsList() {
        return Arrays.asList(getColNames());
    }

    public String getRowName(int i) {
        return null;
    }

    public String getColName(int i) {
        return getResolved().asList().keyAt(i);
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


    protected org.rosuda.REngine.REXP getColWrappedObj(int i) {
        return getResolved().asList().at(i);
    }

    public RVectorFactorREngine getCol(int i) {
        return (RVectorFactorREngine) rs.wrapObject(getColWrappedObj(i));
    }

    public RVectorFactorREngine getCol(String name) {
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