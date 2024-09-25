package JavaFileHandling;
import java.io.*;
import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;

public class FileCompressionDecompression {

    // Method to compress a file
    public static void compressFile(String sourceFilePath, String compressedFilePath) {
        try (
            FileInputStream fis = new FileInputStream(sourceFilePath);
            FileOutputStream fos = new FileOutputStream(compressedFilePath);
            GZIPOutputStream gzipOS = new GZIPOutputStream(fos)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, bytesRead);
            }

            System.out.println("File compressed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to decompress a file
    public static void decompressFile(String compressedFilePath, String decompressedFilePath) {
        try (
            FileInputStream fis = new FileInputStream(compressedFilePath);
            GZIPInputStream gzipIS = new GZIPInputStream(fis);
            FileOutputStream fos = new FileOutputStream(decompressedFilePath)
        ) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = gzipIS.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File decompressed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Main method to test the compression and decompression
    public static void main(String[] args) {
        String sourceFile = "largefile.txt";  // Replace with your large text file
        String compressedFile = "largefile.txt.gz";
        String decompressedFile = "largefile_decompressed.txt";

        // Compress the file
        compressFile(sourceFile, compressedFile);

        // Decompress the file
        decompressFile(compressedFile, decompressedFile);

        // Check integrity
        try {
            if (filesAreIdentical(sourceFile, decompressedFile)) {
                System.out.println("File integrity check passed: The decompressed file matches the original file.");
            } else {
                System.out.println("File integrity check failed: The decompressed file does not match the original file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to check if two files are identical
    public static boolean filesAreIdentical(String filePath1, String filePath2) throws IOException {
        try (
            FileInputStream fis1 = new FileInputStream(filePath1);
            FileInputStream fis2 = new FileInputStream(filePath2)
        ) {
            int byte1, byte2;

            do {
                byte1 = fis1.read();
                byte2 = fis2.read();
                if (byte1 != byte2) {
                    return false;
                }
            } while (byte1 != -1);

            return true;
        }
    }
}

