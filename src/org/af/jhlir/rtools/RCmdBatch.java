package org.af.jhlir.rtools;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


/**
 * Execute R in batch mode. Use this to query R for information / set up stuff / install packages,
 * before you can properly connect to it through jhlir. Only prerequisite to invoke this class
 * is knowledge of the path to R_HOME.
 */

public class RCmdBatch {



    public static final String[] R_ARGS = {"--vanilla", "--slave"};
    //	= {"--no-site-file","--no-init-file","--no-restore","--no-save"};
    protected File rHome;
    protected File tempDir;

    protected String libPaths;
    protected String rVersion;



    /**
     * Constructor
     *
     * @param rHome R Home directory.
     */
    public RCmdBatch(File rHome) {
        this(rHome.getAbsolutePath());
    }


    /**
     * Constructor
     *
     * @param rHome Absolute Path to R Home directory.
     */
    public RCmdBatch(String rHome) {
        this.rHome = new File(rHome);
        this.tempDir = new File(System.getProperty("java.io.tmpdir"));

        if (rHome == null || rHome.trim().equals("")) {
            String s = "Empty R_Home passed to RCmdBatch! It was: " + rHome;
            throw new RuntimeException(s);
        }
    }


    public List<String> exec(List<String> input) throws RCmdBatchException {
        List<String> output = new ArrayList<String>();
        String fn = "r_batch_" + Calendar.getInstance().getTime().getTime();
        File batchFile = new File(tempDir, fn);

        try {
            makeRBatchScript(batchFile, input);
        } catch (FileNotFoundException e) {
            throw new RCmdBatchException("", e);
        }

        List<String> commands = new ArrayList<String>();
        commands.add(getRExePath().getAbsolutePath());
        commands.add("CMD");
        commands.add("BATCH");
        for (String arg : R_ARGS) {
            commands.add(arg);
        }
        commands.add(batchFile.getAbsolutePath());


        ProcessBuilder pb = new ProcessBuilder(commands);
        pb.directory(tempDir);
//        logger.info("Starting process: " + pb.command().toString());
        Process ps = null;
        try {
            ps = pb.start();
            logProcessOutput(ps);
        } catch (IOException e) {
            throw new RCmdBatchException("", e);
        }
        int exitCode = 0;
        try {
            exitCode = ps.waitFor();
        } catch (InterruptedException e) {
            throw new RCmdBatchException("", e);
        }

        File outputFile = new File(tempDir, fn + ".Rout");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(outputFile));
        } catch (FileNotFoundException e) {
            throw new RCmdBatchException("", e);
        }
        String line;
        try {
            while ((line = reader.readLine()) != null)
                output.add(line);
        } catch (IOException e) {
            throw new RCmdBatchException("sdf: ", e);
        }

        if (exitCode != 0) {
            String s = "R CMD BATCH exited abnormally with code: " + exitCode + "\n";
            s += "Batch file was:\n" + input.toString() + "\n";
            s += "R Output was:\n" + output.toString();
            throw new RCmdBatchException(s);
        }

        return output;
    }

    protected void makeRBatchScript(File target, List<String> commands) throws FileNotFoundException {
//    	logger.info("Creating R batch script: "+target.getAbsolutePath());
        PrintStream p = new PrintStream(new FileOutputStream(target));
        for (String c : commands)
            p.println(c);
        p.close();
    }


    public List<String> retrieveInfo(List<String> input, List<String> vars) throws RCmdBatchException{

        List<String> res = new ArrayList<String>(vars.size());
        List<String> is = new ArrayList<String>();
        is.addAll(input);
        for (String v:vars) {
            is.add("print(" + vars);
        }
        List<String> os = exec(is);

        for (int i=vars.size()-1; i >=0; i--) {
            res.set(i, os.get(i));
        }
        return res;
    }

    protected File getRExePath() {
        return new File(new File(rHome, "bin"), "R");
    }

    public List<String> getInstalledPackInfo(String p) throws RCmdBatchException {

        List<String> is = Arrays.asList(
                "ip <- installed.packages(noCache=TRUE)",
                "found <- \"" + p + "\" %in% rownames(ip)",
                "lp <- ifelse(found, ip[\"" + p + "\", \"LibPath\"], \"\")",
                "ver <- ifelse(found, ip[\"" + p + "\", \"Version\"], \"\")"
        );

        List<String> os = retrieveInfo(is, Arrays.asList("lp", "ver"));
        if (os.get(0).trim().equals(""))
            return null;
        return os;
    }

    public List<String> installCranPackage(String p) throws RCmdBatchException {
        String cmd = "install.packages(\"" +
                p + "\"" + 
                ", repos=\"http://cran.r-project.org\"" +
                ")";
        List<String> is = Arrays.asList(cmd);
        List<String> os = exec(is);
        return os;
    }

    public List<String> installRForgePackage(String p) throws RCmdBatchException {
        String cmd = "install.packages(\"" +
                p + "\"" + 
                ", repos=\"http://R-Forge.R-project.org\"" +
                ")";
        List<String> is = Arrays.asList(cmd);
        List<String> os = exec(is);
        return os;
    }

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

    private void logProcessOutput(Process ps) throws IOException {
        BufferedReader is = new BufferedReader(new InputStreamReader(ps.getInputStream()));
        String line;
        while ((line = is.readLine()) != null) {
//        	logger.info("Process: "+ line);
        }
        is = new BufferedReader(new InputStreamReader(ps.getErrorStream()));
        while ((line = is.readLine()) != null) {
//        	logger.error("Process error: "+line);
        }
    }
//
//
//

    private void getRSettings() throws IOException, InterruptedException{
        List<String> input = new ArrayList<String>();
        input.add("lp <-  paste(.libPaths(),collapse=.Platform$path.sep)");
        input.add("ver <-  paste(sessionInfo()$R.version$major, sessionInfo()$R.version$minor, sep=\".\")");

        List<String> output = new ArrayList<String>();
//        int exitCode = exec(input, output);
//        if (exitCode != 0)
//            throw new RuntimeException("Could not retrieve R settings!");
//
//        int i = 0;
//        while(!output.get(i).startsWith("<VAR_CONTENT>")) i++;

//        logger.info(" - retrieved R settings, home: " + rs_home + " (arch=" + rs_arch + ", libs=" + rs_libs + ")");
    }


}



