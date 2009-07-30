package test;

import org.af.jhlir.rtools.RCmdBatch;

import java.util.List;

public class TestRCmdBatch {
    public static void main(String[] args) {
        try {
            RCmdBatch rcb = new RCmdBatch("c:\\programme\\r\\r-2.9.1");
            List<String> os;
            String[] os2;
//            List<String> is = Arrays.asList("sessionInfo()");
//            rcb.exec(is);
//            for (int i=0; i<os.size(); i++) {
//                System.out.println(i + ": " + os.get(i));
//            }

//            System.out.println("\n\n\n");
//            os = rcb.installCranPackage("bbbasdas");
//            for (int i=0; i<os.size(); i++) {
//                System.out.println(i + ": " + os.get(i));
//            }

//            System.out.println("\n\n\n");
//            os2 = rcb.getInstalledPackInfo("kernlab");
//            for (int i=0; i<os2.length; i++) {
//                System.out.println(i + ": " + os2[i]);
//            }
//            System.out.println("\n\n\n");
//            os2 = rcb.getInstalledPackInfo("xxx");
//            System.out.println("Package not found, return value is null: " + os2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
