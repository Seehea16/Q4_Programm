package data;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * CSV-FileFilter für JFileChooser.
 * 
 * @author Herbert Seewann
 * @version 5.0
 */
public class CSVFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        String extension = null;
        if(f.isDirectory()) {
            return true;
        }
        String s = f.getName();
        int i = s.lastIndexOf(".");
        if(i > 0 && i < s.length() - 1) {
            extension = s.substring(i + 1).toLowerCase();
        }
        return (extension != null && extension.equals("csv"));
    }

    @Override
    public String getDescription() {
        return "Comma Separated Values (*.csv)";
    }
}
