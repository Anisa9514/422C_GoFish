package gofish_assn;

import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a player in GoFish
 * @author Angelique Bautista
 * @version 1.0
 */
public class Player {
	
	private ArrayList<Card> hand = new ArrayList<Card>();
	private ArrayList<Card> book = new ArrayList<Card>(); // pairs: [0,1],[2,3],etc...
	private String name;
	
	/**
	 * Creates a new player in the game
	 * @param name player's name
	 */
	public Player(String name) {
		this.name = name;
	}
	
	/**
	 * Adds a card to the player's hand
	 * @param c card added 
	 */
	public void addCardToHand(Card c) {
		hand.add(c);
	}
	
	/**
	 * Removes a card from hand
	 * @param c card to be removed; 
	 * @return card that was removed; null if card is not in hand
	 */
	public Card removeCardFromHand(Card c) {
		if(!cardInHand(c)){return null;}

		Card retCard = new Card(c);
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).isEqualTo(c)){
				hand.remove(i);
			}
		}
		return retCard;
	}
	
	/**
	 * Returns player's name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns contents of hand as list
	 * @return string listing out cards in hand 
	 */
	public String handToString() {
		String s = new String();
		for(int i = 0; i < hand.size(); i++){
			s = s + hand.get(i).toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Return books as a list of pairs
	 * @return books in hand
	 */
	public String bookToString() {
		String s = new String();
		for(int i = 0; i < book.size(); i = i + 2){
			s += book.get(i).toString();
			s += " and " + book.get(i + 1).toString() + "\n";
		}
		return s;
	}
	
	/**
	 * Return number cards in hand
	 * @return number of cards in hand
	 */
	public int getHandSize() {
		return hand.size();
	}
	
	/**
	 * Return number of books in hand
	 * @return number of books in hand (pairs of the same rank)
	 */
	public int getBookSize() {
		return book.size()/2;
	}
	
	/**
	 * Check a player's hand for a pair
	 * If a pair is found, it moves the cards to the book and returns true
	 * @return true if a pair is found; false otherwise
	 */

    public boolean checkHandForBook() {
		
		for(int i = 0; i < hand.size(); i++){
			for(int k = 1 + i; k < hand.size(); k++){
				Card refCard = new Card(hand.get(i));
				Card compCard = new Card(hand.get(k));

				if(refCard.isSameRank(compCard)){
					book.add(refCard);
					book.add(compCard);
					hand.remove(k);
					hand.remove(i);
					return true;
				}
			}
		}
    	return false; //stubbed
    }

	/**
	 * Check for a rank in hand
	 * @param c card to check
	 * @return true if the same rank is found; false otherwise;
	 */
    public boolean rankInHand(Card c) {
		
		for(int i = 0; i  < hand.size(); i++){
			if(hand.get(i).isSameRank(c)){return true;}
		}
		return false; //stubbed
	}
	
	/**
	 * Find card in hand given rank
	 * @param rank rank of card 
	 * @return card with the rank; null if no card found
	 */
	public Card findCardInHand(int rank){
		
		for(int i = 0; i  < hand.size(); i++){
			if(hand.get(i).getRank() == rank){
				Card c = new Card(hand.get(i));
				return c;
			}
		}
		return null; //stubbed
	}
    
    //uses some strategy to choose one card from the player's
	//hand so they can say "Do you have a 4?"
	/**
	 * Chooses a random card from player's hand
	 * @return random card from hand
	 */
    public Card chooseCardFromHand() {
		Random rn = new Random();
		int randIndex = rn.nextInt(hand.size());
		Card c = new Card(hand.get(randIndex));

    	return c;
    }
    
    /**
	 * Indicates if card is in player's hand
	 * @param c card
	 * @return true if card is in hand/ false otherwise
	 */
    public boolean cardInHand(Card c) {
		for(int i = 0; i < hand.size(); i++){
			if(hand.get(i).isEqualTo(c)){return true;}
		}	
		return false; 
    }
}
