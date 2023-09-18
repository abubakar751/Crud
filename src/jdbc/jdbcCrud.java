package jdbc;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbcCrud {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void insertdata() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sakinaka";
		String uname = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url, uname, pass);
		String q = "insert into students(name,mobile,course) values(?,?,?)";
		PreparedStatement p = con.prepareStatement(q);
		System.out.println(" enter your name");
		String name = br.readLine();
		System.out.println("enter mobilen number ");
		String mobile = br.readLine();
		System.out.println("enter course ");
		String course = br.readLine();
		p.setString(1, name);
		p.setString(2, mobile);
		p.setString(3, course);
		p.execute();

	}

	public static void update() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sakinaka";
		String uname = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url, uname, pass);
		String q = "update   students set name=? where=?";
		PreparedStatement p = con.prepareStatement(q);
		System.out.println("enter name ");
		String name = br.readLine();
		System.out.println("enter id ");
		String id = br.readLine();
		p.setString(1, name);
		p.setString(2, id);
		p.executeUpdate();

	}

	public static void deleteData() throws ClassNotFoundException, SQLException, IOException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sakinaka";
		String uname = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url, uname, pass);
		String q = "delete from students where id =?";
		PreparedStatement p = con.prepareStatement(q);
		System.out.println("eneter id");
		String id = br.readLine();
		p.setString(1, id);
		p.executeQuery();
	}

	public static void fetchData() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/sakinaka";
		String uname = "root";
		String pass = "root";
		Connection con = DriverManager.getConnection(url, uname, pass);
		String q = "select * from Students ";
		PreparedStatement p = con.prepareStatement(q);
		ResultSet rs = p.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("mobile") + "\t"
					+ rs.getString("course"));
		}
	}

	public static void All() throws IOException, ClassNotFoundException, SQLException {
		System.out.println("what you wants Insert/update/Delete/fetch");
		String s = br.readLine();
		switch (s) {
		case "Insert":
			jdbcCrud.insertdata();
			break;
		case "update":
			jdbcCrud.update();
			break;
		case "Delete":
			jdbcCrud.deleteData();
			break;
		case "fetch":
			jdbcCrud.fetchData();
			break;
		default:
			System.out.println(" invalid query");
			break;
		}
		System.out.println(" do you wants rerun y/n");
		String s1 = br.readLine();
		if (s1.equalsIgnoreCase("y") | s1.equalsIgnoreCase("Y")) {
			jdbcCrud.All();
		} else if (s1.equalsIgnoreCase("n") | s1.equalsIgnoreCase("N")) {
			System.out.println(" okay chal nikal ");
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		jdbcCrud.All();
	}
}
