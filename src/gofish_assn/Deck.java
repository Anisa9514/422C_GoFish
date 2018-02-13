package gofish_assn;

import java.util.ArrayList;
import gofish_assn.Card.Suits;
import java.util.Random;

/**
 * Represents a deck of cards
 * @author Angelique Bautista
 * @version 1.0
 */
public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card> ();
	final int NUM_CARDS = 52;  //for this kind of deck
	
	/**
	 * Creates a newly sorted deck
	 */
	public Deck() {

		Suits[] suitArr = {Suits.CLUB,Suits.DIAMOND,Suits.HEART,Suits.SPADE};

		for(int s = 0; s < 4; s++){
			Suits curSuit = suitArr[s];
			for(int i = Card.LOW_RANK; i <= Card.TOP_RANK; i++){
				Card c = new Card(i, curSuit);
				deck.add(c);
			}
		}

	}
	
	/**
	 * Shuffles cards in deck
	 */
	public void shuffle() {

		Random rn = new Random();
		int randIndex;

		for(int i = deck.size() - 1; i > 0; i--){
			// Pick random card in remaining deck to swap
			randIndex = rn.nextInt(i);
			Card curCard = new Card(deck.get(i));
			Card otherCard = new Card(deck.get(randIndex));

			// Swap cards
			deck.remove(i);
			deck.add(i, otherCard);
			deck.remove(randIndex);
			deck.add(randIndex, curCard);
		}	
	}
	
	/**
	 * Prints the deck in order to console
	 * For debugging purposes
	 */
	public void printDeck() {
		for(int i = 0; i < deck.size(); i++){
			System.out.println(deck.get(i).toString());
		}
	}
	
	/**
	 * Removes the last card in the deck
	 * @return last card in the deck
	 */
	public Card dealCard() {
		int lastElemIndex = deck.size() - 1; 
		Card c = new Card(deck.get(lastElemIndex)); 
		deck.remove(lastElemIndex);
		return c;
	}
	
	/**
	 * Gets the size of deck
	 * @return size of deck
	 */
	public int deckSize(){
		return deck.size();
	}
}
