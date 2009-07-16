package jhlir;

import java.util.List;

public interface RLogical<WRAPPED_TYPE> extends RVector<WRAPPED_TYPE, boolean[], Boolean> {
    static Boolean NA_VAL = null;
    boolean[] getData();
    Boolean[] getDataAsObjArr();
    List<Boolean> getDataAsList();
}
