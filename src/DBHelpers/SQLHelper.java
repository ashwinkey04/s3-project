package DBHelpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Objects.Musician;

public class SQLHelper {
	private static Connection connect = null;
	protected String table;
	private Statement statement = null;
	private ResultSet resultSet = null;
	int count;

	public static void initDB() throws Exception {
		try {
			Class.forName("org.postgresql.Driver");
			connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/music_db", "postgres", "a");

		} catch (Exception e) {
			throw e;
		}
	}

	public void initTable() throws SQLException {
		createStatement();
		setTableName();
	}

	public void createStatement() throws SQLException {
		statement = connect.createStatement();
	}

	public void setTableName() {
		table = "Musician"; // Setting musician as default table to avoid NPE
	}

	public int getCount() throws SQLException {
		ResultSet count_rs = statement.executeQuery("Select COUNT(*) from " + table);
		count_rs.next();
		count = count_rs.getInt("count");
		count_rs.close();
		return count;
	}

	public Musician[] selectAll() throws SQLException {
		try {
			initDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(table);
		resultSet = statement.executeQuery("SELECT * from " + table);

		writeMetaData(resultSet);
		return writeResult(resultSet);

	}

	// For Logging
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
		System.out.println(' ');
	}

	private Musician[] writeResult(ResultSet resultSet) throws SQLException {

		int count = getCount();
		int index = 0;
		Musician musician_array[] = new Musician[count];

		System.out.println("****************** COUNT: " + count);

		while (resultSet.next()) {
			
			musician_array[index] = new Musician();
			musician_array[index].set_m_id(resultSet.getString("m_id"));
			musician_array[index].set_m_name(resultSet.getString("m_name"));
			musician_array[index].set_m_addr(resultSet.getString("m_addr"));
			musician_array[index].set_licensed(resultSet.getBoolean("licensed"));
			musician_array[index].set_m_award(resultSet.getInt("m_award"));

			System.out.println(musician_array[index].get_m_id());
			System.out.println(musician_array[index].get_m_name());
			System.out.println(musician_array[index].get_m_addr());
			System.out.println(musician_array[index].get_licensed());
			System.out.println(musician_array[index].get_m_award());

			index++;
		}
		return musician_array;
	}

	protected void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {
		}
	}
}