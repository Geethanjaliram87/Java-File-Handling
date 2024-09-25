package JavaFileHandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyWithProgress {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            long totalBytes = fis.available();
            byte[] buffer = new byte[1024];
            long bytesCopied = 0;
            int bytesRead;
            int progress = 0;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                bytesCopied += bytesRead;
                int newProgress = (int) ((bytesCopied * 100) / totalBytes);

                if (newProgress > progress) {
                    progress = newProgress;
                    System.out.println("Progress: " + progress + "%");
                }
            }

            System.out.println("File copy completed!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
