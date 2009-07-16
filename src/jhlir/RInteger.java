package jhlir;

import java.util.List;

public interface RInteger<WRAPPED_TYPE> extends RVector<WRAPPED_TYPE, int[], Integer> {
    static Integer NA_VAL = Integer.MIN_VALUE;

    int[] getData();
    Integer[] getDataAsObjArr();
    List<Integer> getDataAsList();
}