package jhlir;

import java.util.List;

public interface RFactor<WRAPPED_TYPE> extends RVector<WRAPPED_TYPE, String[], String>{
    String[] getData();
    String[] getDataAsObjArr();
    List<String> getDataAsList();
    String[] getLevels();
    List<String> getLevelsAsList();
    int[] getCodes();
    int getCode(int i);
}
