import java.io.*;
import java.util.Scanner;

public class DMnotes {

    private static final String FILE_NAME = "DM_Notes.txt";

    public void editOrNew() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to make a new note, delete your notes, or view your notes?");
        String user = scanner.nextLine().toLowerCase(); // Convert input to lowercase for better recognition

        if (user.contains("new")) {
            System.out.println("What is the note you would like to add?");
            String note = scanner.nextLine();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
                writer.write(note);
                writer.newLine();
                System.out.println("Note added successfully.");
            } catch (IOException e) {
                System.out.println("Error: Unable to save note.");
                e.printStackTrace();
            }
        }

        else if (user.contains("delete")) {
            System.out.println("Are you 100% sure? This will delete ALL of your notes, and this CANNOT BE UNDONE. Type 'yes' to confirm.");
            String user2 = scanner.nextLine().toLowerCase();
            if (user2.equals("yes")) {
                File file = new File(FILE_NAME);
                if (file.exists() && file.delete()) {
                    System.out.println("All notes have been deleted successfully.");
                } else {
                    System.out.println("Error: No notes found or unable to delete file.");
                }
            } else {
                System.out.println("Aborting deletion.");
            }
        }

        else if (user.contains("view")) {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("No notes found. Add some notes first.");
                return; // Exit method early
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                System.out.println("Your notes:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error: Unable to read notes.");
                e.printStackTrace();
            }
        }

        else {
            System.out.println("Invalid option. Please type 'new', 'delete', or 'view'.");
        }
    }
}
