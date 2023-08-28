public class SlotMachine {

    public void initGame() {
        Local.slotMachineDecor();
        System.out.println("1. Start " + Local.RED + "\uD83C\uDD5E5$" + Local.RESET + "!\n2. Info\n3. Back");
        switch (Local.tryBlock("Choose an action", 1, 3)) {
            case 1 -> startGame();
            case 2 -> infoGame();
            case 3 -> new MenuStructure().selectGame();
            default -> Local.notify(3);
        }
    }

    private void startGame() {
        Main.players[0].editCountChips(Main.players[0], 1, 1, '-');
        System.out.println("Attention! Machine is started! Good luck!");
        Local.slotsDecor();
        Local.trySleep(500);
        int slotA = 0, slotB = 0, slotC = 0;
        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.random() * 7 + 1);
            if (random == 1) System.out.print("[ \uD83D\uDC51 ] "); // [ 👑 ]
            else if (random == 2) System.out.print("[ \uD83C\uDF52 ] "); // [ 🍒 ]
            else if (random == 3) System.out.print("[ \uD83C\uDFC6 ] "); // [ 🏆 ]
            else if (random == 4) System.out.print("[ \uD83C\uDF40 ] "); // [ 🍀 ]
            else if (random == 5) System.out.print("[ \uD83D\uDCB0 ] "); // [ 💰 ]
            else if (random == 6) System.out.print("[ \uD83D\uDC8E ] "); // [ 💎 ]
            else if (random == 7) System.out.printf("[ %s7%s ] ", Local.RED, Local.RESET); // [ 7 ]
            else Local.notify(3);
            if (i == 0) slotA = random;
            else if (i == 1) slotB = random;
            else slotC = random;
            Local.trySleep(1500);
        }
        System.out.println();
        Local.slotsDecor();
        if (slotsEquals(slotA, slotB, slotC)) {
            if (slotA == 4 && slotB == 4 && slotC == 4) { // Additional condition for a particular slot:
                System.out.printf("[%s\uD83C\uDD5E5000$%s] Super combination \uD83C\uDF40x3! " +
                        "You get multiple %s wins%s!\n",
                        Local.GREEN, Local.RESET, Local.GREEN, Local.RESET);
                Main.players[0].editCountChips(Main.players[0], 5, 1, '+');
            } else {
                System.out.printf("[%s\uD83C\uDD5E500$%s] Three slots matched and you%s win%s!\n",
                        Local.PURPLE, Local.RESET, Local.GREEN, Local.RESET);
                Main.players[0].editCountChips(Main.players[0], 4, 1, '+');
            }
        } else System.out.println("It's not a big deal! Better luck next time!");
        repeatOperation();
    }

    private boolean slotsEquals(int slotA, int slotB, int slotC) { return slotA == slotB && slotB == slotC; }

    private void repeatOperation() {
        System.out.println("Your chip balance: " + Main.players[0].getChipBalance().replace(",", " |"));
        System.out.println("Repeat game?\n1. Yes, spin more!\n2. No, go back...");
        switch (Local.tryBlock("Choose an action", 1, 2)) {
            case 1 -> startGame();
            case 2 -> initGame();
            default -> Local.notify(3);
        }
    }

    private void infoGame() {
        Local.streaksDecor();
        System.out.println("Each spin of a slot machine costs one " + Local.RED + "\uD83C\uDD5E5$" + Local.RESET +
                ". \nTo win, all three slots must match, \nand if three clovers fall out, the value is multiplied.");
        initGame();
    }
}
