
/**
 * @author Samuel L. Peoples
 * Cloneable QuizScore class, tracks scores as ints
 */
public class QuizScore implements Cloneable{
	private int score;
	/**
	 * constructor for scores
	 * @param scr, int to store
	 */
	public QuizScore(int scr){
		this.score = scr;
	}
	
	/**
	 * Sets this score to scr
	 * @param scr, int to store
	 */
	public void setScore(int scr){
		this.score = scr;
	}
	
	/**
	 * getter for score
	 * @return this score
	 */
	public int getScore(){
		return this.score;
	}
	
	/** 
	 * clones the quizScore
	 * @return this quizScore (cloned)
	 */
	public QuizScore clone(){
		return new QuizScore(this.score);
	}
}
