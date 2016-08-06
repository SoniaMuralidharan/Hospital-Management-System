package com.hms.model;

public class StatesTO {

	private int id;
	private String Name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public StatesTO(int id, String Name) {
		super();
		this.id = id;
		this.Name = Name;
	}

	public StatesTO() {
		super();
	}

}
