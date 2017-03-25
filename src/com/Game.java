package com;
import com.card.deal.Deal;
import com.card.deal.Deck;
import com.card.Turn;
import java.util.ArrayList;
import java.util.List;
public class Game {
	public static void main(String[] args){

		Deck deck = new Deck();
		List<Integer> thisDeck = deck.getDeck();
		System.out.println(thisDeck);
		Deal deal = new Deal(thisDeck);

		Turn turn = new Turn(deal.handOne(), deal.handTwo(), deal.discardPile(), deal.drawPile());
		turn.run();
}
}