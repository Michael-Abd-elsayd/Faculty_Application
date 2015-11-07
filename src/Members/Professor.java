package Members;

import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DbConnection;
import userInput.GetData;

public class Professor {
	// Variables.
	private static String name, Email, subject;
	private static int age;
	
	/*----------------------- METHODS AREA ------------------------*/
	// Storing Professor in DB.
	public static void DB_add() {
		// Getting Student Information from user.
		System.out.println("\nEnter Professor Name : ");			name = GetData.GetString();
		System.out.println("\nEnter Professor Age : ");				age = GetData.GetInt();
		System.out.println("\nEnter Professor E-Mail : ");			Email = GetData.GetString();
		System.out.println("\nEnter Professor Subject : ");			subject = GetData.GetString();

		try {
			// Insert Student in DB.
			DbConnection.st = DbConnection.conn
					.prepareStatement("insert into professor (name,age,Email,subject) values(?,?,?,?)");

			DbConnection.st.setString(1,name);
			DbConnection.st.setInt(2,age);
			DbConnection.st.setString(3,Email);
			DbConnection.st.setString(4,subject);

			DbConnection.st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Removing Professor from DB.
	public static void DB_remove() {
		// Get Student Name to be deleted.
		System.out.println("\nEnter Student Name to delete : ");		
		name = GetData.GetString();
		// DB Query.
		try {
			DbConnection.st = DbConnection.conn.prepareStatement("delete from professor where name=?");
			DbConnection.st.setString(1, name);
			DbConnection.st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Show All Professors.
	public static void DB_showAll() {
		int count = 0;
		try {
			// SELECT QUERY.
			DbConnection.st = DbConnection.conn.prepareStatement("select * from professor");
			ResultSet rs = DbConnection.st.executeQuery();
			// Printing Information.
			System.out.println("Name\t\tAge\t\tSubject\t\tE-Mail\n");
			while (rs.next()) {
				count++;
				System.out.println(rs.getString("name") + "\t\t" + rs.getString("age") + "\t\t"
						+ rs.getString("subject") + "\t\t" + rs.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("------------------------------\nTable contains " + count
				+ " Professor(s).\n------------------------------");
	}
}
