package model;

import java.sql.Date;

public class Album {
	String alb_id;
	String title;
	Date release_date;
	Date copyright_date;
	String alb_lang;
	int price;
	String staff_id;
	String studio_id;
	
	public Album() {};//Default constructor

	public Album(String alb_id, String title, Date release_date, Date copyright_date, String alb_lang, int price,
			String staff_id, String studio_id) {
		this.alb_id = alb_id;
		this.title = title;
		this.release_date = release_date;
		this.copyright_date = copyright_date;
		this.alb_lang = alb_lang;
		this.price = price;
		this.staff_id = staff_id;
		this.studio_id = studio_id;
	}

	public void set_alb_id(String alb_id) {
		this.alb_id = alb_id;
	}

	public void set_title(String title) {
		this.title = title;
	}

	public void set_release_date(Date release_date) {
		this.release_date = release_date;
	}

	public void set_copyright_date(Date copyright_date) {
		this.copyright_date = copyright_date;
	}

	public void set_alb_lang(String alb_lang) {
		this.alb_lang = alb_lang;
	}

	public void set_price(int price) {
		this.price = price;
	}

	public void set_staff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	public void set_studio_id(String studio_id) {
		this.studio_id = studio_id;
	}

	public String get_title() {
		return title;
	}

	public Date get_release_date() {
		return release_date;
	}

	public Date get_copyright_date() {
		return copyright_date;
	}

	public String get_alb_lang() {
		return alb_lang;
	}

	public int get_price() {
		return price;
	}

	public String staff_id() {
		return staff_id;
	}

	public String studio_id() {
		return studio_id;
	}

}
