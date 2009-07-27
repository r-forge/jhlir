package biocep;

import jhlir.S3Obj;

import java.util.Arrays;
import java.util.List;

public class S3ObjBiocep
        extends RObjectBiocep<org.kchine.r.RS3, org.kchine.r.RS3>
        implements S3Obj<org.kchine.r.RS3>  {

    public S3ObjBiocep(REngineServicesBiocep rs, org.kchine.r.RS3 wrapped) {
        super(rs, wrapped);
    }

    public String[] getS3Classes() {
        return getResolved().getClassAttribute();
    }

    public List<String> getS3ClassesAsList() {
        return Arrays.asList(getS3Classes());
    }

    public String getS3Class() {
        return getS3Classes()[0];
    }

    //    public String[] getClasses() {
//        return getWrapped().getClassAttribute();
//    }
//
//    public String[] getClasses() {
//        return getWrapped().getClassAttribute();
//    }
}
