package entity;

public class ClassesCourse {

	private int classesId;	//班级ID
	private int courseId;	//课程ID
	private int teacherId;	//教师ID
	public ClassesCourse() {
		super();
	}
	public ClassesCourse(int classesId, int courseId, int teacherId) {
		super();
		this.classesId = classesId;
		this.courseId = courseId;
		this.teacherId = teacherId;
	}
	public int getClassesId() {
		return classesId;
	}
	public void setClassesId(int classesId) {
		this.classesId = classesId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + classesId;
		result = prime * result + courseId;
		result = prime * result + teacherId;
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
		ClassesCourse other = (ClassesCourse) obj;
		if (classesId != other.classesId)
			return false;
		if (courseId != other.courseId)
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ClassesCourse [classesId=" + classesId + ", courseId=" + courseId + ", teacherId=" + teacherId + "]";
	}
	
}
