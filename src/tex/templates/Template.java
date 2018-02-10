package tex.templates;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Template {
    protected StringBuilder t = new StringBuilder();
    protected File file;

    public Template(File file){
        this.file = file;
    }

    private void writeToFile(String txt, File file)throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(txt);
        writer.close();
    }


    /**
     * Creates TeX file by generator
     *
     * @return - TeX pattern
     */
    public File getTex(){
        try {
            if (file == null){
                System.out.println("Template file is not defined");
            }
            writeToFile(t.toString(), file);
            lock();
            System.out.println("TEX is ready!");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return file;
    }

    protected void lock() throws Throwable {
        this.finalize();
    }
}