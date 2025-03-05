import java.util.Scanner;

public class Main_Menu {
    public static void main(String[] args) {
        Dice_roller diceRoller = new Dice_roller();
        Dice_roller.Dice dice = diceRoller.new Dice();
        DMnotes notes = new DMnotes();
        Menu_printing menu = new Menu_printing();
        Scanner scanner = new Scanner(System.in);
        charList list = new charList();

        while (true) { // Infinite loop, exits with break
            menu.printMenu();
            System.out.print("Please select an option (1-7): "); // Cleaner prompt

            // Read input as a trimmed string to prevent whitespace issues
            String userInput = scanner.nextLine().trim();

            // Check if the input is a valid number
            if (!userInput.matches("\\d+")) { // Match only digits
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                continue; // Restart the loop
            }

            int userChoice = Integer.parseInt(userInput); // Convert to integer

            switch (userChoice) {
                case 1:
                    // Roll dice with updated functionality (handling multiple dice types and modifiers)
                    dice.askForInput(); // This asks for input like "5D6 + 3D4"
                    System.out.println("Final Total: " + dice.getTotal()); // Display final total
                    break;
                case 2:
                    list.Newchar();
                    break;
                case 3:
                    list.deleteChar();
                    break;
                case 4:
                    list.editChar();
                    break;
                case 5:
                    list.charList();
                    break;
                case 6:
                    notes.editOrNew();
                    break;
                case 7:
                    System.out.println("Thank you for using the Dice and Dungeons program!");
                    scanner.close(); // Close scanner before exiting
                    return; // Exit program properly
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 7.");
            }
        }
    }
}
