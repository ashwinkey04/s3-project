package Objects;

public class Lyricist {
	String ly_id;
	String ly_name;
	String ly_addr;
	int ly_award;
	String lang;

	public void set_ly_id(String ly_id) {
		this.ly_id = ly_id;
	}

	public void set_ly_name(String ly_name) {
	    this.ly_name = ly_name;
	}

	public void set_ly_addr(String ly_addr) {
	    this.ly_addr = ly_addr;
	}

	public void set_ly_award(int ly_award) {
	    this.ly_award = ly_award;
	}
	
	public void set_lang(String lang) {
	    this.lang = lang;
	}
	  
	public String get_ly_id(){
		  return ly_id;
	}
	
	public String get_ly_name(){
		  return ly_name;
	}
	
	public String get_ly_addr(){
		  return ly_addr;
	}

	public int get_ly_award(){
		  return ly_award;
	}
	
	public String get_lang(){
		  return lang;
	}

}
