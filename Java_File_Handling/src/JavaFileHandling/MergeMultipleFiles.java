package JavaFileHandling;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MergeMultipleFiles {
    public static void main(String[] args) {
        String[] inputFiles = {"source.txt", "file2.txt", "file3.txt"};
        String outputFile = "mergedFile.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String file : inputFiles) {
                List<String> lines = Files.readAllLines(Paths.get(file));
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.write("---- End of File ----");
                writer.newLine();
            }
            System.out.println("Files merged successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

