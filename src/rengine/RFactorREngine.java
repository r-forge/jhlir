package rengine;


import jhlir.RFactor;
import org.rosuda.REngine.REXPFactor;

import java.util.Arrays;
import java.util.List;

public class RFactorREngine
          extends RVectorFactorREngine<REXPFactor, REXPFactor, String[], String>
        implements RFactor<org.rosuda.REngine.REXPFactor> {

    public RFactorREngine(REngineServicesREngine rs, org.rosuda.REngine.REXPFactor wrapped) {
        super(rs, wrapped);
    }

    public int getLength() {
        return getResolved().length();
    }

    public String[] getData() {
        return getResolved().asStrings();
    }

    public String[] getDataAsObjArr() {
        return getData();
    }

    public String[] getLevels() {
        return getResolved().asFactor().levels();
    }

    public List<String> getLevelsAsList() {
        return Arrays.asList(getLevels());
    }

    public int[] getCodes() {
        return getResolved().asIntegers();
    }

    public int getCode(int i) {
        return getCodes()[i];
    }

    public String get(int i) {
        return getResolved().asStrings()[i];
    }

    public boolean isNA(int i) {
        return REXPFactor.isNA(getCode(i));
    }

}