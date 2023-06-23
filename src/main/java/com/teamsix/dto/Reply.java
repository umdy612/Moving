package com.teamsix.dto;

public class Reply {
	private int replysrn;
	private String userid;
	private int moviesrn;
	private String replycontent;
	private int star;
	private String replydate;
	private String replyip;
	
	public Reply() { super(); }
	
	public Reply(int replysrn, String userid, int moviesrn, String replycontent, int star, String replydate,
			String replyip) {
		super();
		this.replysrn = replysrn;
		this.userid = userid;
		this.moviesrn = moviesrn;
		this.replycontent = replycontent;
		this.star = star;
		this.replydate = replydate;
		this.replyip = replyip;
	}

	@Override
	public String toString() {
		return "Reply [replysrn=" + replysrn + ", userid=" + userid + ", moviesrn=" + moviesrn + ", replycontent="
				+ replycontent + ", star=" + star + ", replydate=" + replydate + ", replyip=" + replyip + "]";
	}



	public int getMoviesrn() { return moviesrn; }    
	public void setMoviesrn(int moviesrn) { this.moviesrn = moviesrn; }

	public int getReplysrn() { return replysrn; }
	public void setReplysrn(int replysrn) { this.replysrn = replysrn; }
	
	public String getReplycontent() { return replycontent; }
	public void setReplycontent(String replycontent) { this.replycontent = replycontent; }
	
	public int getstar() { return star; }
	public void setstar(int star) { this.star = star; }
	
	public String getReplydate() { return replydate; }
	public void setReplydate(String replydate) { this.replydate = replydate; }
	
	public String getReplyip() { return replyip; }
	public void setReplyip(String replyip) { this.replyip = replyip; }	
}