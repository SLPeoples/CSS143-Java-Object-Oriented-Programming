/*
 * Samuel L. Peoples, 1527650
 */
//This class represents a box with a width, height, and depth.
//The variable grade is a measure of the thickness of the cardboard
//used to construct the box.

public class Box{

	private int width, depth;
	private int height, grade;

	//class constructor
	public Box(int width, int height, int depth, int grade)
	{
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.grade = grade;
	}

	//Two boxes should be considered equivalent if their volume is
	//the same and they are constructed out of the same grade of cardboard.
	//returns true if they are equivalent and false otherwise
	public boolean equals(Box b)
	{
		return this.getVolume() == b.getVolume() && this.getGrade() == b.getGrade();
	}

	//If this Box is larger than the argument Box b
	//then return this Box - otherwise return b
	public Box larger(Box b)
	{
		if(b.getVolume() > this.getVolume())
			return b;
		else
			return this;
	}

	//Simple getter methods
	public int getGrade()
	{
		return grade;
	}

	public int getVolume()
	{
		return this.width * this.height * this.depth * this.grade;
	}

	public int getWidth()
	{
		return this.width;
	}

	public int getHeight()
	{
		return this.height;
	}

	public int getDepth()
	{
		return this.depth;
	}
}

