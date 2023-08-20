public class NumberPlayer extends Player {
    private GroupOfCards hand;

    public NumberPlayer(String name, GroupOfCards hand) {
        super(name);
        this.hand = hand;
    }

    public GroupOfCards getHand() {
        return hand;
    }

    @Override
    public void play() {
        // Implement player's turn logic here
    }
}
