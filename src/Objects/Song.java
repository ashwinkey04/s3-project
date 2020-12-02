package Objects;

public class Song {
	String song_id;
	String alb_id;
	String m_id;
	String song_name;
	String singer;
	String duration;
	String genre;
	String ly_id;
	
	public void set_song_id(String song_id) {
	    this.song_id = song_id;
	}
	
	public void set_alb_id(String alb_id) {
	    this.alb_id = alb_id;
	}

	public void set_m_id(String m_id) {
	    this.m_id = m_id;
	}

	public void set_song_name(String song_name) {
	    this.song_name = song_name;
	}

	public void set_singer(String singer) {
	    this.singer = singer;
	}

	public void set_duration(String duration) {
	    this.duration = duration;
	}

	public void set_genre(String genre) {
	    this.genre = genre;
	}

	public void set_ly_id(String ly_id) {
	    this.ly_id = ly_id;
	}

	public String get_song_id(){
		  return song_id;
	}
	
	public String get_alb_id(){
		  return alb_id;
	}
	
	public String get_m_id(){
		  return m_id;
	}
	
	public String get_song_name(){
		  return song_name;
	}
	
	public String get_singer(){
		  return singer;
	}
	
	public String get_duration(){
		  return duration;
	}
	
	public String get_genre(){
		  return genre;
	}
	
	public String get_ly_id(){
		  return ly_id;
	}
	 
}
