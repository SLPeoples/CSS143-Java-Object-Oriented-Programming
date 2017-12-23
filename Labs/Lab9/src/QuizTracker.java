import java.util.ArrayList;

/**
 * @author Samuel L. Peoples
 * Cloneable QuizTracker class, tracks quizScores with an arrayList
 */
public class QuizTracker implements Cloneable{
	ArrayList<QuizScore> quizzes;
	/**
	 * QuizTracker Constructor (empty)
	 */
	public QuizTracker(){
		this.quizzes = new ArrayList<QuizScore>();
	}
	
	/**
	 * QuizTracker constructor with quizScore list 
	 * @param qzz list of quizzes
	 */
	public QuizTracker(ArrayList<QuizScore> qzz){
		this.quizzes = qzz;
	}
	
	/**
	 * Adds a quizScore by cloning
	 * @param scr, score to clone
	 */
	public void add(QuizScore scr){
		quizzes.add(scr.clone());
	}
	
	/** clones the quizTracker
	 * @return cloned quizTracker
	 */
	@Override
	public QuizTracker clone(){
		ArrayList<QuizScore> quizzes2 = new ArrayList<>();
		for(QuizScore scr:this.quizzes){
			quizzes2.add(scr.clone());
		}
		return new QuizTracker(quizzes2);
	}
}
