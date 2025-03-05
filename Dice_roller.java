import java.util.Scanner;

public class Dice_roller {
    public class Dice {
        private int numDice = 0;
        private int numSides = 0;
        private int total = 0;
        private static final Scanner scanner = new Scanner(System.in);

        // Ask for multiple dice rolls input (e.g., 5D6 + 3D4)
        public void askForInput() {
            System.out.print("Enter your dice roll (e.g., 5D6 + 3D4): ");
            String input = scanner.nextLine().replace(" ", ""); // Remove spaces for easier parsing
            
            String[] parts = input.split("\\+"); // Split by '+'
            for (String part : parts) {
                processDice(part); // Process each part (each dice roll or modifier)
            }
        }

        // Process each dice roll and modifier
        private void processDice(String part) {
            if (part.matches("\\d+D\\d+")) { // If it's a dice roll like 5D6
                String[] dice = part.split("D");
                int numDice = Integer.parseInt(dice[0]);
                int numSides = Integer.parseInt(dice[1]);

                rollDice(numDice, numSides); // Roll the dice
            } else {
                try {
                    int modifier = Integer.parseInt(part);
                    total += modifier; // If it's a modifier, just add it
                    System.out.println("Modifier: " + modifier);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, not a valid dice roll or modifier.");
                }
            }
        }

        // Roll the dice and print results
        public void rollDice(int numDice, int numSides) {
            int rollTotal = 0;
            for (int i = 0; i < numDice; i++) {
                int rollResult = (int) (Math.random() * numSides) + 1;
                System.out.println("\tDie " + (i + 1) + " rolled: " + rollResult);
                rollTotal += rollResult;
            }
            System.out.println("\tTotal for this roll: " + rollTotal);
            total += rollTotal; // Add to the total sum
        }

        // Return the total result
        public int getTotal() {
            return total;
        }
    }

    public static void main(String[] args) {
        Dice_roller diceRoller = new Dice_roller();
        Dice dice = diceRoller.new Dice();
        
        dice.askForInput();
        System.out.println("Final Total: " + dice.getTotal());
    }
}
