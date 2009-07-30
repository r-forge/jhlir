package rengine;

import jhlir.RCallServices;
import jhlir.RMatrixDouble;
import org.rosuda.REngine.REXPDouble;
import org.rosuda.REngine.REXPMismatchException;

public class RMatrixDoubleREngine
        extends RMatrixREngine<REXPDouble, REXPDouble, double[][], Double>
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
        return getResolved().asDoubles()[getIndex(i,j)];
    }

    public Double getNAVal() {
        return RCallServices.NA_RNUMERIC;
    }
}
