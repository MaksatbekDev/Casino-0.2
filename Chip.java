public class Chip {
    private String label;
    private int count;
    private int nominal;

    public Chip(String label, int nominal, int count) {
        this.label = label;
        this.nominal = nominal;
        this.count = count;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    public void showChips(Chip[] chips) {
        for (int i = 0; i < chips.length; i++) {
            System.out.printf("%d. %s - %d\n", (i + 1), chips[i].label, chips[i].count);
        }
    }

    @Override
    public String toString() {
        return label + " - " + count;
    }
}
