package com.teamsix.dto;

public class MyMovingTheater {
	private String theatername;
	private int count;
	public MyMovingTheater() { super(); }
	public MyMovingTheater(String theatername, int count) {
		super();
		this.theatername = theatername;
		this.count = count;
	}
	@Override
	public String toString() {
		return "MyMovingTheater [theatername=" + theatername + ", count=" + count + "]";
	}
	public String getTheatername() { return theatername; } public void setTheatername(String theatername) { this.theatername = theatername; }
	public int getCount() { return count; } public void setCount(int count) { this.count = count; }
	
}
