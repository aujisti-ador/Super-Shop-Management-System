import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class sqliteConnection {
	Connection con = null;
	public static Connection dbConnector ()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:EmployeeData.sqlite");
			//JOptionPane.showMessageDialog(null, "Connection Successful");
			return con;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
