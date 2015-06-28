import java.util.ArrayList;
import java.util.Collections;


public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck() {
		seedDeck(Suit.CLUB);
		seedDeck(Suit.DIAMOND);
		seedDeck(Suit.HEART);
		seedDeck(Suit.SPADE);
		shuffle();
	}
	
	private void seedDeck(Suit suit){
		for (int i = 1; i <= 10; i++) {
			switch (i) {
			case 1:
				cards.add(new Card(suit, i, Face.ACE));
				break;
			case 10:
				cards.add(new Card(suit, i, null));
				cards.add(new Card(suit, i, Face.JACK));
				cards.add(new Card(suit, i, Face.QUEEN));
				cards.add(new Card(suit, i, Face.KING));
				break;
			default:
				cards.add(new Card(suit, i, null));
			}
		}
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}

	public void debug() {
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).debug();
		}
	}
}
