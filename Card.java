public class Card {
    private String suit;
    private String rank;
    private Card[] deck;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Card[] getDeck() { // Forming and return deck of cards:
        String[] ranks = {"♥", "♣", "♦", "♠"};
        String[] suits = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        deck = new Card[54];
        int index = 0;
        for (String suit : suits) {
            for (String rank : ranks) {
                if (index % 2 == 0) deck[index] = new Card(
                        Local.RED + rank + Local.RESET,
                        Local.RED + suit + Local.RESET);
                else deck[index] = new Card(rank, suit);
                index++;
            }
        }
        // Add jokers:
        deck[index] = new Card("", Local.RED + "Jk" + Local.RESET);
        index++;
        deck[index] = new Card("", "Jk");
        return deck;
    }

    public void setDeck(Card[] deck) {
        this.deck = deck;
    }

    @Override
    public String toString() {
        return suit + rank;
    }
}
