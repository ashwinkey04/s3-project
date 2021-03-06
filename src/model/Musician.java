package model;

public class Musician {
	String m_id;
	String m_name;
	String m_addr;
	boolean licensed;
	int m_award;

	public Musician() {};//Default constructor
	
	public Musician(String m_id, String m_name, String m_addr, boolean licensed, int m_award) {
		this.m_id = m_id;
		this.m_name = m_name;
		this.m_addr = m_addr;
		this.licensed = licensed;
		this.m_award = m_award;
	}

	public void set_m_id(String m_id) {
		this.m_id = m_id;
	}

	public void set_m_name(String m_name) {
		this.m_name = m_name;
	}

	public void set_m_addr(String m_addr) {
		this.m_addr = m_addr;
	}

	public void set_licensed(boolean licensed) {
		this.licensed = licensed;
	}

	public void set_m_award(int m_award) {
		this.m_award = m_award;
	}

	public String get_m_id() {
		return m_id;
	}

	public String get_m_name() {
		return m_name;
	}

	public String get_m_addr() {
		return m_addr;
	}

	public boolean get_licensed() {
		return licensed;
	}

	public int get_m_award() {
		return m_award;
	}

}
