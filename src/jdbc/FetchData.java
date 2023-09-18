package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchData {
	public static void main(String[] args) {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost/sakinaka";
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
	}catch(Exception e) {
		
	}
}}