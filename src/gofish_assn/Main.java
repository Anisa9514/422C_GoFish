package gofish_assn;

import java.io.FileNotFoundException;

import gofish_assn.Card.Suits;

public class Main {
	
	public static void main(String args[]) {
		// System.out.println("Hello World!");
		
		// Test cards
		// Card c = new Card();
		// Card c2 = new Card(4,'d');
		// Card c3 = new Card(5, Suits.SPADE);
		// Card c4 = new Card(c3);

		// System.out.println(c.toString());
		// System.out.println(c2.toString());
		// System.out.println(c3.toString());
		// System.out.println(c4.toString());
			
		// Test deck
		// Deck d = new Deck();
		// System.out.println("INITIALIZED DECK!!!");		
		// d.printDeck();
		// d.shuffle();
		// System.out.println("SHUFFLED DECK!!!!");		
		// d.printDeck();
		// Card c0 = new Card(d.dealCard());
		// System.out.println(c0.toString());
		// d.printDeck();
		
		// Test player
		// Player p1 = new Player("Jane");
		// System.out.println(p1.getName());
		// p1.addCardToHand(c0);
		// System.out.println(p1.handToString());
		// p1.removeCardFromHand(c0);
		// System.out.println(p1.handToString());
		// p1.addCardToHand(c);
		// p1.addCardToHand(c2);
		// p1.addCardToHand(c3);
		// System.out.println(p1.handToString());		
			
		// Test Game
		try{GoFishGame game = new GoFishGame();}
		catch(FileNotFoundException e){System.out.println("File not found: " + e);}

	}

}
