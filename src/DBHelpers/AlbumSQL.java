package DBHelpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Album;
import model.Album;

public class AlbumSQL extends SQLHelper {
	protected static AlbumSQL db = new AlbumSQL();

	@Override
	protected void setTableName(){
		table = "album";
	}

	private String getValuesString(Album album) {
		String values = "(" +
						surroundQuote(album.get_alb_id())+","+
						surroundQuote(album.get_title())+","+
						surroundQuote(album.get_release_date())+","+
						surroundQuote(album.get_copyright_date())+","+
						surroundQuote(album.get_alb_lang())+","+
						(album.get_price())+","+
						surroundQuote(album.get_staff_id())+","+
						surroundQuote(album.get_studio_id())+","+
						")";
		return values;
				
	}

	public Album[] writeResult(ResultSet resultSet) throws SQLException {
		int count = getCount();
		int index = 0;
		Album album_array[] = new Album[count];

		while (resultSet.next()) {
			
			album_array[index] = new Album();
			album_array[index].set_alb_id(resultSet.getString("alb_id"));
			album_array[index].set_title(resultSet.getString("title"));
			album_array[index].set_release_date(resultSet.getDate("release_date"));
			album_array[index].set_copyright_date(resultSet.getDate("album_name"));
			album_array[index].set_alb_lang(resultSet.getString("alb_lang"));
			album_array[index].set_price(resultSet.getInt("price"));
			album_array[index].set_staff_id(resultSet.getString("staff_id"));
			album_array[index].set_studio_id(resultSet.getString("studio_id"));

			index++;
		}
		return album_array;
	}
	
	public static void insert(Album album) throws Exception {
		AlbumSQL.initDB();
		db.initTable();
		db.insertIntoTable(db.getValuesString(album));
		db.close();
	}
	
	public static void delete(String album_id) throws Exception{
		AlbumSQL.initDB();
		db.initTable();
		db.deleteFromTable("alb_id = "+surroundQuote(album_id));
		db.close();
	}
	
	public static void main(String[] args) {
		

	}

}
