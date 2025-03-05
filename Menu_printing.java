public class Menu_printing {
    private boolean isFirstPrint = true; // Flag to check if it's the first time printing

    public void printMenu() {
        if (isFirstPrint) {
            // ASCII Art to be printed only the first time
            System.out.println("     _____                                                                                               _____");
            System.out.println("  __|__   |__  __   _  ____   _  ______  ______  _____  ____   _  ______   ____    ____   _  _____    __|__   |__  _____   ____    ______  _____  ____   _  ______  ");
            System.out.println(" |     \\     ||  | | ||    \\ | ||   ___||   ___|/     \\|    \\ | ||   ___| |    \\  |    \\ | ||     \\  |     \\     ||     | |    \\  |   ___|/     \\|    \\ | ||   ___| ");
            System.out.println(" |      \\    ||  |_| ||     \\| ||   |  ||   ___||     ||     \\| | `-.`-.  |     \\ |     \\| ||      \\ |      \\    ||     \\ |     \\ |   |  ||     ||     \\| | `-.`-.  ");
            System.out.println(" |______/  __||______||__/\\____||______||______|\\_____/|__/\\____||______| |__|\\__\\|__/\\____||______/ |______/  __||__|\\__\\|__|\\__\\|______|\\_____/|__/\\____||______| ");
            System.out.println("    |_____|                                                                                             |_____|");
            System.out.println();
            isFirstPrint = false; // Set the flag to false so this only prints once
        }

        // Regular menu options
        System.out.println("===============================================================-");
        System.out.println("Welcome to the Dice and Dungeons program! How can I help you?");
        System.out.println("[1] 🎲 Roll Dice");
        System.out.println("[2] 📝 Create Character");
        System.out.println("[3] ❌ Delete Character");
        System.out.println("[4] ✏️ Edit Character");
        System.out.println("[5] 📜 View Character List");
        System.out.println("[6] 📖 DM Notes");
        System.out.println("[7] 🚪 Exit");
        System.out.println("===============================================================-");
    }
}