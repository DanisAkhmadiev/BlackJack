
public abstract class CardSuperItem
{
	
	//abstract class for subclasses for 1st and 2nd mode 
	
	//DO NOT CHANGE THESE ROWS!
	private int value;
	private String cardName;
	private String suit;
	//DO NOT CHANGE THESE ROWS!
	
	//constructor for 1st mode
	public CardSuperItem(int value, String cardName)
	{
		this.value = value;
		this.cardName = cardName;
	}
	
	//constructor for 2nd mode
	public CardSuperItem(int value, String cardName, String suit)
	{
		this.value = value;
		this.cardName = cardName;
		this.suit = suit;
	}
	
	
	//abstract methods to be overridden in subclasses
	public abstract int applyCardEffect();
	
	public abstract void printCardDetails();

	//Getters
	
	public int getvalue() {
		return value;
	}
		
	public String getcardName() {
		return cardName;
	}
	
	public String getsuit() {
		return suit;
	}
	
}
