

public class Player {
	private String name;
	private Hand hand = new Hand();
	
	public Player(String name) {
		this.name = name;
	}
	
	public void debug() {
		String output = this.name + ": ";
				
		output += getHandValue();
		System.out.println(output);
	}
	
	public void showStatus() {
		String output = this.name + ":";
		output += hand.getInfoString();
		System.out.println(output);
	}
	
	public void giveCard(Card card){
		this.hand.add(card);
	}
	
	public int getHandValue() {
		return hand.getValue();
	}
	
	public boolean isBust() {
		return getHandValue() > 21;
	}
	
	public String getName() {
		return name;
	}
	
	public void showAllCards() {
		this.hand.show();
	}
}
