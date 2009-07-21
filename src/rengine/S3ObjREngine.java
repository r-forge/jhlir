package rengine;

import jhlir.S3Obj;
import org.rosuda.REngine.REXPGenericVector;
import org.rosuda.REngine.REXPMismatchException;

import java.util.Arrays;
import java.util.List;

public class S3ObjREngine
        extends RObjectREngine<REXPGenericVector>
        implements S3Obj<REXPGenericVector> {

    public S3ObjREngine(REngineServicesREngine rs, REXPGenericVector wrapped) {
        super(rs, wrapped);
    }

    public String[] getS3Classes() {
        try {
            return getWrapped().getAttribute("class").asStrings();
            //todo exc
        } catch (REXPMismatchException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getS3ClassesAsList() {
        return Arrays.asList(getS3Classes());
    }

    public String getS3Class() {
        return getS3Classes()[0];
    }
}
