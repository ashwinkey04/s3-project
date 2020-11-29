import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLHelper {
    private Connection connect = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    
   
    public void readDB() throws Exception {
        try {
        	Class.forName("org.postgresql.Driver");
        	connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/music_db",
        	            "postgres", "a");
            statement = connect.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * from musician");

            writeMeta(rs);
            writeResult(rs);
            
        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }
    }
    
    //For Logging purposes
    private void writeMeta(ResultSet resultSet) throws SQLException {
        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
    private void writeResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            String m_id = resultSet.getString("m_id");
            String m_name = resultSet.getString("m_name");
            String m_addr = resultSet.getString("m_addr");
            boolean licensed = resultSet.getBoolean("licensed");
            int m_awards = resultSet.getInt("m_awards");
           
            System.out.println("m_id: " + m_id);
            System.out.println("name: " + m_name);
            System.out.println("m_addr: " + m_addr);
            System.out.println("licensed: " + licensed);
            System.out.println("m_awards: " + m_awards);
        }
    }
    private void close() {
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
    
    public static void main(String[] args) throws Exception {
        SQLHelper db = new SQLHelper();
        db.readDB();
    }
}