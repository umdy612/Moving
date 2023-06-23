package com.teamsix.dto;

public class Payment {
	private String totalprice;
	private String paymentmethod;
	private String paydate;
	private String payip;
	private int paysrn;
	
	public Payment() { super(); }
	
	public Payment(String totalprice, String paymentmethod, String paydate, String payip, int paysrn) {
		super();
		this.totalprice = totalprice;
		this.paymentmethod = paymentmethod;
		this.paydate = paydate;
		this.payip = payip;
		this.paysrn = paysrn;
	}

	@Override
	public String toString() {
		return "Payment [totalprice=" + totalprice + ", paymentmethod=" + paymentmethod + ", paydate=" + paydate
				+ ", payip=" + payip + ", paysrn=" + paysrn + "]";
	}

	public int getPaysrn() { return paysrn; } 
	public void setPaysrn(int paysrn) { this.paysrn = paysrn; } 

	public String getTotalprice() { return totalprice; }
	public void setTotalprice(String totalprice) { this.totalprice = totalprice; }
	
	public String getPaymentmethod() { return paymentmethod; }
	public void setPaymentmethod(String paymentmethod) { this.paymentmethod = paymentmethod; }
	
	public String getPaydate() { return paydate; }
	public void setPaydate(String paydate) { this.paydate = paydate; }
	
	public String getPayip() { return payip; }
	public void setPayip(String payip) { this.payip = payip; }	
}