package JavaFileHandling;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class CreateRandomIntegersFile {
    public static void main(String[] args) {
        String fileName = "randomIntegers.dat";  // File name
        Random random = new Random();  // Create a Random object

        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // Generate and write 500 random integers to the file
            for (int i = 0; i < 500; i++) {
                int randomInt = random.nextInt(1000);  // Generate random integer between 0 and 999
                dos.writeInt(randomInt);  // Write the random integer to the file
            }
            System.out.println("File created successfully with 500 random integers!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());  // Handle any IOException
        }
    }
}

