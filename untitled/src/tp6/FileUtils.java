package tp6;

import java.io.*;

public class FileUtils {

    public static void copyFile(File scrFile, File file) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(scrFile);
            os = new FileOutputStream(file);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}
