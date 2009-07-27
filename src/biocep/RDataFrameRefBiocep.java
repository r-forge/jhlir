package biocep;

public class RDataFrameRefBiocep
        extends RDataFrameBiocep
        implements jhlir.RDataFrameRef<org.kchine.r.RDataFrameRef, org.kchine.r.RDataFrame> {

    protected RDataFrameRefBiocep(REngineServicesBiocep rs, org.kchine.r.RDataFrameRef wrapped) {
        super(rs, wrapped);
    }
}