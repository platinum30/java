
public class Grade {
	private String profession;
	private int score;
	private final int MIN_SCORE = 40;
	private final int MAX_SCORE = 100;

	public Grade(String profession, int score) {
		super();
		this.profession = profession;
		setScore(score);
	}

	@Override
	public String toString() {
		return "Grade [profession=" + profession + ", score=" + score + "]";
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getScore() {
		return score;
	}

	/**
	 * func set grade score| if score is note valid(40-100), func set score to -1;
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		if (score >= MIN_SCORE && score <= MAX_SCORE) {
			this.score = score;
		} else {
			this.score = -1;
		}

	}

}
