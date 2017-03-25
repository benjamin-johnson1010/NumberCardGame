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
private List<Integer> mHandDiscardPile;
private List<Integer> mHandDealPile;
private BufferedReader mReader;
private Map<String, String> mMenu;

public Turn(List<Integer> handOne, List<Integer> handTwo, List<Integer> discardPile, List<Integer> dealPile){
	mHandOne = handOne;
	mHandTwo = handTwo;
	mHandDiscardPile = discardPile;
	mHandDealPile = dealPile;
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
	List<Integer> hand;
	do{
		if(handOneTurn == true){
			hand = mHandOne;
			System.out.println("It is Player One's Turn \n");
			handOneTurn = false;
		}
		else
		{
			hand = mHandTwo;
			System.out.println("It is Player Two's Turn \n");
			handOneTurn = true;
		}
	do{
		try{
			choice = promptAction();
			switch(choice){
			case "play":
				System.out.println("in play");
				break;
			case "draw":
				System.out.println("in draw");
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
}