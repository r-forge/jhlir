package rengine;

import jhlir.RMatrixDouble;
import org.rosuda.REngine.REXPDouble;
import org.rosuda.REngine.REXPMismatchException;

public class RMatrixDoubleREngine
        extends RMatrixREngine<org.rosuda.REngine.REXPDouble, double[][], Double>
        implements RMatrixDouble<REXPDouble> {

    public RMatrixDoubleREngine(REngineServicesREngine rs, REXPDouble wrapped) {
        super(rs, wrapped);
    }

    public double[][] getData() {
        try {
            return getWrapped().asDoubleMatrix();
        } catch (REXPMismatchException e) {}
        return null;
    }

    protected Double[][] createArr(int rows, int cols) {
        return new Double[rows][cols];
    }


    public Double get(int i, int j) {
        return getWrapped().asDoubles()[getIndex(i,j)];
    }

    public Double getNAVal() {
        return RMatrixDouble.NA_VAL;
    }
}
