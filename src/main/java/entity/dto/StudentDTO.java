package entity.dto;

public class StudentDTO {

	private int studentId;	//学生ID
	private int nickname;	//学生昵称
	public StudentDTO() {
		super();
	}
	public StudentDTO(int studentId, int nickname) {
		super();
		this.studentId = studentId;
		this.nickname = nickname;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getNickname() {
		return nickname;
	}
	public void setNickname(int nickname) {
		this.nickname = nickname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nickname;
		result = prime * result + studentId;
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
		StudentDTO other = (StudentDTO) obj;
		if (nickname != other.nickname)
			return false;
		if (studentId != other.studentId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "StudentDTO [studentId=" + studentId + ", nickname=" + nickname + "]";
	}
	
}
