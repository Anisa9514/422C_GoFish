package gofish_assn;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Represents the Go Fish Game
 * @author Angelique Bautista
 * @version 1.0
 */
public class GoFishGame{

	private Deck goFishDeck = new Deck();
	private ArrayList<Player> players = new ArrayList<Player>();
	private int curIdx = 0;	// determines turns (index of current player in turn)
	private int othIdx = 1; // determines turns (index of other player in turn )
	File oFile = new File("go_fish_output.txt");
	PrintWriter output;

	/**
	 * Creates a Go Fish Game assuming 2 players
	 * Outputs each move to an external file called go_fish_output.txt
	 */
	public GoFishGame() throws FileNotFoundException {

		output = new PrintWriter(oFile);
		init();

		while(!((goFishDeck.deckSize() == 0) && 
				(players.get(0).getHandSize() == 0) &&
				(players.get(1).getHandSize() == 0)
		)){
			Player curPlayer = players.get(curIdx);
			Player otherPlayer = players.get(othIdx);	

			output.println("");
			output.println(curPlayer.getName() + "'s turn.");
			if(curPlayer.getHandSize() == 0){
				output.println(curPlayer.getName() + " has no cards left in hand.");
				drawCard(curPlayer);
				swapPlayers();
				continue;
			}
			else{
				Card cardFromHand = curPlayer.chooseCardFromHand();
				int rankFromHand = cardFromHand.getRank();
				output.println(curPlayer.getName() + ": " + otherPlayer.getName() 
				+ ", do you have a " + cardFromHand.rankToString(rankFromHand) 
				+ "?");

				if(otherPlayer.rankInHand(cardFromHand)){
					output.println(otherPlayer.getName() + ": Yes, I have a " + cardFromHand.rankToString(rankFromHand));
					Card c = new Card(otherPlayer.findCardInHand(cardFromHand.getRank()));
					otherPlayer.removeCardFromHand(c);
					curPlayer.addCardToHand(c);
					curPlayer.checkHandForBook();
					output.println(curPlayer.getName() + " books the " + c.rankToString(rankFromHand));

					if(otherPlayer.getHandSize() == 0){
						output.println(otherPlayer.getName() + " has no cards left in hand.");
						drawCard(otherPlayer);
					}
					
					if(curPlayer.getHandSize() == 0){
						output.println(curPlayer.getName() + " has no cards left in hand.");
						if(!drawCard(curPlayer)){
							swapPlayers();
							continue;
						}
					}

					continue;
				}
				else{
					output.println(otherPlayer.getName() + ": Go Fish");
					drawCard(curPlayer);
					swapPlayers();
					continue;
				}
			}
		}

		// Both players check remaining hand for books
		output.println("");
		output.println("DECK HAS RUN OUT OF CARDS!");
		printHands();
		while(players.get(0).checkHandForBook()){};
		while(players.get(1).checkHandForBook()){};
		
		output.println("");
		output.println("==============================================");		
		output.println("GAME OVER!!!");
		output.println("==============================================");
		output.println("");
		printBooks();

		if(players.get(0).getBookSize() > players.get(1).getBookSize()){
			output.println(players.get(0).getName() + " WINS!!!");		
		}
		else if(players.get(0).getBookSize() < players.get(1).getBookSize()) {
			output.println(players.get(1).getName() + " WINS!!!");
		} 
		else {
			output.println("IT'S A TIE!!!");
		}
		output.close();
	}


	/**
	 * Initializes Go Fish Game
	 */
	private void init(){
		// Initialize players
		Player player1 = new Player("Anisa");
		Player player2 = new Player("Izzy");
		players.add(player1);
		players.add(player2);

		// Shuffle deck
		goFishDeck.shuffle();

		output.println("Go Fish Game starts. Deck is shuffled. Players draw cards:");
		output.println("");
		// Deal out cards
		for(int i = 0; i < players.size(); i++){
			for(int k = 0; k < 7; k++){ 
				// Draw card
				drawCard(players.get(i));
			}
			
			output.println("");
			output.println(players.get(i).getName() + " currently has " + players.get(i).getBookSize() 
			+ " books:");
			output.println(players.get(i).bookToString());
			output.println("-------------------------------------");
		}
	}

	/**
	 * Deals a card from the deck to the player
	 * @return true if card was drawn successfully; false if deck is empty
	 */
	private boolean drawCard(Player player){
		if(goFishDeck.deckSize() == 0){return false;}

		Card c = new Card(goFishDeck.dealCard());
		player.addCardToHand(c);
		output.println(player.getName() + " draws " + c.toString());
		if(player.checkHandForBook()){
			output.println(player.getName() + " books the " + c.rankToString(c.getRank()));
			if(player.getHandSize() == 0){
				output.println(player.getName() + " has no cards left in hand.");				
				if(!drawCard(player)){return false;}
			}
		};

		return true;
	}

	/**
	 * Swaps players in the game; assumes a 2 player game
	 */
	private void swapPlayers(){
		curIdx = (curIdx == 0) ? 1 : 0;
		othIdx = (othIdx == 0) ? 1 : 0;
	}

	/**
	 * Prints hands for both players
	 * For debugging purposes
	 */
	private void printHands(){
		output.println(players.get(0).getName().toUpperCase() + "'S HAND");
		output.println(players.get(0).handToString());

		output.println(players.get(1).getName().toUpperCase() + "'S HAND");
		output.println(players.get(1).handToString());

	}

	/**
	 * Prints books for both players
	 * For debugging purposes
	 */
	private void printBooks(){
		output.println(players.get(0).getName().toUpperCase() + "'S BOOK(S)");
		output.println(players.get(0).getBookSize() + " books total");
		output.println(players.get(0).bookToString());

		output.println(players.get(1).getName().toUpperCase() + "'S BOOK(S)");
		output.println(players.get(1).getBookSize() + " books total");
		output.println(players.get(1).bookToString());
	}
}
