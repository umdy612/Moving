package com.teamsix.dto;

public class Movie {
	private int moviesrn;
	private String title;
	private String director;
	private String genre;
	private String rating;
	private String detail;
	private String poster;
	private String runningtime;
	private String link;
	private String releasedate;
	private String closedate;
	
	public Movie() { super(); }
	
	public Movie(int moviesrn, String title, String director, String genre, String rating, String detail, String poster,
			String runningtime, String link, String releasedate, String closedate) {
		super();
		this.moviesrn = moviesrn;
		this.title = title;
		this.director = director;
		this.genre = genre;
		this.rating = rating;
		this.detail = detail;
		this.poster = poster;
		this.runningtime = runningtime;
		this.link = link;
		this.releasedate = releasedate;
		this.closedate = closedate;
	}
	
	@Override
	public String toString() {
		return "Movie [moviesrn=" + moviesrn + ", title=" + title + ", director=" + director + ", genre=" + genre
				+ ", rating=" + rating + ", detail=" + detail + ", poster=" + poster + ", runningtime=" + runningtime
				+ ", link=" + link + ", releasedate=" + releasedate + ", closedate=" + closedate + "]";
	}
	
	public int getMoviesrn() { return moviesrn; }
	public void setMoviesrn(int moviesrn) { this.moviesrn = moviesrn; }
	
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getDirector() { return director; }
	public void setDirector(String director) { this.director = director; }
	
	public String getGenre() { return genre; }
	public void setGenre(String genre) { this.genre = genre; }
	
	public String getRating() { return rating; }
	public void setRating(String rating) { this.rating = rating; }
	
	public String getDetail() { return detail; }	
	public void setDetail(String detail) { this.detail = detail; }
	
	public String getPoster() { return poster; }
	public void setPoster(String poster) { this.poster = poster; }
	
	public String getRunningtime() { return runningtime; }
	public void setRunningtime(String runningtime) { this.runningtime = runningtime; }
	
	public String getLink() { return link; }
	public void setLink(String link) { this.link = link; }
	
	public String getReleasedate() { return releasedate; }
	public void setReleasedate(String releasedate) { this.releasedate = releasedate; }
	
	public String getClosedate() { return closedate; }
	public void setClosedate(String closedate) { this.closedate = closedate; }	
}