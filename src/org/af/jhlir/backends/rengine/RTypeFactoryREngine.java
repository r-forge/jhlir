package org.af.jhlir.backends.rengine;

import org.af.jhlir.call.RTypeFactory;
import org.af.jhlir.call.RNumeric;
import org.rosuda.REngine.REXPDouble;
import org.apache.commons.lang.ArrayUtils;

public class RTypeFactoryREngine extends RTypeFactory{
    private RCallServicesREngine rs;

    public RTypeFactoryREngine(RCallServicesREngine rs) {
        this.rs = rs;
    }

    public static RTypeFactory getInstance(RCallServicesREngine rs) {
        return new RTypeFactoryREngine(rs);
    }

    public RNumeric createRNumeric(double[] data) {
        return new RNumericREngine(rs, new REXPDouble(data));
    }

    public RNumeric createRNumeric(Double[] data) {
        return new RNumericREngine(rs, new REXPDouble(ArrayUtils.toPrimitive(data)));
    }
}
