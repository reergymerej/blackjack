import java.util.ArrayList;


public class Player {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void debug() {
		String output = this.name + ": ";
		
//		for (int i = 0; i < cards.size(); i++){
//			cards.get(i).debug();
//		}
		
		output += getHandValue();
		System.out.println(output);
	}
	
	public void showStatus() {
		String output = this.name + ":";
		Card card;
		
		for (int i = 0; i < cards.size(); i++) {
			card = cards.get(i);
			output += " " + card.getAppearance();
		}
		
		output += getVisibleHandValue();
		
		System.out.println(output);
	}
	
	public void giveCard(Card card){
		this.cards.add(card);
	}
	
	public int getHandValue() {
		int value = 0;
		
		for (int i = 0; i < cards.size(); i++) {
			Card card = cards.get(i);
			value += card.getValue();
		}

		return value;
	}
	
	public boolean isBust() {
		return getHandValue() > 21;
	}
	
	public String getName() {
		return name;
	}
	
	public void showAllCards() {
		cards.get(0).turn();
	}
	
	private String getVisibleHandValue() {
		boolean hasFaceDownCard = false;
		String output = " (hand value: ";
		
		for (int i = 0; i < cards.size() && !hasFaceDownCard; i++) {
			hasFaceDownCard = hasFaceDownCard || !cards.get(i).isUp();
		}
		
		if (!hasFaceDownCard) {
			output += getHandValue();
		} else {
			output += "?";
		}
		
		return output + ")";
	}
}
