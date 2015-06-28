import java.util.ArrayList;


public class Player {
	private ArrayList<Card> cards = new ArrayList<Card>();
	private String name;
	
	public Player(String name) {
		this.name = name;
	}
	
	public void debug() {
		System.out.println(this.name);
		
		for (int i = 0; i < cards.size(); i++){
			cards.get(i).debug();
		}
	}
	
	public void giveCard(Card card){
		this.cards.add(card);
	}
}
