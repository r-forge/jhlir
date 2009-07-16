package jhlir;

import java.util.List;

public interface RNumeric<WRAPPED_TYPE> extends RVector<WRAPPED_TYPE, double[], Double> {
    static Double NA_VAL = Double.NaN;
    double[] getData();
    Double[] getDataAsObjArr();
    List<Double> getDataAsList();
}
