package DBHelpers;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Staff;

public class StaffSQL extends SQLHelper {
	protected static StaffSQL db = new StaffSQL();

	@Override
	protected void setTableName() {
		table = "Staff";
	}
	
	private String getValuesString(Staff Staff) {
		String values = "(" +
						surroundQuote(Staff.get_staff_id())+","+
						surroundQuote(Staff.get_staff_name())+","+
						Staff.get_salary()+
						surroundQuote(Staff.get_join_date())+","+
						")";
		return values;
				
	}

	public Staff[] writeResult(ResultSet resultSet) throws SQLException {
		int count = getCount();
		int index = 0;
		Staff lyricist_array[] = new Staff[count];

		while (resultSet.next()) {
			
			lyricist_array[index] = new Staff();
			lyricist_array[index].set_staff_id(resultSet.getString("staff_id"));
			lyricist_array[index].set_staff_name(resultSet.getString("staff_name"));
			lyricist_array[index].set_join_date(resultSet.getDate("join_date"));
			lyricist_array[index].set_salary(resultSet.getInt("salary"));

			index++;
		}
		return lyricist_array;
	}
	
	public static void insert(Staff staff) throws Exception {
		StaffSQL.initDB();
		db.initTable();
		db.insertIntoTable(db.getValuesString(staff));
		db.close();
	}
	
	public static void delete(String m_id) throws Exception{
		StaffSQL.initDB();
		db.initTable();
		db.deleteFromTable("ly_id = "+surroundQuote(m_id));
		db.close();
	}
	
	public static void main(String[] args) throws Exception {
		
	}

}
