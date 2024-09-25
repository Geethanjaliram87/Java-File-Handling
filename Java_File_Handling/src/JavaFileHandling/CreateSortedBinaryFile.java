package JavaFileHandling;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CreateSortedBinaryFile {
    public static void main(String[] args) {
        String fileName = "sortedNumbers.bin";

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            for (int i = 1; i <= 500; i++) {
                dos.writeInt(i);
            }
            System.out.println("File created successfully with 500 sorted integers!");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


