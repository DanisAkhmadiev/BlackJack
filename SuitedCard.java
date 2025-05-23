
public class SuitedCard extends CardSuperItem
{	
	public SuitedCard(int value, String cardName, String suit) {
		super(value, cardName, suit);
	}

	@Override
	public int applyCardEffect() {
		// TODO Auto-generated method stub
		System.out.println("You drew "+ articleapplyCardEffect() +" "+ getcardName()+" of " + getsuit());
		
		if (getcardName().equals("Jack")) {
			System.out.println("Ooh a Jack! Your total has been halved!");
			return -99;
		}
		
		else if (getcardName().equals("King")) {
			System.out.println("Yikes, a King! The value of the next card will be doubled!");
			return -98;
		}
		
		else if (getcardName().equals("Queen")) {
			System.out.println("Oh no a Queen! Your total has been doubled!");
			return -97;
		}
		
		else if (getsuit().equals("Spades")|| getsuit().equals("Clubs")) {
			return getvalue();
		}
		else {
			System.out.println("Awesome, it was a red card so half that value gets deducted!");
			return -(getvalue()/2);
		}
		
		
	}

	@Override
	public void printCardDetails() {
		// TODO Auto-generated method stub
		System.out.println(articlePrintCardDetails() +" "+ getcardName()+" of "+getsuit());
	}
	
	// method to know which article should program use for printCardDetails
	private String articlePrintCardDetails() {
		if (getcardName().charAt(0)=='A' || getcardName().charAt(0)=='E') {
			return "An";
		}
		
		else {
			return "A";
		}
	}
	
	// method to know which article should program use for applyCardEffect
		private String articleapplyCardEffect() {
			if (getcardName().charAt(0)=='A' || getcardName().charAt(0)=='E') {
				return "an";
			}
			
			else {
				return "a";
			}
		}
}
