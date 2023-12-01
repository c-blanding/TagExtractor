import javax.swing.*;
import java.io.File;
import java.nio.file.Path;

public class TagExtractorRead {
    public static Path getFile() {
        JFileChooser chooser = new JFileChooser();

        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        // set the chooser to the project src directory
        chooser.setCurrentDirectory(target.toFile());

        try  // Code that might trigger the exception goes here
        {

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                target = chooser.getSelectedFile().toPath();
                return target;// this is a File object not a String filename

            }
        } catch (Exception e) {
            throw e;
        }
        return null;
    }
}
