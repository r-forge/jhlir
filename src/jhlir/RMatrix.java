package jhlir;

import java.util.List;

public interface RMatrix<WRAPPED_TYPE, ARR_TYPE, EL_TYPE> extends RObj<WRAPPED_TYPE>{
    int getRowNr();
    int getColNr();
    String[] getRowNames();
    String[] getColNames();
    List<String> getRowNamesAsList();
    List<String> getColNamesAsList();
    
    ARR_TYPE getData();
    EL_TYPE get(int i, int j);
    EL_TYPE[][] getDataAsObjArr();

    boolean isNA(int i, int j);
    EL_TYPE getNAVal();    
}
