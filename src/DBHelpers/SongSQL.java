package DBHelpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Song;

public class SongSQL extends SQLHelper {
	protected static SongSQL db = new SongSQL();

	@Override
	protected void setTableName(){
		table = "song";
	}

	private String getValuesString(Song song) {
		String values = "(" +
						surroundQuote(song.get_song_id())+","+
						surroundQuote(song.get_alb_id())+","+
						surroundQuote(song.get_m_id())+","+
						surroundQuote(song.get_song_name())+","+
						surroundQuote(song.get_singer())+","+
						surroundQuote(song.get_duration())+","+
						surroundQuote(song.get_genre())+","+
						surroundQuote(song.get_ly_id())+
						")";
		return values;
				
	}

	public Song[] writeResult(ResultSet resultSet) throws SQLException {
		int count = getCount();
		int index = 0;
		Song song_array[] = new Song[count];

		while (resultSet.next()) {
			
			song_array[index] = new Song();
			song_array[index].set_m_id(resultSet.getString("m_id"));
			song_array[index].set_song_id(resultSet.getString("song_id"));
			song_array[index].set_alb_id(resultSet.getString("alb_id"));
			song_array[index].set_song_name(resultSet.getString("song_name"));
			song_array[index].set_duration(resultSet.getString("duration"));
			song_array[index].set_genre(resultSet.getString("genre"));
			song_array[index].set_ly_id(resultSet.getString("ly_id"));

			index++;
		}
		return song_array;
	}
	
	public static void insert(Song song) throws Exception {
		SongSQL.initDB();
		db.initTable();
		db.insertIntoTable(db.getValuesString(song));
		db.close();
	}
	
	public static void delete(String song_id) throws Exception{
		SongSQL.initDB();
		db.initTable();
		db.deleteFromTable("song_id = "+surroundQuote(song_id));
		db.close();
	}
	
	public static void main(String[] args) {
		

	}

}
