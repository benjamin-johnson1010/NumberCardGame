package com.card.deal;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
public class Deck {
	private List<Integer> mDeck;
	
	public Deck(){
		mDeck = new ArrayList<Integer>();
	}
	
	public List<Integer> getDeck(){
		for(int i=1; i < 11; i++){
			mDeck.add(i);
			mDeck.add(i);
		}
		Collections.shuffle(mDeck);
		return mDeck;	
}
}
