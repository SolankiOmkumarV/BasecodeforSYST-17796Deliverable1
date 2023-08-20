public class NumberCard extends Card {
    private int number;

    public NumberCard(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
