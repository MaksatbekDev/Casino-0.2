import java.util.Arrays;

public class Roulette {
    private int value;
    private String color;
    private String show;
    private int slotRow;
    private final Roulette[] allSlots = new Roulette[37];
    // Color constants for init board:
    private static final String COLOR_GREEN = "green";
    private static final String COLOR_BLACK = "black";
    private static final String COLOR_RED = "red";
    // Background + color text:
    private static final String COLOR_BG_GREEN = Local.GREEN_BACKGROUND + Local.WHITE;
    private static final String COLOR_BG_BLACK = Local.BLACK_BACKGROUND + Local.WHITE;
    private static final String COLOR_BG_RED = Local.RED_BACKGROUND + Local.WHITE;

    public Roulette(int value, String color, String show, int slotRow) {
        this.value = value;
        this.color = color;
        this.show = show;
        this.slotRow = slotRow;
    }

    public Roulette() {}

    public void initRouletteSlots() {
        // The zero slot is initialized immediately, so as not to write separate logic for it:
        allSlots[0] = new Roulette(0, COLOR_GREEN, COLOR_BG_GREEN + " 0 " + Local.RESET, 0);
        String color, show;
        int row = 1; // Identifies a row of slots on the board (1-3).
        for (int i = 1; i < allSlots.length; i++) { // Cycle-init board slots:
            color = getColorByIndex(i);
            show = getBackgroundColorByIndex(i) + " " + i + " " + Local.RESET;
            allSlots[i] = new Roulette(i, color, show, row);
            row = (i % 3) + 1; // Upon reaching the third number, resets the value to one.
        }
    }

    private String getColorByIndex(int index) { // Identifies a color of slots.
        // Due to the nature of the board, slot color is determined by parity and odd parity, but there are exceptions:
        if (index <= 10 && index % 2 == 0
                || index > 10 && index <= 18 && index % 2 != 0 // 10 and 11 are black,
                || index > 19 && index <= 28 && index % 2 == 0 // 18 and 19 are red,
                || index > 28 && index <= 36 && index % 2 != 0) { // 28 and 29 are black.
            return COLOR_BLACK;
        } else return COLOR_RED;
    }

    private String getBackgroundColorByIndex(int index) { // Returns the slot's background based on its color.
        return getColorByIndex(index).equals(COLOR_RED) ? COLOR_BG_RED : COLOR_BG_BLACK;
    }

    @Override
    public String toString() {
        return "{" +
                "val: " + value +
                ", color: " + color +
                ", show: "  + show +
                ", row: " + slotRow +
                ", board: " + Arrays.toString(allSlots) + "}\n";
    }
}
