package jhlir;

import java.util.List;

public interface RList<WRAPPED_TYPE> extends RObj<WRAPPED_TYPE> {
    int getLength();
    RObj get(int i);
    RObj get(String name);
    String getName(int i);
    String[] getNames();
    List<String> getNamesAsList();
}
