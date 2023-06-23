package com.teamsix.dto;

public class MovieSchedule {
	private int schedulesrn;
	private String screeningdate;
	private String screeningtime;
	private int moviesrn;
	private int roomsrn;
	
	public MovieSchedule() { super(); }
	
	public MovieSchedule(int schedulesrn, String screeningdate, String screeningtime, int moviesrn, int roomsrn) {
		super();
		this.schedulesrn = schedulesrn;
		this.screeningdate = screeningdate;
		this.screeningtime = screeningtime;
		this.moviesrn = moviesrn;
		this.roomsrn = roomsrn;
	}

	@Override
	public String toString() {
		return "MovieSchedule [schedulesrn=" + schedulesrn + ", screeningdate=" + screeningdate + ", screeningtime="
				+ screeningtime + ", moviesrn=" + moviesrn + ", roomsrn=" + roomsrn + "]";
	}

	public int getMoviesrn() { return moviesrn; }
	public void setMoviesrn(int moviesrn) { this.moviesrn = moviesrn; }

	public int getRoomsrn() { return roomsrn; }
	public void setRoomsrn(int roomsrn) { this.roomsrn = roomsrn; }

	public int getSchedulesrn() { return schedulesrn; }
	public void setSchedulesrn(int schedulesrn) { this.schedulesrn = schedulesrn; }
	
	public String getScreeningdate() { return screeningdate; }
	public void setScreeningdate(String screeningdate) { this.screeningdate = screeningdate;}
	
	public String getScreeningtime() { return screeningtime; }
	public void setScreeningtime(String screeningtime) { this.screeningtime = screeningtime; }	
}