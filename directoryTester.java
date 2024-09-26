import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class directoryTester {
    public static void main(String[] args) {
        // Create a new directory
        File exampleDirectory = new File("exampleDirectory");
        if (!exampleDirectory.exists()) {
            exampleDirectory.mkdir();
        }

        // Create two files in the directory with different data
        createFile(new File(exampleDirectory, "file1.txt"), "This is the content of file 1.");
        createFile(new File(exampleDirectory, "file2.txt"), "This is the content of file 2.");

        // Create a new Blob using the example directory
        try {
            Blob blob = new Blob(exampleDirectory.getAbsolutePath(), false); // Adjust compression as needed
            System.out.println("Blob created with name: " + blob.getBlobName());
        } catch (IOException e) {
            System.err.println("Error creating Blob: " + e.getMessage());
        }
    }

    // Helper method to create a file with specified content
    private static void createFile(File file, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        } catch (IOException e) {
            System.err.println("Failed to create file: " + file.getAbsolutePath());
        }
    }
}
