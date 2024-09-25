package JavaFileHandling;
import java.io.*;
import java.util.Scanner;

public class BinaryFileSearch {

    // Method to read integers from a binary file
    public static int[] readBinaryFile(String filePath) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(filePath))) {
            int count = (int) (new File(filePath).length() / Integer.BYTES);
            int[] numbers = new int[count];

            for (int i = 0; i < count; i++) {
                numbers[i] = dis.readInt();
            }
            return numbers;
        }
    }

    // Binary search method
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Target found
            } else if (array[mid] < target) {
                left = mid + 1; // Search in the right half
            } else {
                right = mid - 1; // Search in the left half
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        String filePath = "sortedNumbers.bin"; // Replace with your binary file path

        try {
            // Read integers from the binary file
            int[] numbers = readBinaryFile(filePath);

            // Prompt user for the number to search
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an integer to search for: ");
            int target = scanner.nextInt();

            // Perform binary search
            int index = binarySearch(numbers, target);

            // Output the result
            if (index != -1) {
                System.out.println("Number " + target + " found at index: " + index);
            } else {
                System.out.println("Number " + target + " not found in the file.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
