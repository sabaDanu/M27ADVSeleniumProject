package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;

public class SamplJDBC {
	@Test
	public void executeQueryJDBC() throws SQLException {
		//Fetch the driver from Mysql
		Driver dref=new Driver();
		//Step1:Register the driver/database
		DriverManager.registerDriver(dref);
		
		//Step2:getconnection with Driver-database name
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb", "root", "root");
		//Step3:Use the create statement
		Statement state = con.createStatement();
		//Step4:Execute any query-tablename
		ResultSet result = state.executeQuery("select * from customerinfo;");
		while(result.next()) {
			System.out.println(result.getString(1)+"-"+result.getInt(2)+"-"+result.getString(3));
		}
		//Step5:Close the database
		con.close();
		
 	}
}
