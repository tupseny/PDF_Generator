package tex;

import de.nixosoft.jlr.JLRGenerator;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;

public class TexLoader {

    public static final File RES_DIR = new File(System.getProperty("user.dir") + File.separator + "res");
    public static final File TEX_DIR = new File(RES_DIR.getAbsolutePath() + File.separator + "TeX");
    public static final File BIN_DIR = new File(TEX_DIR.getAbsolutePath() + File.separator + "bin");
    public static final File PDF_LATEX = new File(BIN_DIR.getAbsolutePath() + File.separator + "pdflatex.exe");
    public static final File OUT_DIR = new File(TEX_DIR.getAbsolutePath() + File.separator + "out");

    private static HashSet<File> saveFiles = new HashSet<>();

    static {
        System.out.println("%-- Static block --% (TexLoader)");
        makeDir(RES_DIR);
        makeDir(TEX_DIR);
        makeDir(BIN_DIR);
        makeDir(OUT_DIR);

        saveFile(PDF_LATEX);

        if (!PDF_LATEX.exists()) {
            try {
                System.err.println("File is important! Add it to the project (" + PDF_LATEX.getCanonicalPath() + ")");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(1);
        }
    }

    /**
     * Adds files to list. These files will not be deleted in the end.
     *
     * @param file - File to be saved
     */
    public static void saveFile(File file){
        saveFiles.add(file);
    }

    private static void makeDir(File dir){
        if (!dir.isDirectory()) {
            if (!dir.mkdir())
                System.err.println("Can't create new directory! (" + dir.getAbsolutePath() + ")");
            else System.out.println("CREATED: " + dir.getAbsolutePath());
        }
    }

    /**
     * Creates PDF file from TeX pattern.
     * In the end cleans TeX folder! (use {@link #saveFile(File) saveFile} to prevent deletation)
     *
     * @param file - TeX file
     */
    public static void createPdfFromTex(File file) {
        System.out.println("%-- Create PDF --%");

        //replacing and parsing
        try {
            //Generating pdf files
            //create pdf generator
            JLRGenerator pdfGen = new JLRGenerator();

            //generate pdf file from complete .tex file
            if (!pdfGen.generate(PDF_LATEX, 3, file, OUT_DIR, TEX_DIR))
                System.err.println(pdfGen.getErrorMessage());
            else {
                System.out.println("PDF generated! (" + OUT_DIR.getAbsolutePath() + ")");
                saveFile(pdfGen.getPDF());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        clean();
    }

    private static void clean(){
        System.out.println("%-- CLEANING --%");
        delete(TEX_DIR);
    }

    private static void delete(File f) {
        if (f.isDirectory()) {
            for (File c : Objects.requireNonNull(f.listFiles())) {
                if (!saveFiles.contains(c)) {
                    delete(c);
                    System.out.println("DELETED: " + c.getAbsolutePath());
                }else{

                }
            }
        }
        if (!f.delete())
            System.err.println("Can't delete: " + f.getAbsolutePath());
    }


}