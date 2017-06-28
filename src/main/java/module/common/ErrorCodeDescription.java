package module.common;

public enum ErrorCodeDescription {	
	INTERNALSERVERERROR(500, "Internal Server Error"),
	NOTFOUND(404, "Data not available"),
	SUCCESS(200,"OK");

	private final int code;
	private final String description;

	private ErrorCodeDescription(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getCode() {
		return code;
	}
	public String toString() {
		return code + " " + description;
	}
}
