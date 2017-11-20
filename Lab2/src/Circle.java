/**
 * @author Samuel L. Peoples
 * This Class constructs circles and "draws" them, it also calculates area.
 */
public class Circle {
	private int x=0;
	private int y=0;
	private double radius=0;
	private String shape = "O";
	
	/**
	 * empty Main.
	 */
	public static void main(String[] args) {}
	
	/**
	 * Empty constructor
	 */
	public Circle() {}
	
	/**
	 * Constructor without radius
	 * @param nx, this x postion
	 * @param ny, this y position
	 */
	public Circle(int nx, int ny) {
		this.x = nx;
		this.y = ny;
	}

	/**
	 * Constructor with radius and points
	 * @param nx, this x position
	 * @param ny, this y position
	 * @param radius, this radius
	 */
	public Circle(int nx, int ny, int radius) {
		this.x = nx;
		this.y = ny;
		this.radius = radius;
	}
	
	/**
	 * "Draws" the shape of the object
	 */
	public void draw() { 
		System.out.println(this.toString());
	}
	
	/**
	 * @return x, current circle's x
	 */
	public int getX(){
		return this.x;
	}
	
	/**
	 * @return y, current circle's y
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * @return radius, current circle's radius
	 */
	public double getRadius(){
		return this.radius;
	}
	
	/**
	 * @return area, current circle's radius squared, multiplied by PI
	 */
	public double getArea(){
		return Math.PI*this.radius*this.radius;
	}
	
	/**
	 * @param nx, sets this x to nx
	 */
	public void setX(int nx){
		this.x = nx;
	}
	
	/**
	 * @param ny, sets this y to ny
	 */
	public void setY(int ny){
		this.y = ny;
	}
	
	/**
	 * @param ra, sets this radius to ra
	 */
	public void setRadius(int ra){
		this.radius = ra;
	}
	
	/* 
	 * returns string representation defined by shape.
	 */
	@Override
	public String toString() {
		return shape;
	}
	
	/**
	 * @param that, another Circle object
	 * @return boolean, whether x position, y positon, and radius are equivalent
	 */
	public boolean equals(Circle that) {
		if(this.x == that.x && this.y == that.y && this.radius == that.radius)
			return true;
		else
			return false;
	}
}
