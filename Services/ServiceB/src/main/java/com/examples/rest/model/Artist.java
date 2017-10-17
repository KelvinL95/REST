package com.examples.rest.model;

public class Artist {

	private long id;
	private String name;
	private String type;
	private int numberOfPieces;
	
	public Artist() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberOfPieces() {
		return numberOfPieces;
	}

	public void setNumberOfPieces(int numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	@Override
	public String toString() {
		return "Artist [id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (type != null ? "type=" + type + ", " : "") + "numberOfPieces=" + numberOfPieces + "]";
	}
	
}
