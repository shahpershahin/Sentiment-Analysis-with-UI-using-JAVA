import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SentimentAnalysisUI {
    public static void main(String[] args) throws IOException {
        // Run Python script as a subprocess
        ProcessBuilder pb = new ProcessBuilder("python", "sentiment_analysis.py");
        Process process = pb.start();

        // Set up input and output streams
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(process.getOutputStream()), true);

        // Get user input
        String userInput = "I feel horny"; // Example input, replace with user input

        // Send user input to Python subprocess
        writer.println(userInput);

        // Read response from Python subprocess
        String response = reader.readLine();
        System.err.printf(response.getClass().getSimpleName());
        // System.out.println("Sentiment Analysis Result: " + response);

        // Close resources
        writer.close();
        reader.close();
    }
}
