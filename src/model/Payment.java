package model;

import java.sql.Date;

public class Payment {
	String payment_id;
	Date payment_date;
	String alb_id;
	String buyer_id;

	public Payment() {
	};// Default constructor

	public Payment(String payment_id, Date payment_date, String alb_id, String buyer_id) {
		this.payment_id = payment_id;
		this.payment_date = payment_date;
		this.alb_id = alb_id;
		this.buyer_id = buyer_id;
	}

	public void set_payment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public void set_payment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public void set_alb_id(String alb_id) {
		this.alb_id = alb_id;
	}

	public void set_buyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String get_payment_id() {
		return payment_id;
	}

	public Date get_payment_date() {
		return payment_date;
	}

	public String get_alb_id() {
		return alb_id;
	}

	public String get_buyer_id() {
		return buyer_id;
	}

}
