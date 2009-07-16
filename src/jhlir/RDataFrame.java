package jhlir;

import java.util.List;

public interface RDataFrame<WRAPPED_TYPE> extends RObj<WRAPPED_TYPE>{

    int getRowNr();
    int getColNr();

    String[] getRowNames();
    String[] getColNames();
    List<String> getRowNamesAsList();
    List<String> getColNamesAsList();
    String getRowName(int i);
    String getColName(int i);
    int getRowIndex(String name);
    int getColIndex(String name);


//    RObj getRow(int i);
//    RObj getRow(String name);
    RObj getCol(int i);
    RVectorFactor getCol(String name);
    Object get(int row, int col);


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
//    public List<String> getNumericVars();
//    public List<String> getFactorVars() {
//    public List<String> getNumberVars() {
//
//    public List<RLegalName> getNumberVarsLN() {
//    }
//
//    public List<String> getIntegerVars();


}
