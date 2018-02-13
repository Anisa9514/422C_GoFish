package gofish_assn;

public class Main {
	
	public static void main(String args[]) {
		Player p1 = new Player("Anisa");
		Player p2 = new Player("Izzy");
		Deck cards = new Deck();

		// Call Game
		GoFishGame game = new GoFishGame(cards, p1, p2);
		game.executeGame();

	}

}
