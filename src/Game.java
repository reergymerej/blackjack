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
			showStatus();
			
			playerTurn();
			System.out.println("-------------");
			if (player.isBust()) {
				lose();
			} else {
				dealerTurn();
				System.out.println("-------------");
				
				determineWinner();
			}
		}
	}
	
	private void deal(Player player, int count) {
		Card card;
		for (int i = 0; i < count; i++) {
			card = deck.getCard();
			
			if (!(player == dealer && count > 1 && i == 0)) {
				card.turn();
			}
			player.giveCard(card);
		}
	}
	
	private Move getPlayerMove() {
		String input = null;
		Move move = null;
		
		do {
			showStatus(player);
			System.out.println("(h)it or (s)tay?");
			Console console = System.console();
			input = (String) console.readLine();
		} while (!input.equals("h") && !input.equals("s"));
		
		if (input.equals("h")) {
			move = Move.HIT;
		} else if (input.equals("s")) {
			move = Move.STAY;
		}

		return move;
	}
	
	private void showStatus() {
		dealer.showStatus();
		player.showStatus();
	}
	
	private void showStatus(Player player) {
		player.showStatus();
	}
		
	private void lose() {
		log("you lose");
	}
	
	private void win() {
		log("you win");
	}
	
	private void tie() {
		log("tie");
	}
	
	private void log(String msg) {
		System.out.println(msg + ": " + player.getHandValue());
	}
	
	private void playerTurn() {
		boolean playerWantsToMove = true;

		notifyPlayerTurn(player);
		
		while (!player.isBust() && playerWantsToMove) {
			Move playerMove = getPlayerMove();
			
			switch (playerMove) {
			case HIT:
				deal(player, 1);
				break;
			case STAY:
				playerWantsToMove = false;
				break;
			}
		}
	}
	
	private void dealerTurn() {
		int HIT_UNDER = 17;
		
		notifyPlayerTurn(dealer);
		
		dealer.showAllCards();
		showStatus(dealer);
		
		while (!dealer.isBust() && dealer.getHandValue() < HIT_UNDER) {
			System.out.println("hits");
			deal(dealer, 1);
			showStatus(dealer);
		}
	}
	
	private void notifyPlayerTurn(Player player) {
		System.out.println(player.getName() + "'s turn");
	}
	
	private void determineWinner() {
		int playerHandValue = player.getHandValue();
		int dealerHandValue = dealer.getHandValue();
		
		if (dealer.isBust() || playerHandValue > dealerHandValue) {
			win();
		} else if (playerHandValue == dealerHandValue) {
			tie();
		} else {
			lose();
		}
	}
}
