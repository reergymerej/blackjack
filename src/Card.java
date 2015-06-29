
public class Card {
	private Suit suit;
	private int value;
	private Face face;
	private boolean up = false;
	
	public Card(Suit suit, int value, Face face) {
		this.suit = suit;
		this.value = value;
		this.face = face;
	}
	
	public Suit getSuit() {
		return this.suit;
	}
	
	public Face getFace() {
		return this.face;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void debug() {
		System.out.println(getAppearance());
	}
	
	public String getAppearance() {
		Face face = getFace();
		String status;
		
		if (!isUp()) {
			status = "?";
		} else {
			if (face == null) {
				status = getValue() + " " + getSuit();
			} else {
				status = face + " " + getSuit();
			}
		}
		
		return "[" + status + "]";
	}
	
	public void turn() {
		up = true;
	}
	
	public boolean isUp() {
		return up;
	}
}
