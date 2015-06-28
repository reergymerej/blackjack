
public class Card {
	private Suit suit;
	private int value;
	private Face face;
	
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
		Face face = getFace();
		if (face == null) {
			System.out.println(getValue() + " " + getSuit());
		} else {
			System.out.println(face + " " + getSuit());
		}
	}
}
