package com.teamsix.dto;

public class TheaterRoom {
	private int roomsrn;
	private int theatersrn;
	private String roomname;
	private String seat_row;
	private String seat_col;
	
	public TheaterRoom() { super(); }
	
	public TheaterRoom(int roomsrn, int theatersrn, String roomname, String seat_row, String seat_col) {
		super();
		this.roomsrn = roomsrn;
		this.theatersrn = theatersrn;
		this.roomname = roomname;
		this.seat_row = seat_row;
		this.seat_col = seat_col;
	}

	@Override
	public String toString() {
		return "TheaterRoom [roomsrn=" + roomsrn + ", theatersrn=" + theatersrn + ", roomname=" + roomname
				+ ", seat_row=" + seat_row + ", seat_col=" + seat_col + "]";
	}

	public int getTheatersrn() { return theatersrn; }
	public void setTheatersrn(int theatersrn) { this.theatersrn = theatersrn; }

	public String getRoomname() { return roomname; }
	public void setRoomname(String roomname) { this.roomname = roomname; }

	public int getRoomsrn() { return roomsrn; }
	public void setRoomsrn(int roomsrn) { this.roomsrn = roomsrn; }
	
	public String getroomname() { return roomname; }
	public void setroomname(String roomname) { this.roomname = roomname; }
	
	public String getSeat_row() { return seat_row; }
	public void setSeat_row(String seat_row) { this.seat_row = seat_row; }
	
	public String getSeat_col() { return seat_col; }
	public void setSeat_col(String seat_col) { this.seat_col = seat_col; }	
}