package jhlir;

public interface RMatrixDouble<WRAPPED_TYPE> extends RMatrix<WRAPPED_TYPE, double[][], Double> {
    static Double NA_VAL = Double.NaN;

    double[][] getData();
}
