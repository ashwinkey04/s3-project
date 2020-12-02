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

		System.out.println("COUNT ******************** " + count); // For logging
		count_rs.close();
		return count;
	}

	public void selectAll() throws SQLException {
		try {
			initDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(table);
		resultSet = statement.executeQuery("SELECT * from " + table);

		writeMetaData(resultSet);
		writeResult(resultSet);

	}

	// For Logging
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
		System.out.println(' ');
	}

	private Musician writeResult(ResultSet resultSet) throws SQLException {
		Musician mus = new Musician();
		while (resultSet.next()) {
			String m_id = resultSet.getString("m_id");
			String m_name = resultSet.getString("m_name");
			String m_addr = resultSet.getString("m_addr");
			boolean licensed = resultSet.getBoolean("licensed");
			int m_award = resultSet.getInt("m_award");
			
			System.out.println("m_id: " + m_id);
			System.out.println("name: " + m_name);
			System.out.println("m_addr: " + m_addr);
			System.out.println("licensed: " + licensed);
			System.out.println("m_awards: " + m_award);
		}
		return mus;
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