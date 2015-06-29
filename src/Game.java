import java.io.Console;


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
		
		System.out.println("Black Jack!\n-------------------");
		
//		TODO: game loop
		if (!gameOver) {
			deal(dealer, 2);
			deal(player, 2);
			
//			TODO: Get card or stay?
			while (playerCanMove(player)) {
				String playerMove = getPlayerMove();
				System.out.println("player move: " + playerMove);
			}
		}
	}
	
	private void deal(Player player, int count) {
		Card card;
		for (int i = 0; i < count; i++) {
			card = deck.getCard();
			if (count > 1 && i > 0 || count == 1) {
				card.turn();
			}
			player.giveCard(card);
		}
	}
	
	private String getPlayerMove() {
		String input = null;
		
		do {
			System.out.println("-------------");
			showStatus();
			System.out.println("(h)it or (s)tay?");
			Console console = System.console();
			input = (String) console.readLine();
		} while (!input.equals("h") && !input.equals("s"));

		return input;
	}
	
	private void showStatus() {
		dealer.showStatus();
		player.showStatus();
	}
	
	private boolean playerCanMove(Player player) {
		boolean canMove = true;
		
		
		
		return canMove;
	}
}
