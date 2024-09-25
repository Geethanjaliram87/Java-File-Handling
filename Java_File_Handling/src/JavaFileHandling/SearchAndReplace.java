package JavaFileHandling;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class SearchAndReplace {
    public static void main(String[] args) {
        String filePath = "document.txt";
        String searchWord = "point";
        String replaceWord = "Decimal value";

        try {
            List<String> lines = Files.readAllLines(Paths.get(filePath));
            List<String> modifiedLines = lines.stream()
                                              .map(line -> line.replaceAll(searchWord, replaceWord))
                                              .collect(Collectors.toList());

            Files.write(Paths.get(filePath), modifiedLines, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);

            System.out.println("Replacement done successfully!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
