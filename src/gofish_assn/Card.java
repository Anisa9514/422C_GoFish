package gofish_assn;

/**
 * Represents a card in a simple deck; 
 * @author Angelique Bautista
 * @version 1.0
 */
public class Card {
	
	public enum Suits {CLUB, DIAMOND, HEART, SPADE};
	
	final static int TOP_RANK = 13; //King
	final static int LOW_RANK = 1; //Ace
	
	private int rank;  //1 is an Ace
	private Suits suit;
	
	/**
	 * Creates a new card in the deck
	 * Defaults to Ace of Clubs
	 */
	public Card() {
		rank = 1;
		suit = Suits.CLUB;
	}
	
	/**
	 * Creates a new card in the deck
	 * @param r	rank/value of card as an integer
	 * @param s 1st letter of the card suit (c,d,h,s)-using other letters may cause unexpected behavior
	 */
	public Card(int r, char s) {
		rank = r;
		suit = this.charToSuit(Character.toUpperCase(s));

	}
	
	/**
	 * Creates a new card in the deck
	 * @param r rank/value of card as an integer
	 * @param s card suit (inputted as: Card.Suits.CLUB/DIAMOND/HEART/SPADE)
	 */
	public Card(int r, Suits s) {
		rank = r;
		suit = s;
	}

	/**
	 * Copies a card
	 * @param c card
	 */
	public Card(Card c) {
		rank = c.getRank();
		suit = c.getSuit();
	}
	
	/**
	 * Convert suit character to Suits enum and returns the Suit
	 * @param c 1st letter of the card suit (c,d,h,s)-using other letters may cause unexpected behavior
	 * @return Card Suite
	 */
	// changed to charToSuit: makes intended implementation clearer
	private Suits charToSuit(char c) {	
		Suits resultSuit = Suits.CLUB;
		switch (Character.toUpperCase(c)){
			case 'C':	resultSuit = Suits.CLUB;break;
			case 'D':	resultSuit = Suits.DIAMOND; break;
			case 'H':	resultSuit = Suits.HEART; break;
			case 'S':	resultSuit = Suits.SPADE; break;
		}
		return resultSuit;
	}

	/**
	 * Convert suit enum to Suit character and returns the Suit as a string
	 * @param s Card Suit
	 * @return Card Suit as a string 
	 */	
	// converted to public function for GoFishGame class to output to file	
	public String suitToString(Suits s) {
		String result = "Club";
		switch(s){
			case CLUB: result = "Club"; break;
			case DIAMOND: result = "Diamond"; break;
			case HEART: result = "Heart"; break;
			case SPADE: result = "Spade"; break;
		}
		return result;
	}

	/**
	 * Convert rank/value of card to string
	 * @param r rank/value of card as an integer
	 * @return rank/value of card as a String
	 */		
	// converted to public function for GoFishGame class to output to file
	public String rankToString(int r){
		String result = "";
		switch(r){
			case 1: result = "Ace"; break;
			case 11: result = "Jack"; break;
			case 12: result = "Queen"; break;
			case 13: result = "King"; break;
			default: result = "" + r;
		}
		return result; 
	}
		
	/**
	 * Returns rank/value of card as an integer
	 * @return rank/value of card as integer
	 */
	public int getRank() {
		return rank;
	}
	
	/**
	 * Returns suit of card as Suits enum
	 * @return returns as Suit enum
	 */
	public Suits getSuit() {
		return suit;
	}
	
	/**
	 * Returns value and suit of card as String
	 * @return rank of Suit
	 */
	public String toString() {
		String s = "";
		
		s = s + rankToString(getRank()) + " of " + suitToString(getSuit()) + "s";
		
		return s;
	}

	/**
	 * Determines if card is equal to another card
	 * @param c card to compare
	 * @return true if card is the same; false if card is different
	 */
	public boolean isEqualTo(Card c){
		boolean sameRank, sameSuit;
		sameRank = rank == c.getRank();
		sameSuit = suit == c.getSuit();

		return sameRank && sameSuit;
	}

	/**
	 * Determines if card has the same rank as another card
	 * @param c card to compare
	 * @return true if card has same rank; false otherwise
	 */
	public boolean isSameRank(Card c){
		return rank == c.getRank();
	}

}
