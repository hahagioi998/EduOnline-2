package entity;

public class DepartmentMajor {

	private int id;			//院系ID
	private String number;	//院系编号
	private String name;	//院系名字
	private int parentId;	//父ID
	private int sign;		//标记（1、学院 2、专业）
	public DepartmentMajor() {
		super();
	}
	public DepartmentMajor(int id, String number, String name, int parentId, int sign) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.parentId = parentId;
		this.sign = sign;
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + parentId;
		result = prime * result + sign;
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
		DepartmentMajor other = (DepartmentMajor) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (parentId != other.parentId)
			return false;
		if (sign != other.sign)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DepartmentMajor [id=" + id + ", number=" + number + ", name=" + name + ", parentId=" + parentId
				+ ", sign=" + sign + "]";
	}
}
