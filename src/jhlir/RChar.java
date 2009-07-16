package jhlir;

import java.util.List;

public interface RChar<WRAPPED_TYPE> extends RVector<WRAPPED_TYPE, String[], String> {
    static String NA_VAL = "NA";

    String[] getData();
    String[] getDataAsObjArr();
    List<String> getDataAsList();
}
