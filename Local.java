public class Local { // Colors, notifications, decorations, other methods.

    // Colors block:
    public static final String RESET = "\u001B[0m", BLACK = "\u001B[30m", RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m", YELLOW = "\u001B[33m", BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m", CYAN = "\u001B[36m", WHITE = "\u001B[37m";
    public static final String BLACK_BACKGROUND = "\u001B[40m", RED_BACKGROUND = "\u001B[41m";
    public static final String GREEN_BACKGROUND = "\u001B[42m", YELLOW_BACKGROUND = "\u001B[43m";

    public static void notify(int status) {
        // Errors:
        if (status == 1) System.out.printf("%s[!] Incorrect value.%s\n", RED, RESET);
        else if (status == 2) System.out.printf("%s[!] Unknown error.%s\n", RED, RESET);
        else if (status == 3) System.out.printf("%s[!] System value error.%s\n", RED, RESET);
        // Notifications:
        else if (status == 4) System.out.printf("%s[i] The action has been successfully completed.%s\n", BLUE, RESET);
        else if (status == 5) System.out.printf("%s[i] You're out of chips.%s\n", BLUE, RESET);
        // Incorrect status:
        else System.out.println("[!] Non-existent status error code.");
    }

    public static void mainLogo() {
        System.out.printf("=%s=%s=%s=%s= %s•%s•%sLucky%sStreak%s•%s• %s=%s=%s=%s=%s=\n",
                RED, RESET, RED, RESET, RED, RESET, RED, RESET, RESET, RED, RESET, RED, RESET, RED, RESET);
    }

    public static int tryBlock(String text, int from, int to) {
        while (true) {
            try {

            }
        }
    }
}