package entity;

public class Student {

	private int id;			//学生ID
	private int userId;		//用户ID
	private int classesId;	//所属班级ID
	public Student() {
		super();
	}
	public Student(int id, int userId, int classesId) {
		super();
		this.id = id;
		this.userId = userId;
		this.classesId = classesId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getClassesId() {
		return classesId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classesId;
		result = prime * result + id;
		result = prime * result + userId;
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
		Student other = (Student) obj;
		if (classesId != other.classesId)
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", userId=" + userId + ", classesId=" + classesId + "]";
	}
	
}
