//package jhlir.rscript;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintStream;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.List;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
//
///*
//    Execute R in slave mode to find package directories.
//*/
//
//// TODO comment it and move some consts ---> props. probly go through it and make it proper.
//public abstract class RExecutor {
//    protected static Log logger = LogFactory.getLog(RExecutor.class);
//
//    public static final String[] RPARAMETER //= {"--vanilla","--slave"};
//	= {"--no-site-file","--no-init-file","--no-restore","--no-save"};
//
//    protected String rHome;
//    protected String tempDir;
//
//    protected String rs_home;
//    protected String rs_arch;
//    protected String rs_docdir;
//    protected String rs_incdir;
//    protected String rs_sharedir;
//    protected String rs_ldp;
//    protected String rs_dyldp;
//    protected String rs_unzip;
//    protected String rs_latex;
//    protected String rs_paper;
//    protected String rs_print;
//    protected String rs_libs;
//
//    protected String rVersion;
//
//    /**
//     * Depending on the OS this method returns the appropriate RExecutor-subclass-object.
//     * @param rHome home directory of R
//     * @param tempDir directory for temp files
//     */
//
//    public static RExecutor getRExecutor(String rHome, String tempDir) {
//    	if (SgtkOSTools.isWindows()) {
//        	return new RExecutorWindows(rHome, tempDir);
//        } else if (SgtkOSTools.isUnix()) {
//        	return new RExecutorUnix(rHome, tempDir);
//        } else {
//        	throw new RuntimeException("Could not determine OS!");
//        }
//    }
//
//    /**
//     * Standard Constructor, which is only accessible from a subclass.
//     * @param rHome home directory of R
//     * @param tempDir directory for temp files
//     */
//
//    protected RExecutor(String rHome, String tempDir) {
//        this.rHome = rHome;
//        this.tempDir = tempDir;
//
//
//        if (rHome == null || rHome.trim().equals("")) {
//            String s = "R Home was not set for RExecutor!";
//            RuntimeException rt = new RuntimeException(s);
//            logger.error(s, rt);
//            throw rt;
//        }
//        if (tempDir == null || tempDir.trim().equals("")) {
//            String s = "Temp. dir was not set for RExecutor!";
//            RuntimeException rt = new RuntimeException(s);
//            logger.error(s, rt);
//            throw rt;
//        }
//        try {
//            getRSettings();
//        } catch (Exception e) {
//            throw new RuntimeException("Could not retrieve R settings!", e);
//        }
//
//    }
//    private void getRSettings() throws IOException, InterruptedException{
//        List<String> input = new ArrayList<String>();
//        input.add("vars = c('R_HOME','R_ARCH','R_DOC_DIR','R_INCLUDE_DIR','R_SHARE_DIR','LD_LIBRARY_PATH','DYLD_LIBRARY_PATH','R_UNZIPCMD','R_LATEXCMD','R_PAPERSIZE','R_PRINTCMD')");
//        input.add("vars.cont = lapply(vars, function(x) paste(\"<VAR_CONTENT>\", Sys.getenv(x),sep=\"\"))");
//        input.add("libs.cont =  paste(.libPaths(),collapse=.Platform$path.sep)");
//        input.add("libs.cont =  paste(\"<VAR_CONTENT>\", libs.cont, sep=\"\")");
//        input.add("vers.cont =  paste(sessionInfo()$R.version$major, sessionInfo()$R.version$minor, sep=\".\")");
//        input.add("vers.cont =  paste(\"<VAR_CONTENT>\", vers.cont, sep=\"\")");
//        input.add("vars.cont =  c(vars.cont, libs.cont, vers.cont)");
//        input.add("cat(unlist(vars.cont), sep=\"\\n\")");
//
//        List<String> output = new ArrayList<String>();
//        int exitCode = exec(input, output);
//        if (exitCode != 0)
//            throw new RuntimeException("Could not retrieve R settings!");
//
//        int i = 0;
//        while(!output.get(i).startsWith("<VAR_CONTENT>")) i++;
//
//        int vcl = "<VAR_CONTENT>".length();
//        rs_home = output.get(i++).substring(vcl);
//        logger.info("rs_home: "+rs_home);
//        rs_arch = output.get(i++).substring(vcl);
//        logger.info("rs_arch: "+rs_arch);
//        rs_docdir = output.get(i++).substring(vcl);
//        logger.info("rs_docdir: "+rs_docdir);
//        rs_incdir = output.get(i++).substring(vcl);
//        logger.info("rs_incdir: "+rs_incdir);
//        rs_sharedir = output.get(i++).substring(vcl);
//        logger.info("rs_sharedir: "+rs_sharedir);
//        rs_ldp = output.get(i++).substring(vcl);
//        logger.info("rs_ldp: "+rs_ldp);
//        rs_dyldp = output.get(i++).substring(vcl);
//        logger.info("rs_dyldp: "+rs_dyldp);
//        rs_unzip = output.get(i++).substring(vcl);
//        logger.info("rs_unzip: "+rs_unzip);
//        rs_latex = output.get(i++).substring(vcl);
//        logger.info("rs_latex: "+rs_latex);
//        rs_paper = output.get(i++).substring(vcl);
//        logger.info("rs_paper: "+rs_paper);
//        rs_print = output.get(i++).substring(vcl);
//        logger.info("rs_print: "+rs_print);
//        rs_libs = output.get(i++).substring(vcl);
//        logger.info("rs_libs: "+rs_libs);
//        rVersion = output.get(i).substring(vcl);
//        logger.info("R Version: "+rVersion);
//        logger.info(" - retrieved R settings, home: " + rs_home + " (arch=" + rs_arch + ", libs=" + rs_libs + ")");
//    }
//
//    public String getRHome() {
//        return rs_home;
//    }
//
//    public String getLibPaths() {
//        return rs_libs;
//    }
//
//    public String getRVersion() {
//        return rVersion;
//    }
//
//    protected void makeRBatchScript(File target, List<String> commands) throws FileNotFoundException {
//    	logger.info("Creating R batch script: "+target.getAbsolutePath());
//        PrintStream p = new PrintStream(new FileOutputStream(target));
//        for (String c:commands)
//            p.println(c);
//        p.close();
//    }
//
//    protected abstract String getRExePath();
//
//    public int javareconf() throws IOException, InterruptedException {
//    	List<String> commands = new ArrayList<String>();
//		commands.add(getRExePath());
//        commands.add("CMD");
//        commands.add("javareconf");
//        commands.add("-e");
//        ProcessBuilder pb = new ProcessBuilder(commands);
//        pb.directory(new File(tempDir));
//        logger.info("Starting process: " + pb.command().toString());
//        Process ps = pb.start();
//        logProcessOutput(ps);
//        int exitCode = ps.waitFor();
//        return exitCode;
//    }
//
//    /*
//     *  CMD INSTALL [options] [-l lib] pkgs
//	 *  Arguments
//     *  pkgs 	A space-separated list with the path names of the packages to be installed.
//     *  lib 	the path name of the R library tree to install to.
//     *  options 	a space-separated list of options through which in particular the process
//     *  for building the help files can be controlled. Options should only be given once.
//     *  Use R CMD INSTALL --help for the current list of options.
//     */
//
//    public int installPackage(File file, String lib) throws IOException, InterruptedException {
//    	List<String> commands = new ArrayList<String>();
//		commands.add(getRExePath());
//        commands.add("CMD");
//        commands.add("INSTALL");
//        commands.add("-l");
//        commands.add(lib);
//        commands.add(file.getAbsolutePath());
//        ProcessBuilder pb = new ProcessBuilder(commands);
//        pb.directory(new File(tempDir));
//        logger.info("Starting process: " + pb.command().toString());
//        Process ps = pb.start();
//        logProcessOutput(ps);
//        int exitCode = ps.waitFor();
//        return exitCode;
//    }
//
//    private void logProcessOutput(Process ps) throws IOException {
//    	BufferedReader is = new BufferedReader(new InputStreamReader(ps.getInputStream()));
//        String line;
//        while ((line = is.readLine()) != null) {
//        	logger.info("Process: "+ line);
//        }
//        is = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
//        while ((line = is.readLine()) != null) {
//        	logger.error("Process error: "+line);
//        }
//	}
//
//	public int exec(List<String> input, List<String> output) throws IOException, InterruptedException {
//        String fn = "r_batch_" + Calendar.getInstance().getTime().getTime();
//        File batchFile = new File(tempDir, fn);
//        makeRBatchScript(batchFile, input);
//
//        List<String> commands = new ArrayList<String>();
//        commands.add(getRExePath());
//        commands.add("CMD");
//        commands.add("BATCH");
//        for (String arg : RPARAMETER) {commands.add(arg);}
//        commands.add(batchFile.getAbsolutePath());
//
//
//        ProcessBuilder pb = new ProcessBuilder(commands);
//        pb.directory(new File(tempDir));
//        logger.info("Starting process: " + pb.command().toString());
//        Process ps = pb.start();
//        logProcessOutput(ps);
//        int exitCode = ps.waitFor();
//
//        File outputFile = new File(tempDir, fn + ".Rout");
//        BufferedReader reader = new BufferedReader(new FileReader(outputFile));
//        String line;
//        while ( (line = reader.readLine()) != null)
//            output.add(line);
//
//        return exitCode;
//    }
//
//
//}
