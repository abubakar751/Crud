
package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcCrudeDemo {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void insertData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Sakinaka";
			String userName = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, userName, pass);
			String qeury = " insert into students (name,age,gender) values(?,?,?)";
			PreparedStatement pstm = con.prepareStatement(qeury);
			System.out.println("enter your name");
			String name = br.readLine();
			System.out.println("enter  your age");
			String age = br.readLine();
			System.out.println("Enter gender ");
			String gender = br.readLine();
			pstm.setString(1, name);
			pstm.setString(2, age);
			pstm.setString(3, gender);
			con.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void updateData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Sakinaka";
			String userName = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, userName, pass);
			String query = "update Students  set name=? where id=?";
			PreparedStatement pstm = con.prepareStatement(query);
			System.out.println("enter your name");
			String name = br.readLine();
			System.out.println("enter id");
			String id = br.readLine();
			pstm.setString(1, name);
			pstm.setString(2, id);
			con.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void deleteData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Sakinaka";
			String userName = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, userName, pass);
			String query = "delete from students where id=?";
			PreparedStatement pstm = con.prepareStatement(query);
			System.out.println("enter id");
			String id = br.readLine();
			pstm.setString(1, id);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void fetchData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Sakinaka";
			String userName = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, userName, pass);
			String qury = "select * from students ";
			PreparedStatement pstm = con.prepareStatement(qury);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("age") + "\t"
						+ rs.getString("gender"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void methods() throws IOException {
		System.out.println(" what you want Insert/update/delete/fetch");
		String ch = br.readLine();
		switch (ch) {
		case "Insert":
			JdbcCrudeDemo.insertData();
			break;
		case "update":
			JdbcCrudeDemo.updateData();
			break;
		case "delete":
			JdbcCrudeDemo.deleteData();
			break;
		case "fetch":
			JdbcCrudeDemo.fetchData();
			break;
		default:
			System.out.println("not match any query");

		}
		System.out.println("run this program again(y/n)");
		String str = br.readLine();
		if (str.equalsIgnoreCase("y") | str.equalsIgnoreCase("Y")) {
			JdbcCrudeDemo.methods();
		} else if (str.equalsIgnoreCase("N") | str.equalsIgnoreCase("n")) {
			System.out.println("Thanks👌👌👌...");
		}
	}

	public static void main(String[] args) throws IOException {
		JdbcCrudeDemo.methods();

	}
}
