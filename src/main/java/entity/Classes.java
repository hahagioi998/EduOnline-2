package entity;

public class Classes {

	private int id;			//班级ID
	private int number;		//班号
	private String name;	//班级名称
	private int majorId;	//所属专业ID
	public Classes() {
		super();
	}
	public Classes(int id, int number, String name, int majorId) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.majorId = majorId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMajorId() {
		return majorId;
	}
	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + majorId;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
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
		Classes other = (Classes) obj;
		if (id != other.id)
			return false;
		if (majorId != other.majorId)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Classes [id=" + id + ", number=" + number + ", name=" + name + ", majorId=" + majorId + "]";
	}
	
}
