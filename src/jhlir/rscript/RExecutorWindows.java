//package jhlir.rscript;
//
//
///**
// * This class executes R-code on Windows-machines via
// * a batch file tempDir\\temp.bat (why?) and
// * %R_HOME\\bin\\R.exe RControl.RPARAMETER
// * to determine R-settings as well as find, check and install packages.
// */
//public class RExecutorWindows extends RExecutor {
//
//	/**
//	 * Standard Constructor
//	 * @param rHome home directory of R
//	 * @param tempDir directory for temp files
//	 */
//	RExecutorWindows(String rHome, String tempDir) {
//		super(rHome, tempDir);
//	}
//
//
//    public String getRExePath() {
//        return rHome + "\\bin\\R";
//    }
//}
