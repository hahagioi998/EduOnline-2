package entity;

import java.util.Date;

public class Test {

	private int id;			//测试ID
	private String name;	//测试名字
	private int paperId;	//使用试卷ID
	private Date startTime;	//开始时间
	private Date endTime;	//结束时间
	private int teacherId;	//出题人ID
	private int classesId;	//班级ID
	public Test() {
		super();
	}
	public Test(int id, String name, int paperId, Date startTime, Date endTime, int teacherId, int classesId) {
		super();
		this.id = id;
		this.name = name;
		this.paperId = paperId;
		this.startTime = startTime;
		this.endTime = endTime;
		this.teacherId = teacherId;
		this.classesId = classesId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPaperId() {
		return paperId;
	}
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + paperId;
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Test other = (Test) obj;
		if (classesId != other.classesId)
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (paperId != other.paperId)
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		if (teacherId != other.teacherId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", paperId=" + paperId + ", startTime=" + startTime + ", endTime="
				+ endTime + ", teacherId=" + teacherId + ", classesId=" + classesId + "]";
	}
	
}
