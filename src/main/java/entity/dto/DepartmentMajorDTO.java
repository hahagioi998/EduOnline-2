package entity.dto;

public class DepartmentMajorDTO {

	private int id;				//院系ID
	private String number;		//院系编号
	private String name;		//院系名称
	private String parentName;	//所属院系
	private int sign;			//标记
	public DepartmentMajorDTO() {
		super();
	}
	public DepartmentMajorDTO(int id, String number, String name, String parentName, int sign) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.parentName = parentName;
		this.sign = sign;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((parentName == null) ? 0 : parentName.hashCode());
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
		DepartmentMajorDTO other = (DepartmentMajorDTO) obj;
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
		if (parentName == null) {
			if (other.parentName != null)
				return false;
		} else if (!parentName.equals(other.parentName))
			return false;
		if (sign != other.sign)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DepartmentMajorDTO [id=" + id + ", number=" + number + ", name=" + name + ", parentName=" + parentName
				+ ", sign=" + sign + "]";
	}
	
}
