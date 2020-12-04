package DBHelpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Musician;

public class MusicianSQL extends SQLHelper {
	protected static MusicianSQL db = new MusicianSQL();

	@Override
	protected void setTableName() {
		table = "musician";
	}
	
	private String getValuesString(Musician musician) {
		String values = "(" +
						surroundQuote(musician.get_m_id())+","+
						surroundQuote(musician.get_m_name())+","+
						surroundQuote(musician.get_m_addr())+","+
						musician.get_licensed()+","+
						musician.get_m_award()+
						")";
		return values;
				
	}

	public Musician[] writeResult(ResultSet resultSet) throws SQLException {
		int count = getCount();
		int index = 0;
		Musician musician_array[] = new Musician[count];

		while (resultSet.next()) {
			
			musician_array[index] = new Musician();
			musician_array[index].set_m_id(resultSet.getString("m_id"));
			musician_array[index].set_m_name(resultSet.getString("m_name"));
			musician_array[index].set_m_addr(resultSet.getString("m_addr"));
			musician_array[index].set_licensed(resultSet.getBoolean("licensed"));
			musician_array[index].set_m_award(resultSet.getInt("m_award"));

			index++;
		}
		return musician_array;
	}
	
	public static void insert(Musician m) throws Exception {
		MusicianSQL.initDB();
		db.initTable();
		db.insertIntoTable(db.getValuesString(m));
		db.close();
	}
	
	public static void delete(String m_id) throws Exception{
		MusicianSQL.initDB();
		db.initTable();
		db.deleteFromTable("m_id = "+surroundQuote(m_id));
		db.close();
	}
	
	public static void issue_license(String m_id) throws Exception{
		MusicianSQL.initDB();
		db.initTable();
		db.updateTable("licensed = true","m_id = "+surroundQuote(m_id));
		db.close();
	}

	public static void main(String[] args) throws Exception {
//		MusicianSQL db = new MusicianSQL();
//		MusicianSQL.initDB();
//		db.initTable();
//		
//		Musician m1 = new Musician("M6","Ashwin","Coimbatore",false,69);
//		System.out.print(db.getValuesString(m1));
//		
//		db.insertIntoTable(db.getValuesString(m1));
//		
//		Musician[] musician_array = new Musician[db.getCount()];
//		musician_array = db.writeResult(db.selectAll());
//		
//		for(int i = 0; i< db.getCount(); i++) {
//			System.out.println(musician_array[i].get_m_name());
//		}
//		
//		db.close();
	}

}
