package com;
import com.card.deal.Deck;
import java.util.List;
public class Game {
	public static void main(String[] args){

		Deck deck = new Deck();
		List<Integer> newDeck = deck.getDeck();
		System.out.printf("Deck", newDeck);
		
	}
}
