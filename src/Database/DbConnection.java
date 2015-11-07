package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection implements DB_config{
	// Variables
	private static String DB_name = "faculty";		// Database Name.
	private static String username = "root";		// Database User-name.
	private static String password = "";			// Database Password.
	private static String driver_name = "com.mysql.jdbc.Driver";
	public static Connection conn = null;
	public static PreparedStatement st = null;
	public static ResultSet rs = null;
	
	/*-------------------------- METHODS AREA -------------------------*/
	// Connect() Method.
	public static void DbConnect() {
		try {
			Class.forName(driver_name);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// DB Connection.
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DB_name, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// Queries.
		// try {
		// // CREATE TABLE.
		// // PreparedStatement st = conn.prepareStatement("create table teach
		// // (id INT,name VARCHAR(30))");
		//
		// // DROP = DELETE TABLE.
		// // PreparedStatement st = conn.prepareStatement("drop table teach");
		//
		// // INSERT
		// // PreparedStatement st = conn.prepareStatement("insert into student
		// // values(1,'mikel',20,1)");
		//
		// // UPDATE
		// // PreparedStatement st = conn.prepareStatement("update student set
		// // name='moka' where id=1");
		//
		// // DELETE
		// // PreparedStatement st = conn.prepareStatement("delete from student
		// // where id=1");
		//
		// // SELECT
		// st = conn.prepareStatement("select * from student where id=1");
		//
		// // Execute the Query (READING DATA)-(ONLY USED WITH 'SELECT').
		// ResultSet rs = st.executeQuery();
		// while (rs.next()) {
		// System.out.println(rs.getString("name"));
		// }
		//
		// // Execute the Query (WRITING DATA).
		// // st.executeUpdate();
		// } catch (SQLException e) {
		// e.printStackTrace();
		// }
	}
}
