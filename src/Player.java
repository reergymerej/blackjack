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
}
