import java.io.*;
import java.util.*;

public class charList {
    private List<String> characters = new ArrayList<>();
    private static final String FILE_NAME = "Character_List.txt";
    private static final Scanner scanner = new Scanner(System.in);

    public void Newchar() {
        System.out.println("Enter character details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Race: ");
        String race = scanner.nextLine();
        System.out.print("Level: ");
        String level = scanner.nextLine();
        System.out.print("Class: ");
        String Class = scanner.nextLine();
        System.out.print("HP: ");
        String hp = scanner.nextLine();
        System.out.print("Gold: ");
        String gold = scanner.nextLine();

        String character = String.format("Name: %s, Race: %s, Level: %s, Class: %s, HP: %s, Gold: %s",
                name, race, level, Class, hp, gold);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(character);
            writer.newLine();
            characters.add(character);
            System.out.println("Character added successfully.");
        } catch (IOException e) {
            System.out.println("Error saving character.");
            e.printStackTrace();
        }
    }

    public void charList() {
        characters.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int index = 1;
            while ((line = reader.readLine()) != null) {
                characters.add(line);
                System.out.println(index++ + ". " + line);
            }
        } catch (IOException e) {
            System.out.println("Error reading character list.");
        }
    }

    public void deleteChar() {
        charList();
        if (characters.isEmpty()) {
            System.out.println("No characters to delete.");
            return;
        }

        int index = getValidIndex("Enter the number of the character to delete: ");
        if (index == -1) return;

        System.out.println("Are you sure you want to delete: " + characters.get(index) + " (yes/no)?");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            characters.remove(index);
            saveToFile();
            System.out.println("Character deleted successfully.");
        } else {
            System.out.println("Deletion canceled.");
        }
    }

    public void editChar() {
        charList();
        if (characters.isEmpty()) {
            System.out.println("No characters to edit.");
            return;
        }

        int index = getValidIndex("Enter the number of the character to edit: ");
        if (index == -1) return;

        String character = characters.get(index);
        System.out.println("Editing: " + character);

        character = updateField(character, "Name");
        character = updateField(character, "Race");
        character = updateField(character, "Level");
        character = updateField(character, "Class");
        character = updateField(character, "HP");
        character = updateField(character, "Gold");

        characters.set(index, character);
        saveToFile();
        System.out.println("Character updated successfully.");
    }

    private int getValidIndex(String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int index = scanner.nextInt() - 1;
                scanner.nextLine(); // Consume newline
                if (index >= 0 && index < characters.size()) {
                    return index;
                } else {
                    System.out.println("Invalid number. Try again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
    }

    private String updateField(String character, String field) {
        System.out.print("Enter new " + field + " (leave blank to keep current): ");
        String input = scanner.nextLine();
        if (!input.isEmpty()) {
            return character.replaceFirst(field + ": .*?(,|$)", field + ": " + input + "$1");
        }
        return character;
    }

    private void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (String character : characters) {
                writer.write(character);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving character list.");
        }
    }
}
