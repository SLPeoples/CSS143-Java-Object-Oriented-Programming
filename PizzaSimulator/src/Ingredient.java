import java.awt.Color;

/**
 * @author Samuel L. Peoples
 * Ingrediate superclass
 */
public abstract class Ingredient implements Comparable<Ingredient>{
	private String description;
	private Money cost;
	private int calories;
	
	/**
	 * Ingredient noArg constructor
	 */
	public Ingredient(){
		this.setDescription("None");
		this.setCost(new Money(0,0));
		this.setCalories(0);
	}
	
	/**
	 * Ingredient constructor
	 * @param desc, String description
	 * @param cst, Money cost
	 * @param calrs, int calories
	 */
	public Ingredient(String desc, Money cst, int calrs){
		this.setDescription(desc);
		this.setCost(cst);
		this.setCalories(calrs);
	}
	
	/**
	 * Setter for description
	 * @param desc, String description
	 */
	private void setDescription(String desc){
		this.description = desc;
	}
	
	/**
	 * Setter for Cost
	 * @param cst, Money cost
	 */
	private void setCost(Money cst){
		this.cost = cst;
	}

	/**
	 * Setter for calories
	 * @param calrs, int calories
	 */
	private void setCalories(int calrs){
		this.calories = calrs;
	}
	
	/**
	 * getter for description
	 * @return this description
	 */
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * getter for cost
	 * @return this cost
	 */
	public Money getCost(){
		return this.cost;
	}
	
	/**
	 * getter for calories
	 * @return this calories
	 */
	public int getCalories(){
		return this.calories;
	}
	
	/**
	 * Overrides toString method
	 * @return description, cost, calories 
	 */
	public String toString(){
		return this.description+", "+this.cost+"; "+this.calories+" calories.";
	}

	/**
	 * Overrides equals method
	 * @return true if elements equal 
	 */
	public boolean equals(Ingredient other){
		if(this.getDescription().equals(other.getDescription())
				&&this.getCost().equals(other.getCost())
				&& this.getCalories() == other.getCalories())
			return true;
		else return false;
	}
	
	/**
	 * Overrides compareto method
	 * @return comparison of Money objects 
	 */
	@Override
	public int compareTo(Ingredient other) {
		return this.getCost().compareTo(other.getCost());
	}

	public static void main(String args[]){
		Ingredient[] ingredients = new Ingredient[15];
		ingredients[0] = new Meat();
		ingredients[0].setDescription("a");
		ingredients[0].setCost(new Money(10,25));
		ingredients[0].setCalories(25);
		ingredients[1] = new Meat("b",new Money(25,19), 65);
		ingredients[2]= new Base("c", new Money(10,10), 100);
		ingredients[3]= new Marinara("d", new Money(10,20), 200);
		ingredients[4]= new Alfredo("e", new Money(10,30), 300);
		ingredients[5]= new Cheese("f", new Money(10,40), 400);
		ingredients[6]= new Goat("g", new Money(10,50), 500);
		ingredients[7]= new Mozzarella("h", new Money(10,60), 600);
		ingredients[8]= new Meat("i", new Money(10,70), 700);
		ingredients[9]= new Sausage("j", new Money(10,80), 800);
		ingredients[10]= new Pepperoni("k", new Money(10,90), 900);
		ingredients[11]= new Vegetable("l", new Money(11,00), 1000, Color.BLUE);
		ingredients[12]= new Pepper("m", new Money(10,20), 1100, Color.RED);
		ingredients[13]= new Olive("n", new Money(10,30), 1200);
		ingredients[14]= new Olive("n", new Money(10,30), 1200);
		for(Ingredient ing:ingredients){
			System.out.println(ing.toString());
			System.out.println(ing.getDescription());
			System.out.println(ing.getCalories());
			System.out.println(ing.getCost());
		}
		System.out.println(ingredients[13].compareTo(ingredients[14])+" 0");
		System.out.println(ingredients[0].compareTo(ingredients[14])+" -1");
		System.out.println(ingredients[14].compareTo(ingredients[0])+" 1");
		System.out.println(ingredients[0].equals(ingredients[14])+" False");
		System.out.println(ingredients[13].equals(ingredients[14])+" True");
		
	}
	


}
