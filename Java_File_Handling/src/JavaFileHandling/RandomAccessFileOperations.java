package JavaFileHandling;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileOperations {

    public static void main(String[] args) {
        String fileName = "randomAccessFile.dat";

        try (RandomAccessFile raf = new RandomAccessFile(fileName, "rw")) {
            // Step 1: Write 100 integers to the file at random positions
            for (int i = 1; i <= 100; i++) {
                long position = (i - 1) * Integer.BYTES;
                raf.seek(position);  // Move the file pointer to the desired position
                raf.writeInt(i);     // Write the integer
            }

            // Step 2: Modify the value at the 50th position
            long pos50 = (50 - 1) * Integer.BYTES;
            raf.seek(pos50);
            raf.writeInt(5000);  // Modify the value at the 50th position to 5000

            // Step 3: Read and display the integers at the 20th and 75th positions
            long pos20 = (20 - 1) * Integer.BYTES;
            raf.seek(pos20);
            int valueAt20 = raf.readInt();
            System.out.println("Value at 20th position: " + valueAt20);

            long pos75 = (75 - 1) * Integer.BYTES;
            raf.seek(pos75);
            int valueAt75 = raf.readInt();
            System.out.println("Value at 75th position: " + valueAt75);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
