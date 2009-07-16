package test;

import org.rosuda.REngine.JRI.JRIEngine;
import org.rosuda.REngine.REXPLogical;
import org.rosuda.REngine.REngine;

public class TestRengine {
    public static void main(String[] args) {
        try {
            REngine re = new JRIEngine();
            REXPLogical rexp = (REXPLogical) re.parseAndEval("c(TRUE, FALSE, NA, TRUE, NA)");

            byte[] xs = rexp.asBytes();
            for (int i=0; i<xs.length; i++) System.out.println(xs[i]);

            boolean[] ys = rexp.isNA();
            for (int i=0; i<ys.length; i++) System.out.println(ys[i]);

            System.out.println(REXPLogical.isNA(xs[2]));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
