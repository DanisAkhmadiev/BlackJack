import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainClass
{
	//DO NOT CHANGE THIS ARRAYLIST! 
	public static ArrayList<CardSuperItem> drawDeck;
	//DO NOT CHANGE THIS ARRAYLIST!
	
	//YOU NEED TO ADD A NEW ARRAYLIST HERE TO REPRESENT THE CARDS IN A PLAYER'S HAND (see name from coursework)
	public static ArrayList<CardSuperItem> cardsInHand;
	
	public static void main(String[] args) 
	{
		// Creating local variables 
		Scanner scan = new Scanner(System.in);
		int currentHandTotal = 0;
		CardSuperItem drawnCard;
		Random random = new Random();
		boolean king = false; // flag variable to check was the previous card King 
		
		drawDeck = new ArrayList<CardSuperItem>();
		cardsInHand = new ArrayList<CardSuperItem>();
		
		System.out.println("Welcome to Weird Blackjack! Your aim is to draw as many cards as you can, without going over a value of 21!");
		System.out.println("Select which you want to play with:\n1. Number Cards Only\n2. Include Face Cards");
		//choosing game mode
		int modeInput = scan.nextInt();
		
		if (modeInput == 1) {
			createDeckOfCards(); 
		}
		
		else if (modeInput == 2) {
			createDeckOfCards(4); 
			
		}
		else {
			System.out.println("Invalid Input! Try again");
			scan.close();
			return;
		}
		
		//main while loop for the game
		while (currentHandTotal < 21){
			
			//drawing new card
			int randomCard = random.nextInt(drawDeck.size());
			drawnCard = drawDeck.get(randomCard);
			drawDeck.remove(randomCard);
			cardsInHand.add(drawnCard);
			
			int effect = drawnCard.applyCardEffect();
			
			//if card is Jack
			if (effect == - 99) { 
				currentHandTotal /=2;
				king = false; //in case if previous card was king, next card will ignore the king effect
			}
			
			//if card is queen
			else if (effect == - 97) {
				currentHandTotal *= 2;
				king = false; //in case if previous card was king, next card will ignore the king effect
			}
			
			//if card is king
			else if (effect == -98) {
				king = true; 				
			}
			
			//if numbered card
			else {
				//checking if the previous card was king
				if (king) {
					effect *= 2;
					king = false;
				}
				
			currentHandTotal += effect;
			
			}
			
			//breaks while, if the total > 21
			if (currentHandTotal >= 21) {
				break;
			}
			
			
			
			System.out.println("You are still in this! You have "+ cardsInHand.size() +" "+cardNumber()+" in hand, and a total of "+ currentHandTotal +".\n"
					+ "Do you want to draw again? Yes or No ");
			
			
			String userInput = scan.next();
			
			if (userInput.equalsIgnoreCase("Yes")) { 
				System.out.println("Okay, drawing a new card:");
				continue;
			}
			
			else if (userInput.equalsIgnoreCase("No")) {
				break;
			}
			
			
		}
		
		
		if (currentHandTotal == 21) {
			System.out.println("Blackjack! You got exactly 21, well done!\n"
					+ "You drew "+ cardsInHand.size() +" cards before getting Blackjack. Well done!");
		}
		
		else if (currentHandTotal > 21) {
			System.out.println("Oh no! You've gone bust with a score of "+currentHandTotal+"!\n"
					+"You drew "+ cardsInHand.size() +" cards before losing. Better luck next time!");
		}
		
		else {
			System.out.println("Phew, you have stopped drawing cards!\n"
					+ "You drew "+ cardsInHand.size() +" "+cardNumber()+" and had a total of "+currentHandTotal+" in hand!");
		}
		
		
		for (int i = 0; i < cardsInHand.size(); i++) {
			cardsInHand.get(i).printCardDetails();
		}
		
		scan.close();
		
	}
	
	//methods for creating deck of cards for mode 1 
	private static void createDeckOfCards()
	{
		
		for (int i = 1; i <= 3; i++) {
			for (int index = 1; index <= 6; index++) {
				drawDeck.add(new NumberCard(index, CardsDetails.cardsNames[index-1]));
			}
		}
	}
	
	//methods for creating deck of cards for mode 2
	private static void createDeckOfCards(int numberOfSuits)  //default number of suits for 2nd mode is 4
	{
		int[] numberCards = {1,2,3,7,8,9};
		
		for (int i = 0; i < numberOfSuits; i++) {
			for (int cards : numberCards) {
				drawDeck.add(new SuitedCard(cards, CardsDetails.cardsNames[cards-1], CardsDetails.suitNames[i]));
			}
			
			for (int index = 10; index < 13; index++) {
				drawDeck.add(new SuitedCard(index+1, CardsDetails.cardsNames[index], CardsDetails.suitNames[i]));
			}
		}
	}
	
	// return cards if we have more than 1 card in hands otherwise card 
	private static String cardNumber() {
		if (cardsInHand.size() ==1) {
			return "card";
		}
		else
			return "cards";
	}
	
}
