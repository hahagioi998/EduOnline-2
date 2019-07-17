package entity;

public class TeacherClasses {

	private int teacherId;	//教师ID
	private int classesId;	//班级ID
	public TeacherClasses() {
		super();
	}
	public TeacherClasses(int teacherId, int classesId) {
		super();
		this.teacherId = teacherId;
		this.classesId = classesId;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
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
		TeacherClasses other = (TeacherClasses) obj;
		if (classesId != other.classesId)
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TeacherClasses [teacherId=" + teacherId + ", classesId=" + classesId + "]";
	}
	
}
