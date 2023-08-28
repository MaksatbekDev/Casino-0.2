public class MenuStructure {

    public void mainManu() { // Main method for starting program.
        Local.mainMenuDecor();
        System.out.println("1. Start\n2. Options\n3. Exit");
        switch (Local.tryBlock("Choose an action", 1, 3)) {
            case 1 -> selectGame();
            case 2 -> System.out.println("Options");
            case 3 -> {
                Local.notify(6);
                System.exit(0);
            }
            default -> Local.notify(3);
        }
    }
    public void selectGame() {
        Local.selectGameDecor();
        System.out.println("1. Slot machine \uD83C\uDFB0\n2. Roulette\n3. Black Jack\n4. Poker\n5. Back");
        switch (Local.tryBlock("Choose an action", 1, 5)) {
            case 1 -> new SlotMachine().initGame();
            case 2 -> new Roulette().initRouletteSlots();
            case 3 -> System.out.println("Black Jack");
            case 4 -> System.out.println("Poker");
            case 5 -> mainManu();
            default -> Local.notify(3);
        }
    }
}
