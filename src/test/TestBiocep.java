//package test;
//
//import org.kchine.r.server.RServices;
//import org.kchine.r.server.DirectJNI;
//import org.kchine.r.RObject;
//import org.rosuda.REngine.REXP;
//
//public class TestBiocep {
//  public static void main(String[] args) {
//        try {
//            RServices re = DirectJNI.getInstance().getRServices();
//
//            re.evaluate("library(rpart)");
//            re.evaluate("library(kernlab)");
//
////            RObject r = re.getObject("rpart(Species~., data=iris)");
//            RObject r = re.getObject("ksvm(Species~., data=iris)");
//
//
//            System.out.println(r);
//
////            byte[] xs = rexp.asBytes();
////            for (int i=0; i<xs.length; i++) System.out.println(xs[i]);
////
////            boolean[] ys = rexp.isNA();
////            for (int i=0; i<ys.length; i++) System.out.println(ys[i]);
////
////            System.out.println(REXPLogical.isNA(xs[2]));
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}