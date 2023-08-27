public class Main {
    public static Player[] players = new Player[9];

    public static void main(String[] args) {
        // Initialization players:
        for (int i = 0; i < 9; i++) {
            String playerName = "Player " + (i + 1);
            Chip[] chips = createInitialChips();
            players[i] = new Player(playerName, chips);
        }

        players[0].editCountChips(players[0], 1, 10, '+');
        new MenuStructure().mainManu();
    }

    public static Chip[] createInitialChips() { // Start set of chips for players:
        return new Chip[]{
                new Chip(Local.RED + "\uD83C\uDD5E5$" + Local.RESET, 5, 0),
                new Chip(Local.BLUE + "\uD83C\uDD5E25$" + Local.RESET, 25, 0),
                new Chip(Local.BLACK + "\uD83C\uDD5E100$" + Local.RESET, 100, 0),
                new Chip(Local.PURPLE + "\uD83C\uDD5E500$" + Local.RESET, 500, 0),
                new Chip(Local.GREEN + "\uD83C\uDD5E5000$" + Local.RESET, 5000, 0)
        };
    }
}
