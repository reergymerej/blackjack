
public class Game {
	private Deck deck;
	private boolean gameOver;
	private Player dealer;
	private Player player;
	
	public void start() {
		dealer = new Player("dealer");
		player = new Player("player 1");
		
		gameOver = false;
		deck = new Deck();
		
//		TODO: game loop
		if (!gameOver) {
			deal(dealer, 2);
			deal(player, 2);
			
			dealer.debug();
			player.debug();
		}
	}
	
	private void deal(Player player, int count) {
		for (int i = 0; i < count; i++) {
			player.giveCard(deck.getCard());
		}
	}
}
