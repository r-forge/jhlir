package test;

import org.af.jhlir.backends.rengine.RCallServicesREngine;
import org.rosuda.REngine.JRI.JRIEngine;

public class TestRengine {
    public static void main(String[] args) {


    	
    	
        try {
            RCallServicesREngine rs = new RCallServicesREngine(new JRIEngine());
            rs.engineEval("rnorm(10", true);

////            Rengine re = new Rengine();
//            REngine re = new JRIEngine();
//            re.parseAndEval("xx <- list(1,2)");
//            re.parseAndEval("names(xx)[1] <- \"foo\"");
//            re.parseAndEval("yy <- list(foo=1,2)");
//            System.out.println(re.parseAndEval("xx").asList().keyAt(1));
//            System.out.println(re.parseAndEval("yy").asList().keyAt(1));
//
//            RTypeFactory rtf = RTypeFactoryREngine.getInstance(null);
//
//
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
