package com.teamsix.dto;

public class MovieStar {
	private Movie movie;
	private float star;
	public MovieStar() {
		super();
	}
	public MovieStar(Movie movie, float star) {
		super();
		this.movie = movie;
		this.star = star;
	}
	@Override
	public String toString() {
		return "MovieStar [movie=" + movie + ", star=" + star + "]";
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	
}
