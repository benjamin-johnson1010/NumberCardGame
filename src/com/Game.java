package com;
import com.card.deal.Deal;
import com.card.deal.Deck;
import java.util.ArrayList;
import java.util.List;
public class Game {
	public static void main(String[] args){

		Deck deck = new Deck();
		List<Integer> thisDeck = deck.getDeck();
		System.out.println(thisDeck);
		Deal deal = new Deal(thisDeck);
		System.out.println(deal.handOne());
		System.out.println(deal.handTwo());
		System.out.println(deal.discardPile());
		System.out.print(deal.drawPile());
}
}