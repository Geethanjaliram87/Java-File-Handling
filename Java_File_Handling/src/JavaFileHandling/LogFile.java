package JavaFileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFile {

    public static void main(String[] args) {
        String logFilePath = "access.log";  // Replace with the path to your log file

        try (BufferedReader br = new BufferedReader(new FileReader(logFilePath))) {
            String logEntryPattern = 
                "^([\\d.]+) \\S+ \\S+ \\[([\\w:/]+\\s[+\\-]\\d{4})\\] \"\\S+ (\\S+) \\S+\" (\\d{3}) \\d+";
            Pattern pattern = Pattern.compile(logEntryPattern);

            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String timestamp = matcher.group(2);
                    String url = matcher.group(3);
                    String statusCode = matcher.group(4);

                    System.out.println("Timestamp: " + timestamp);
                    System.out.println("URL Accessed: " + url);
                    System.out.println("HTTP Status Code: " + statusCode);
                    System.out.println("------------------------------");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


