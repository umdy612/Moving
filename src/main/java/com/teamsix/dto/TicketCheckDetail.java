package com.teamsix.dto;

public class TicketCheckDetail {
	private String audience_type;
	private int numbers;
	private String seat;
	public TicketCheckDetail() { super(); }
	public TicketCheckDetail(String audience_type, int numbers, String seat) {
		super();
		this.audience_type = audience_type;
		this.numbers = numbers;
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "TicketCheckDetail [audience_type=" + audience_type + ", numbers=" + numbers + ", seat=" + seat + "]";
	}
	public String getAudience_type() { return audience_type; } public void setAudience_type(String audience_type) { this.audience_type = audience_type; }
	public int getNumbers() { return numbers; } public void setNumbers(int numbers) { this.numbers = numbers; }
	public String getSeat() { return seat; } public void setSeat(String seat) { this.seat = seat; }
}
