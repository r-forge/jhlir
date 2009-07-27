//package test;

import org.rosuda.REngine.JRI.JRIEngine;
import org.rosuda.REngine.REngine;

public class TestRengine {
    public static void main(String[] args) {

        try {
//            Rengine re = new Rengine();
            REngine re = new JRIEngine();
//            REXP g = re.parseAndEval(".GlobalEnv");
//            REXP r = re.parseAndEval("list()",g, false);
//            System.out.println(r);
////            re.eval("plot(1:3)");

//            REXP g = re.parseAndEval(".GlobalEnv");
//            re.parseAndEval("x <- rnorm(100)");
//            REXP x_ref = re.parseAndEval("x", g, false);
//            REXP r = new REXPLanguage( new RList( new REXP[]{new REXPSymbol("head"), x_ref}));
//            REXP r3 = re.eval(r, g, true );
//            System.out.println(r);
//            System.out.println(r3);
            System.exit(1);
//        System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
