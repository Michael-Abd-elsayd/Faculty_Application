package Members;

import java.sql.ResultSet;
import java.sql.SQLException;
import Database.DbConnection;
import userInput.*;

public class Student {
	// Variables.
	private static String name, Email;
	private static int age, department, year;
	
	/*----------------------- METHODS AREA ------------------------*/
	// Add Student to DB.
	public static void DB_add() {
		// Getting Student Information from user.
		System.out.println("\nEnter Student Name : ");			name = GetData.GetString();
		System.out.println("\nEnter Student Age : ");			age = GetData.GetInt();
		System.out.println("\nEnter Student E-Mail : ");		Email = GetData.GetString();
		System.out.println("\nEnter Student Year : ");			year = GetData.GetInt();
		System.out.println("\nEnter Student Department No. : (DEFAULT : 1)\n"
				+ "[1]Preparatory\t[2]Electrical\t[3]Mechanical\t[4]Civiil");					
		department = GetData.GetInt();
		if(department >4 || department<1) department = 1;
		
		try {
			// Insert Student in DB.
			DbConnection.st = DbConnection.conn
					.prepareStatement("insert into student (name,age,Email,department_id,year) "
						+ "values('"+name+"','"+age+"','"+Email+"','"+department+"','"+year+"')");
			DbConnection.st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	// Removing Student from DB.
	public static void DB_remove() {
		// Get Student Name to be deleted.
		System.out.println("\nEnter Student Name to delete : ");		
		name = GetData.GetString();
		// DB Query.
		try {
			DbConnection.st = DbConnection.conn.prepareStatement("delete from student where name=?");
			DbConnection.st.setString(1, name);
			DbConnection.st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Show All students.
	public static void DB_showAll() {
		int count = 0;
		try {
			DbConnection.st = DbConnection.conn
					.prepareStatement("select * from student,department WHERE student.department_id=department.id");
			ResultSet rs = DbConnection.st.executeQuery();

			System.out.println("Name\t\t\t  Age     Year    Department     E-Mail\n");
			while (rs.next()) {
				count++;
				name = rs.getString("name");
				System.out.println(rs.getString("name") + "\t\t\t  " + rs.getString("age") + "      " + rs.getString("year")
						+ "    " + rs.getString("department.department") + "     " + rs.getString("Email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(
				"----------------------------\nTable contains " + count + " Student(s).\n----------------------------");
	}
	
}
