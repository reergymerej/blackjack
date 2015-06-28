
public class Game {
	private Deck deck;
	
	public Game(){
	}
	
	public void start() {
		deck = new Deck();
		deck.debug();
	}
}
