import java.awt.geom.Point2D;

/**
 * @author Samuel L. Peoples, 1527650
 * Line Segment constructor, determines placement and distance between a start and end point
 * What is a privacy leak? 
 * 		A privacy leak is when information that the developer does not want public is revealed to the user.
 * Do your getters or setters have privacy leaks?
 * 		They shouldn't because they only return and set values to an individual object.
 * Where else could a privacy leak occur?
 * 		When returning information to the user, if it can be modified.
 *
 */
public class LineSegment {
	private Point2Da startPoint = new Point2Da(0,0);
	private Point2Da endPoint = new Point2Da(0,0);
	/**
	 * Empty constructor
	 */
	public LineSegment() {}

	/**
	 * Takes two point2D objects and sets them to the start and end points
	 * @param a, Point2Da startpoint
	 * @param b, Point2Da endpoint
	 */
	public LineSegment(Point2Da a, Point2Da b) {
		this.startPoint = a;
		this.endPoint = b;
	}

	/**
	 * Copy constructor
	 * @param b, Other line segment to copy from
	 */
	public LineSegment(LineSegment b) {
		this.startPoint = b.startPoint;
		this.endPoint = b.endPoint;
	}


	/**
	 * Setter for start point
	 * @param a, Point2Da startpoint
	 */
	public void setStartPoint(Point2Da a) {
		this.startPoint = a;		
	}
	
	/**
	 * getter for startpoint
	 * @return this startpoint
	 */
	public Point2Da getStartPoint(){
		return this.startPoint;
	}

	/**
	 * Setter for end point
	 * @param a, Point2Da endpoint
	 */
	public void setEndPoint(Point2Da a) {
		this.endPoint = a;
		
	}

	/**
	 * getter for end point
	 * @return this endpoint
	 */
	public Point2Da getendPoint(){
		return this.endPoint;
	}
	/**
	 * Overwrites inherited tostring,
	 * @return String, appropriate to situation
	 */
	public String toString(){
		return "Start: "+this.startPoint+", End: "+this.endPoint+"; Distance: "+ this.distance();
	}
	
	/**
	 * determines equality, relates start and endpoints
	 * @param a, other line segment to compare
	 * @return true, if both start and end points are equal
	 */
	public boolean equals(LineSegment a){
		boolean bool = false;
		if(this.startPoint.equals(a.startPoint)&&this.endPoint.equals(a.endPoint))
			bool = true;
		return bool;
	}
	/**
	 * Determines distance between two points using the distance formula
	 * @return String cast from Double of distance.
	 */
	public String distance() {
		return Double.toString(Math.sqrt((this.startPoint.getX()-this.endPoint.getX())*(this.startPoint.getX()-this.endPoint.getX())+(this.startPoint.getY()-this.endPoint.getY())*(this.startPoint.getY()-this.endPoint.getY())));
	}


}
