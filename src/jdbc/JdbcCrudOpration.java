package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcCrudOpration {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void insertValue() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Employee";
			String userName = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, userName, password);
			String query = "insert into Emp_Details(Emp_id,Emp_Name,Emp_age,Emp_Gender)values(?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);

			System.out.println("entre Emp_Id...");
			String Emp_Id = br.readLine();

			System.out.println("entre Emp_Name...");
			String Emp_Name = br.readLine();

			System.out.println("entre Emp_age...");
			String Emp_age = br.readLine();

			System.out.println("entre Emp_Gender...");
			String Emp_Gender = br.readLine();

			pstmt.setString(1, Emp_Name);
			pstmt.setString(2, Emp_age);
			pstmt.setString(3, Emp_Gender);

			int i = pstmt.executeUpdate();

			if (i > 0)
				System.out.println("query Successfully...." + i);

			else
				System.out.println("fail..." + i);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateValue() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Employee";
			String userName = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, userName, password);
			String update = "update Emp_Details set Emp_Name=? where Emp_Id=?";
			PreparedStatement pstmt = con.prepareStatement(update);

			System.out.println("entre Emp_Name...");
			String Emp_Name = br.readLine();

			System.out.println("entre Emp_Id... ");
			String Emp_Id = br.readLine();

			pstmt.setString(1, Emp_Name);
			pstmt.setString(2, Emp_Id);

			int i = pstmt.executeUpdate();

			if (i > 0)
				System.out.println("query Successfully...." + i);

			else
				System.out.println("fail..." + i);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteValue() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Employee";
			String userName = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, userName, password);
			String delete = "delete from Emp_Details where Emp_Id=?";
			PreparedStatement pstmt = con.prepareStatement(delete);

			System.out.println("entre Emp_Id");
			String Emp_Id = br.readLine();

			pstmt.setString(1, Emp_Id);

			int i = pstmt.executeUpdate();

			if (i > 0)
				System.out.println("query Successfully...." + i);

			else
				System.out.println("fail..." + i);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getFetchValue() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Employee";
			String userName = "root";
			String password = "root";
			Connection con = DriverManager.getConnection(url, userName, password);

			String fetch = "select * from Emp_Details";

			PreparedStatement pre = con.prepareStatement(fetch);
			ResultSet execute = pre.executeQuery();
			if (execute.next()) {
				System.out.println(execute.getString("Emp_Id") + "/" + execute.getString("Emp_Name") + "/"
						+ execute.getString("Emp_Age") + "/" + execute.getString("Emp_Gender"));
			}
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

	public static void autorun() throws IOException,ClassNotFoundException,SQLException {
		System.out.println("which you want to choose (insert/update/delete/getFetch)");
		String choose = br.readLine();
		switch (choose) {
		case "insert":
			JdbcCrudOpration.insertValue();
			break;

		case "update":
			JdbcCrudOpration.updateValue();
			break;
		case "delete":
			JdbcCrudOpration.deleteValue();
			break;
		case "getFetch":
			JdbcCrudOpration.getFetchValue();
			break;
		default:
			System.out.println("you have not matched any case...");
		}
		System.out.println("run this program again(y/n)");
		String str = br.readLine();
		if (str.equalsIgnoreCase("y") | str.equalsIgnoreCase("Y")) {
			JdbcCrudOpration.autorun();
		} else if (str.equalsIgnoreCase("N") | str.equalsIgnoreCase("n")) {
			System.out.println("Thanks👌👌👌...");
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		JdbcCrudOpration.autorun();
	}
}
