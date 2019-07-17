package entity;

public class Question {

	private int id;			//试题ID
	private int courseId;	//课程ID
	private String title;	//题目
	private String optionA;	//A选项
	private String optionB;	//B选项
	private String optionC;	//C选项
	private String optionD;	//D选项
	private String answer;	//答案
	private double score;	//分数
	private int complexity;	//复杂性（1、简单 2、中等 3、复杂）
	private String analysis;//解析
	public Question() {
		super();
	}
	public Question(int id, int courseId, String title, String optionA, String optionB, String optionC, String optionD,
			String answer, double score, int complexity, String analysis) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.title = title;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.answer = answer;
		this.score = score;
		this.complexity = complexity;
		this.analysis = analysis;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public int getComplexity() {
		return complexity;
	}
	public void setComplexity(int complexity) {
		this.complexity = complexity;
	}
	public String getAnalysis() {
		return analysis;
	}
	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((analysis == null) ? 0 : analysis.hashCode());
		result = prime * result + ((answer == null) ? 0 : answer.hashCode());
		result = prime * result + complexity;
		result = prime * result + courseId;
		result = prime * result + id;
		result = prime * result + ((optionA == null) ? 0 : optionA.hashCode());
		result = prime * result + ((optionB == null) ? 0 : optionB.hashCode());
		result = prime * result + ((optionC == null) ? 0 : optionC.hashCode());
		result = prime * result + ((optionD == null) ? 0 : optionD.hashCode());
		long temp;
		temp = Double.doubleToLongBits(score);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (analysis == null) {
			if (other.analysis != null)
				return false;
		} else if (!analysis.equals(other.analysis))
			return false;
		if (answer == null) {
			if (other.answer != null)
				return false;
		} else if (!answer.equals(other.answer))
			return false;
		if (complexity != other.complexity)
			return false;
		if (courseId != other.courseId)
			return false;
		if (id != other.id)
			return false;
		if (optionA == null) {
			if (other.optionA != null)
				return false;
		} else if (!optionA.equals(other.optionA))
			return false;
		if (optionB == null) {
			if (other.optionB != null)
				return false;
		} else if (!optionB.equals(other.optionB))
			return false;
		if (optionC == null) {
			if (other.optionC != null)
				return false;
		} else if (!optionC.equals(other.optionC))
			return false;
		if (optionD == null) {
			if (other.optionD != null)
				return false;
		} else if (!optionD.equals(other.optionD))
			return false;
		if (Double.doubleToLongBits(score) != Double.doubleToLongBits(other.score))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", courseId=" + courseId + ", title=" + title + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + ", answer=" + answer
				+ ", score=" + score + ", complexity=" + complexity + ", analysis=" + analysis + "]";
	}
	
}
