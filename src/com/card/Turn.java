package com.card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Turn {
private List<Integer> mHandOne;
private List<Integer> mHandTwo;
private List<Integer> mDiscardPile;
private List<Integer> mDrawPile;
private BufferedReader mReader;
private Map<String, String> mMenu;
private List<Integer> hand;

public Turn(List<Integer> handOne, List<Integer> handTwo, List<Integer> discardPile, List<Integer> dealPile){
	mHandOne = handOne;
	mHandTwo = handTwo;
	mDiscardPile = discardPile;
	mDrawPile = dealPile;
	mReader = new BufferedReader(new InputStreamReader(System.in));
	mMenu = new HashMap<String, String>();
	mMenu.put("play", "Play a Card");
	mMenu.put("draw", "Draw a Card");
	mMenu.put("show", "Display Hand");
}
private String promptAction() throws IOException {
	System.out.println("You have two options: \"Play\" or \"Draw\" \n");
	for(Map.Entry<String, String> option : mMenu.entrySet()){
		System.out.printf("%s  %s \n", option.getKey(),option.getValue());
	}
	System.out.print("What do you want to do: ");
	String choice = mReader.readLine();
	return choice.trim().toLowerCase();
}
public void run() {
	String choice = "";
	boolean handOneTurn = true;
	do{
		if(handOneTurn == true){
			hand = mHandOne;
			System.out.println("It is Player One's Turn \n");
			System.out.println(mDiscardPile.get(0));
			handOneTurn = false;
		}
		else
		{
			hand = mHandTwo;
			System.out.println("It is Player Two's Turn \n");
			System.out.println(mDiscardPile.get(0));
			handOneTurn = true;
		}
	do{
		try{
			choice = promptAction();
			switch(choice){
			case "play":
				System.out.println("in play");
				playCard();
				break;
			case "draw":
				System.out.println("in draw");
				hand.add(mDrawPile.remove(0));
				break;
			case "show":
				System.out.printf("Your Hand is: %s: ", hand);
				break;
			default:
				System.out.printf("Unknown choice: '%s'. Try Again. \n\n\n", choice);
			}
		}catch(IOException ioe){
			System.out.println("Problem with input");
			ioe.printStackTrace();
		}
	}
		while(mHandOne.size() != 0 && mHandTwo.size() != 0 && !choice.equals("draw"));
	
}
while(mHandOne.size() != 0 && mHandTwo.size() != 0);
}
private List<Integer> playCard() throws IOException{
	System.out.print("Play a card: ");
	Integer card = Integer.valueOf(mReader.readLine());
	for(int i = 0; i < hand.size(); i++){
		if(hand.get(i) == card){
			if(card-1 == mDiscardPile.get(0) || card+1 == mDiscardPile.get(0)){
			mDiscardPile.add(0,hand.remove(i));
			}
			else{
				System.out.printf("The card %d does not go there", card);
				return hand;
			}
		}
	}
	return hand;
}
}