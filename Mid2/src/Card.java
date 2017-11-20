
public class Card {
	private String suit;
	private String name;
	
	public Card(){}
	public Card(String suit, String name){
		if(suit.equals("Clubs")||suit.equals("Diamonds")||suit.equals("Hearts")||suit.equals("Spades"))
			this.suit = suit;
		if(name.equals("Ace")||name.equals("Jack")||name.equals("Queen")||name.equals("King")||name.equals("Joker")||
				name.equals("1")||name.equals("2")||name.equals("3")||name.equals("4")||name.equals("5")||name.equals("6")||
				name.equals("7")||name.equals("8")||name.equals("9")||name.equals("10"))
			this.name = name;
		else{
			System.out.println("Improper Input");
			System.exit(0);
		}
	}
	public String getSuit(){
		return this.suit;
	}
	public String getName(){
		return this.name;
	}
}
