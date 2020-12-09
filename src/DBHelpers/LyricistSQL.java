package DBHelpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Lyricist;

public class LyricistSQL extends SQLHelper {
	protected static LyricistSQL db = new LyricistSQL();

	@Override
	protected void setTableName() {
		table = "Lyricist";
	}
	
	private String getValuesString(Lyricist Lyricist) {
		String values = "(" +
						surroundQuote(Lyricist.get_ly_id())+","+
						surroundQuote(Lyricist.get_ly_name())+","+
						surroundQuote(Lyricist.get_ly_addr())+","+
						Lyricist.get_ly_award()+","+
						surroundQuote(Lyricist.get_lang())+
						")";
		return values;
				
	}

	public Lyricist[] writeResult(ResultSet resultSet) throws SQLException {
		int count = getCount();
		int index = 0;
		Lyricist lyricist_array[] = new Lyricist[count];

		while (resultSet.next()) {
			
			lyricist_array[index] = new Lyricist();
			lyricist_array[index].set_ly_id(resultSet.getString("ly_id"));
			lyricist_array[index].set_ly_name(resultSet.getString("ly_name"));
			lyricist_array[index].set_ly_addr(resultSet.getString("ly_addr"));
			lyricist_array[index].set_lang(resultSet.getString("lang"));
			lyricist_array[index].set_ly_award(resultSet.getInt("ly_award"));

			index++;
		}
		return lyricist_array;
	}
	
	public static void insert(Lyricist lyricist) throws Exception {
		LyricistSQL.initDB();
		db.initTable();
		db.insertIntoTable(db.getValuesString(lyricist));
		db.close();
	}
	
	public static void delete(String m_id) throws Exception{
		LyricistSQL.initDB();
		db.initTable();
		db.deleteFromTable("ly_id = "+surroundQuote(m_id));
		db.close();
	}
	
	public static void main(String[] args) throws Exception {
		
	}

}
