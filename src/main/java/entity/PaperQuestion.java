package entity;

public class PaperQuestion {

	private int paperId;	//试卷ID
	private int questionId;	//试题ID
	public PaperQuestion() {
		super();
	}
	public PaperQuestion(int paperId, int questionId) {
		super();
		this.paperId = paperId;
		this.questionId = questionId;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + paperId;
		result = prime * result + questionId;
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
		PaperQuestion other = (PaperQuestion) obj;
		if (paperId != other.paperId)
			return false;
		if (questionId != other.questionId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "PaperQuestion [paperId=" + paperId + ", questionId=" + questionId + "]";
	}
	
}
