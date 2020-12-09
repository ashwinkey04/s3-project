package DBHelpers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Musician;

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

	protected void setTableName() {
		table = "Musician"; // Setting musician as default table to avoid NPE
	}

	public int getCount() throws SQLException {
		ResultSet count_rs = statement.executeQuery("Select COUNT(*) from " + table);
		count_rs.next();
		count = count_rs.getInt("count");
		count_rs.close();
		return count;
	}

	public ResultSet selectAll() throws SQLException {
		try {
			initDB();
		} catch (Exception e) {
			e.printStackTrace();
		}
		resultSet = statement.executeQuery("SELECT * from " + table);

		writeMetaData(resultSet);
		return resultSet;

	}

	public static String surroundQuote(String value) {
		return "\'" + value + "\'";
	}
	

	public static String surroundQuote(Date value) {
		return "\'" + value + "\'";
	}

	public void insertIntoTable(String values) throws Exception {
		try {
			statement.execute("Insert into " + table + " values " + values);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public void deleteFromTable(String condition) throws Exception {
		System.out.println("delete from " + table + " where " + (condition));
		try {
			statement.execute("delete from " + table + " where " + condition);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	public void updateTable(String set, String condition) throws Exception {
		System.out.println("update " + table + " set " + set + " where " + (condition));
		try {
			statement.execute("update " + table + " set " + set + " where " + (condition));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}

	// For Logging
	private void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("Metadata for Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
		System.out.println(' ');
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