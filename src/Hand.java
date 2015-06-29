import java.util.ArrayList;


public class Hand {
	private ArrayList<Card> cards = new ArrayList<Card>();
	
	public void add(Card card) {
		cards.add(card);
	}
	
	public int getValue() {
		int value = 0;
		ArrayList<Card> aces = new ArrayList<Card>();

		for (Card card : cards) {
			if (card.getFace() == Face.ACE) {
				aces.add(card);
			} else {
				value += card.getValue();
			}
		}
		
		for (int i = 0; i < aces.size(); i++) {
			if (i == aces.size() -1) {
				if (value + 11 <= 21) {
					value += 11;
				} else {
					value += 1;
				}
			} else {
				value += 1;
			}
		}
		
		return value;
	}
	
	public void show() {
		for (Card card : cards) {
			if (!card.isUp()) {
				card.turn();
			}
		}
	}
	
	public String getInfoString() {
		String info = "";
		
		for (Card card: cards) {
			info += " " + card.getAppearance();
		}
		
		info += " " + getVisibleHandValue();
		
		return info;
	}
	
	private String getVisibleHandValue() {
		boolean hasFaceDownCard = false;
		String output = " (hand value: ";
		
		for (Card card : cards) {
			hasFaceDownCard = hasFaceDownCard || !card.isUp();
		}
		
		if (!hasFaceDownCard) {
			output += getValue();
		} else {
			output += "?";
		}
		
		return output + ")";
	}
}
