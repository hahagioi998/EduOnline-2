package entity.dto;

import java.util.Arrays;

public class CourseJsonDTO {

	private int sign;
	private int parentID;
	private CourseJsonArrayDTO[] tableData;
	public CourseJsonDTO() {
		super();
	}
	public CourseJsonDTO(int sign, int parentID, CourseJsonArrayDTO[] tableData) {
		super();
		this.sign = sign;
		this.parentID = parentID;
		this.tableData = tableData;
	}
	public int getSign() {
		return sign;
	}
	public void setSign(int sign) {
		this.sign = sign;
	}
	public int getParentID() {
		return parentID;
	}
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	public CourseJsonArrayDTO[] getTableData() {
		return tableData;
	}
	public void setTableData(CourseJsonArrayDTO[] tableData) {
		this.tableData = tableData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + parentID;
		result = prime * result + sign;
		result = prime * result + Arrays.hashCode(tableData);
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
		CourseJsonDTO other = (CourseJsonDTO) obj;
		if (parentID != other.parentID)
			return false;
		if (sign != other.sign)
			return false;
		if (!Arrays.equals(tableData, other.tableData))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CourseJsonDTO [sign=" + sign + ", parentID=" + parentID + ", tableData=" + Arrays.toString(tableData)
				+ "]";
	}
	
}
