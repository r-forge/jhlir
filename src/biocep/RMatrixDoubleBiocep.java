package biocep;

import jhlir.REngineServices;
import jhlir.RMatrixDouble;
import org.kchine.r.RMatrix;

public class RMatrixDoubleBiocep
        extends RMatrixBiocep<double[][], Double>
        implements RMatrixDouble<RMatrix> {

    public RMatrixDoubleBiocep(REngineServicesBiocep rs, RMatrix wrapped) {
        super(rs, wrapped);
    }

    protected Double[][] createArr(int rows, int cols) {
        return new Double[getRowCount()][getColumnCount()];
    }

    public double[][] getData() {
        double[][] res = new double[getRowCount()][getColumnCount()];
        for (int i = 0; i < getRowCount(); i++)
            for (int j = 0; j < getColumnCount(); j++) {
                res[i][j] = get(i, j);
            }
        return res;
    }

    public Double get(int i, int j) {
        return ((org.kchine.r.RNumeric) getWrapped().getValue()).getValue()[getIndex(i,j)];
    }

    public Double getNAVal() {
        return REngineServices.NA_RNUMERIC;
    }
}
