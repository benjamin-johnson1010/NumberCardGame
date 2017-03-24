package com.card.deal;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Deal {
	private List<Integer> mDeck;
	private List<Integer> mHandOne;
	private List<Integer> mHandTwo;
	private List<Integer> mDiscard;
	public Deal(List<Integer> deck){
		mDeck = deck;
	}
	public List<Integer> handOne(){
		mHandOne = new ArrayList<Integer> (mDeck.subList(0, 5));
		
		return mHandOne;
	}
	public List<Integer> handTwo(){
		mHandTwo = new ArrayList<Integer> (mDeck.subList(5, 10));
		
		return mHandTwo;
	}
	public List<Integer> discardPile(){
		mHandTwo = new ArrayList<Integer> (mDeck.subList(10, 11));
		return mDiscard;
	}
	public List<Integer> drawPile(){
		for(int i = 10; i >= 0; i--){
			mDeck.remove(i);
		}
		return mDeck;
	}
}
