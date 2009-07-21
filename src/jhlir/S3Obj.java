package jhlir;

import java.util.List;

public interface S3Obj<WRAPPED_TYPE> extends RObj<WRAPPED_TYPE>{
    String[] getS3Classes();
    List<String> getS3ClassesAsList();
    String getS3Class();
}
