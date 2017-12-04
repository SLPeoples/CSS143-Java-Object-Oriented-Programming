import java.awt.Color;

/**
 * @author Samuel L. Peoples, 1527650
 * Pizza class. Creates a pizza made of ingredients which range from bases, vegetables, meats, and cheeses.
 * Bases include Marinara and Alfredo
 * Vegetables include Olives and Peppers
 * Meats include Sausage and Pepperoni
 * Cheeses include Goat and Mozzarella
 * The program will determine a random cost based on a random number of random ingredients.
 * Pizzas will be round or square, and some vegetables may be oddly colored.
 * Users may eat the pizza, but it will disappear quickly.
 */
public class Pizza implements PizzaComparable{
	protected ArrayList ingredients = new ArrayList();
	protected Shape pizzaShape;
	protected Money cost = new Money(0,0);
	protected int calories = 0;
	protected Fraction remaining = new Fraction(1,1);
	
	/**
	 * Empty constructor which creates random pizzas
	 */
	public Pizza(){
		//Checks between 1 and 2, determines shape
		if (((Math.random() <= 0.5) ? 1 : 2) == 1)
			this.setShape(new Square(1,1,getRandInt()));
		else
			this.setShape(new Circle(1,1,getRandInt()));
		//Determines a random number of ingredients to add
		int ingredientsNum = getRandInt()/10;
		//Adds the random incredients
		for(int i=0;i<ingredientsNum;i++)
			addIngredients();
		

	}
	
	/**
	 * Adds the ingredients that were called from the constructor
	 */
	private void addIngredients(){
		switch( ( int )(Math.random() * 8) ) {
		
		case 0: 	addIngredient(new Sausage("Sausage", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 1: 	addIngredient(new Pepperoni("Pepperoni", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 2: 	addIngredient(new Pepper("Pepper", new Money(getRandInt(),getRandInt()), getRandInt(), getRandColor()));
					break;
		case 3: 	addIngredient(new Olive("Olive", new Money(getRandInt(),getRandInt()), getRandInt(), getRandColor()));
					break;				
		case 4: 	addIngredient(new Mozzarella("Mozzarella Cheese", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 5: 	addIngredient(new Marinara("Marinara Sauce", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 6: 	addIngredient(new Alfredo("Alfredo Sauce", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;
		case 7: 	addIngredient(new Goat("Goat Cheese", new Money(getRandInt(),getRandInt()), getRandInt()));
					break;				
		}
	}
	/**
	 * @return rand int for randomizing the pizza creating
	 */
	public int getRandInt() {
		return ( (int) ( Math.random() * 200 ) );	
	}
	/**
	 * @return retval, random choice between RGBY
	 */
	public Color getRandColor(){
		Color retVal = null;
		switch( ( int )(Math.random() * 4) ) {
		
		case 0: 	retVal = Color.BLUE;
					break;
		case 1: 	retVal = Color.GREEN;
					break;
		case 2: 	retVal = Color.RED;
					break;
		case 3: 	retVal = Color.YELLOW;
					break;				
	}
	return retVal;
	}
	

	/**
	 * sets the shape using clone
	 * @param s
	 */
	public void setShape(Shape s) { 
		this.pizzaShape = (Shape)s.clone();
	}
	
	/**
	 * return this shape
	 * @return
	 */
	public Shape getShape() {
		return (Shape) pizzaShape.clone();
	}
	
	/**
	 * Sets the remaining portion
	 * @param f
	 */
	public void setRemaining(Fraction f){
		Fraction retVal = new Fraction((int) (((double)this.remaining.getNumerator()* (double)f.getDenominator())-((double)this.remaining.getDenominator()* (double)f.getNumerator())), this.remaining.getDenominator()*f.getDenominator());
		String retValString = retVal.reduceFraction(retVal.getNumerator(), retVal.getDenominator());
		String[] input1 = retValString.split("/", 2);	
		int num = Integer.parseInt(input1[0]);
		int dem = Integer.parseInt(input1[1]);
		this.remaining = new Fraction(num,dem);
	}
	
	/**
	 * returns the remaining fraction
	 * @return Fraction remaining
	 */
	public Fraction getRemaining(){
		return (this.remaining);
	}
	
	/**
	 * deterines the remaining area, then rounds the value to two decimal places by using floor
	 * @return double area
	 */
	public double getRemianingArea(){
		return 	Math.floor(this.getShape().getArea()*((double)this.remaining.getNumerator()/(double)this.remaining.getDenominator())*100)/100;
	}

	/**
	 * determines the total cost of the pizza
	 * @return this cost * this remianing
	 */
	public Money getCost(){
		double temp = this.cost.getMoney();
		double retVal = (temp*this.getRemaining().getNumerator())/this.getRemaining().getDenominator();
		//round the double to get just the int value
		int dol = (int) retVal;
		//then take the decimal, move it over two places, and shave off the rest.
		int cen = (int) ((retVal-dol)*100);
		//100.204348 -> 
			//dol = int(100.204348) = 100
				//100.204348 - 100 = .204348
				//.204348 * 100 = 20.4348
			//cen = int(20.4348) = 20
		//return new Money(100,20)
		return new Money(dol, cen);
	}
	
	/**getter for total calories of the pizza
	 * @return this calories
	 */
	public int getCalories(){
		return this.calories;
	}
	
	/** compares pizza objects based on cost
	 * @return -1,0,1 for cost comparison
	 */
	public int compareTo(Object other) {
		return this.getCost().compareTo(((Pizza) other).getCost());
	}
	/**
	 * compares pizzas based on area
	 * @return -1,0,1 based on area of pizzas
	 */
	@Override
	public int compareToBySize(Object o) {
		if(this.getShape().getArea() > ((Pizza) o).getShape().getArea())
			return 1;
		else if(this.getShape().getArea() == ((Pizza) o).getShape().getArea())
			return 0;
		else return -1;
	}
	
	/** 
	 * Compares pizzas by calories
	 * @return -1,0,1 based on calories
	 */
	@Override
	public int compareToByCalories(Object o) {
		if(this.getCalories() > ((Pizza) o).getCalories())
			return 1;
		else if(this.getCalories() == ((Pizza) o).getCalories())
			return 0;
		else return -1;
	}
	
	/**
	 * appends an ingredient to the arraylist
	 * @param a, ingredient to add
	 */
	void addIngredient(Ingredient a){
		ingredients.add(a);
		this.calories += a.getCalories();
		this.cost.add(a.getCost());
	}
	
	/**
	 * updates the remaining fraction and catches if an individual attempts to eat too much,
	 * notifies if the pizza is gone
	 * @param amt, fraction to eat
	 */
	void eatSomePizza(Fraction amt){
		//double attemptToEat = (amt.getNumerator()/amt.getDenominator())*pizzaShape.getArea();
		try{
			if(this.getRemaining().compareTo(amt) == -1)//Checks if a person can eat the fraction-of-whole
				throw new NotEnoughPizzaException();
			try{
				if(this.getRemaining().compareTo(amt) == 0){//Checks if the person is eating the rest of the pizza
					this.setRemaining(amt);
					throw new PizzaException();
				}
				else
					this.setRemaining(amt);//updates the remaining
			}
			catch(PizzaException e){
				System.out.println("All the pizza is gone.");
				this.setRemaining(new Fraction(0,1));
			}
		}
		catch(NotEnoughPizzaException e){
			System.out.println("You can't eat pizza that isn't there!");
		}
	}
	
	/** develops the return string
	 * @return the appropriate string
	 */
	public String toString(){
		return  "Pizza has a price: "
				+this.getCost().toString()+" and calories: "
				+this.getCalories()+", Fraction remaining: "
				+this.getRemaining()+" with area remaining: "
				+this.getRemianingArea()+" of shape: "
				+this.getShape().nameString();
	}
	
	/**
	 * testing pizzas!
	 * @param args
	 */
	public static void main(String args[]){
		System.out.println("A:");
		Pizza a = new Pizza();
		System.out.println(a.toString());
		System.out.println("Adding some meat!");
		a.addIngredient(new Meat("Meat", new Money(25,19), 350));
		System.out.println(a.toString());
		a.eatSomePizza(new Fraction(1,2));
		System.out.println("Eating Half!");
		System.out.println(a.toString());
		System.out.println("Eating A Third!");
		a.eatSomePizza(new Fraction(1,3));
		System.out.println(a.toString());
		System.out.println("Eating Half!");
		a.eatSomePizza(new Fraction(1,2));
		System.out.println("Eating A Sixth!");
		a.eatSomePizza(new Fraction(1,6));
		System.out.println(a.toString());
		
		System.out.println("B:");
		Pizza b = new Pizza();
		System.out.println(b.toString());
		System.out.println(b.toString());
		System.out.println(b.toString());
		
		System.out.println("C:");
		Pizza c = new Pizza();
		System.out.println(c.toString());
		
		System.out.println("b compared to c: " +b.compareTo(c));
		System.out.println("c compared to b: " +c.compareTo(b));
	}
}
