import java.util.ArrayList;

public class Deck {
	ArrayList<Card> deck = new ArrayList<>();
	public Deck(){
		String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
		String[] names = {"Ace","1","2","3","4","5","6","7","8","9","10","Jack","Queen","King","Joker"};
		for(String suit:suits)
			for(String name:names){
				System.out.println("Added "+name+" of "+suit+" to the deck!");
				deck.add(new Card(suit, name));
			}
	}
	public void shuffle(){
		
	}
	
}
