package DBHelpers;

import Objects.Musician;

public class MusicianSQL extends SQLHelper {

	@Override
	public void setTableName() {
		table = "musician";
	}
	
	

	public static void main(String[] args) throws Exception {
		MusicianSQL.initDB();
		MusicianSQL db = new MusicianSQL();
		db.initTable();
		Musician[] musician_array = new Musician[db.getCount()];
		musician_array = db.selectAll();
		
		for(int i = 0; i< db.getCount(); i++) {
			System.out.println(musician_array[i].get_m_id());
		}
		
		db.close();
	}

}
