import java.util.Arrays;

public class Player {
    private String name;
    private Chip[] chipBalance;
    private Card[] cards; // Set of card for card games.

    public Player(String name, Chip[] chipBalance, Card[] cards) {
        this.name = name;
        this.chipBalance = chipBalance;
        this.cards = cards;
    }

    public Player(String name, Chip[] chipBalance) {
        this.name = name;
        this.chipBalance = chipBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChipBalance() {
        return Arrays.toString(chipBalance);
    }

    public void setChipBalance(Chip[] chipBalance) {
        this.chipBalance = chipBalance;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    // Editing count chip for players (unmonitored):
    public void editCountChips(Player player, int numberChip, int count, char value) {
        numberChip--; // Get chip index.
        int pastCount = chipBalance[numberChip].getCount();
        if (value == '+') chipBalance[numberChip].setCount(pastCount + count);
        else if (value == '-') {
            chipBalance[numberChip].setCount(pastCount - count);
            int counter = 0;
            for (Chip chip : chipBalance) if (player.chipBalance[numberChip].getCount() < 0) counter++;
            if (counter >= 4) {
                Local.notify(5);
                System.exit(0);
            }
        }
        else Local.notify(3);
    }
}
