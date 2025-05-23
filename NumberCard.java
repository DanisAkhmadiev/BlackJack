
public class NumberCard extends CardSuperItem
{
	
	public NumberCard(int value, String cardname) {
		super(value, cardname);
	}
	
	//overriding methods
	public int applyCardEffect() {
		System.out.println("You drew "+ articleApplyCardEffect() +" "+ getcardName());
		return getvalue();
	}
	
	public void printCardDetails() {
		System.out.println(articlePrintCardDetails() +" "+ getcardName());
	}
	
	// method to know which article should program use for applyCardEffect
	private String articleApplyCardEffect() {
		if (getcardName().charAt(0)=='A' || getcardName().charAt(0)=='E') {
			return "an";
		}
		
		else {
			return "a";
		}
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
}

