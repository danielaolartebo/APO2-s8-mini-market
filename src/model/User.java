package model;
public class User {
	
	private String document;
	private String type;
	
	public User(String document,String type) {
		
		this.document = document;
		this.type = type;
	}
	
	public void setDocument(String document) {
		this.document = document;
	}
	
	public String getDocument() {
		return document;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

}

