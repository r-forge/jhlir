package jhlir;

import java.util.List;

/**
 * Interface for a RChar Object that extends RObj.
 * @param <WRAPPED_TYPE> underlying type of the used back-end, see {@link jhlir.RObj RObj}
 */
public interface RChar<WRAPPED_TYPE> extends RVector<WRAPPED_TYPE, String[], String> {
    String[] getData();
    String[] getDataAsObjArr();
    List<String> getDataAsList();
}
