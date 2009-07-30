package org.af.jhlir.call;

public interface RMatrixDouble<WRAPPED_TYPE> extends RMatrix<WRAPPED_TYPE, double[][], Double> {
    double[][] getData();
}
