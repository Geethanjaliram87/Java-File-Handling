package JavaFileHandling;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CreateAccessLog {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\Dr. T.P. YOKESH\\eclipse-workspace\\Java_File_Handling\\access.log";  // Name of the log file
        String logPattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+) \\S+ \\S+ \\[([^\\]]+)] \"(\\S+) (\\S+) \\S+\" (\\d{3}) (\\d+)";
        Random random = new Random();  // Create a Random object

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Generate sample log entries
            for (int i = 0; i < 100; i++) {
                String ipAddress = "192.168.1." + (random.nextInt(256));  // Simulated IP address
                String timestamp = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss Z").format(new Date());
                String requestMethod = random.nextBoolean() ? "GET" : "POST";  // Randomly choose GET or POST
                String resource = "/page" + (random.nextInt(10) + 1);  // Simulated resource path
                int statusCode = random.nextInt(100) + 200;  // Random HTTP status code (200-299)
                int contentSize = random.nextInt(5000);  // Random content size

                // Format log entry
                String logEntry = String.format("%s - - [%s] \"%s %s HTTP/1.1\" %d %d",
                        ipAddress, timestamp, requestMethod, resource, statusCode, contentSize);

                writer.println(logEntry);  // Write the log entry to the file
            }

            System.out.println("access.log created successfully with sample log entries!");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());  // Handle any IOException
        }
    }
}

