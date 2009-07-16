package jhlir;

import java.util.List;


public interface RVectorFactor<WRAPPED_TYPE, ARR_TYPE, EL_TYPE> extends RObj<WRAPPED_TYPE>{
    public int getLength();
    public ARR_TYPE getData();
    public EL_TYPE get(int i);
    public boolean isNA(int i);
    public EL_TYPE[] getDataAsObjArr();
    public List<EL_TYPE> getDataAsList();

}
