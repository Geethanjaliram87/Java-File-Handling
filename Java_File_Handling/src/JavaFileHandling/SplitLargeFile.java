package JavaFileHandling;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SplitLargeFile {
    public static void main(String[] args) {
        String inputFile = "largeFile.txt";
        int linesPerFile = 100;
        int fileCount = 1;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            int lineCount = 0;
            BufferedWriter writer = new BufferedWriter(new FileWriter("splitFile" + fileCount + ".txt"));

            while ((line = reader.readLine()) != null) {
                if (lineCount == linesPerFile) {
                    writer.close();
                    fileCount++;
                    writer = new BufferedWriter(new FileWriter("splitFile" + fileCount + ".txt"));
                    lineCount = 0;
                }
                writer.write(line);
                writer.newLine();
                lineCount++;
            }
            writer.close();
            System.out.println("File split successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

