package DBHelpers;

public class MusicianSQL extends SQLHelper {

	@Override
	public void setTableName() {
		table = "musician";
	}

	public static void main(String[] args) throws Exception {
		MusicianSQL db = new MusicianSQL();
		MusicianSQL.initDB();
		db.initTable();
		db.getCount();
		db.close();
	}

}
