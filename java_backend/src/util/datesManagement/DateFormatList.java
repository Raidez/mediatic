package util.datesManagement;

public enum DateFormatList {
	defaultDate("yyyy-MM-dd") , french("dd/MM/yyyy");
	
	private String value;

	private DateFormatList(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
