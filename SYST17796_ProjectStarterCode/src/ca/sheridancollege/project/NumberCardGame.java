import java.util.ArrayList;
import java.util.Collections;

public class NumberCardGame extends Game {
    private GroupOfCards deck;
    private ArrayList<NumberPlayer> players;

    public NumberCardGame(String name, int numPlayers) {
        super(name);
        deck = new GroupOfCards(52);
        players = new ArrayList<>();
        
        // Initialize players and deal cards
        for (int i = 0; i < numPlayers; i++) {
            GroupOfCards hand = new GroupOfCards(0);
            players.add(new NumberPlayer("Player " + (i + 1), hand));
        }
        
        initializeDeck();
    }

    private void initializeDeck() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                NumberCard card = new NumberCard(i);
                deck.getCards().add(card);
            }
        }
        deck.shuffle();
    }

    @Override
    public void play() {
        for (NumberPlayer player : players) {
            GroupOfCards hand = player.getHand();
            hand.getCards().add(deck.getCards().remove(0));
        }
        
        declareWinner();
    }

    @Override
    public void declareWinner() {
        int maxTotal = -1;
        NumberPlayer winner = null;

        for (NumberPlayer player : players) {
            int total = player.getHand().getCards().stream()
                    .mapToInt(card -> ((NumberCard) card).getNumber())
                    .sum();

            if (total > maxTotal) {
                maxTotal = total;
                winner = player;
            }
        }

        System.out.println("Winner: " + winner.getName() + " with total: " + maxTotal);
    }
}
