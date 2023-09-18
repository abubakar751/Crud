package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbccrudDemo {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void insertData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Sakinaka";
			String user = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = "insert into students(name,age,gender) values(?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			System.out.println("Enter name");
			String name = br.readLine();
			System.out.println("Enter age");
			String age = br.readLine();
			System.out.println("enter gender");
			String gender = br.readLine();
			st.setString(1, name);
			st.setString(2, age);
			st.setString(3, gender);
			con.close();

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void updateData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3303/sakinaka";
			String user = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = "update students set name=? where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("Enter name");
			String name = br.readLine();
			System.out.println("enter id");
			int id = br.read();
			ps.setString(1, name);
			ps.setLong(2, id);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void deleteData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sakinaka";
			String user = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = "delete from students where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			System.out.println("enter id  ");
			int id = br.read();
			ps.setLong(1, id);

		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void fetchData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sakinaka";
			String user = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = " select * from Students ";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " \t" + rs.getString("name") + " \t" + rs.getInt("age") + "\t"
						+ rs.getString("gender"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void AllMethod() throws IOException {
		System.out.println(" what you wants Insert/update/Delete/fetch");
		String ch = br.readLine();
		switch (ch) {
		case "Insert":
			JdbccrudDemo.insertData();
			break;
		case "update":
			JdbccrudDemo.updateData();
			break;

		case " Delete":
			JdbccrudDemo.deleteData();
			break;
		case "fetch":
			JdbccrudDemo.fetchData();
			break;
		default:
			System.out.println("invalid query");
			break;

		}
		System.out.println("run this program again y/n");
		String s = br.readLine();
		if (s.equalsIgnoreCase("y") | s.equalsIgnoreCase("Y")) {
			JdbccrudDemo.AllMethod();

		} else if (s.equalsIgnoreCase("n") | s.equalsIgnoreCase("N")) {
			System.out.println(" Done 👍👍 ");
		}
	}

	public static void main(String args[]) throws IOException {
		JdbccrudDemo.AllMethod();

	}
}
