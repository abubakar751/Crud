package jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudJdbc {
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void insertdata() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mumbra";
			String username = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, username, pass);
			String query = "insert into student(name,age,gender) values(?,?,?)";
			PreparedStatement psmt = con.prepareStatement(query);
			
			System.out.println("eneter student name");
			String name = br.readLine();
			System.out.println(" Enter student age");
			int age=br.read();
			System.out.println("Enter Student gender");
			String gender= br.readLine();
			
			psmt.setString(1,name);
			psmt.setLong(2,age);
			psmt.setString(3,gender);
			
			int i = psmt.executeUpdate();

			if (i > 0)
				System.out.println("query Successfully...." + i);

			else
				System.out.println("fail..." + i);
			con.close();
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	public static void updateData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mumbra";
			String userName = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, userName, pass);
			String query = "update student set name=? where id=?";
			PreparedStatement pstm = con.prepareStatement(query);
			System.out.println("Eneter set name ");
			String name = br.readLine();
			System.out.println("eneter id");
			String id = br.readLine();
			pstm.setString(1, name);
			pstm.setString(2, id);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void deleteData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mumbra";
			String uname = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, uname, pass);
			String query = "delete from student where id=?";
			PreparedStatement pstm = con.prepareStatement(query);
			System.out.println(" eneter id ");
			String id = br.readLine();
			pstm.setString(1, id);
			pstm.executeUpdate();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void fetchData() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/mumbra";
			String uname = "root";
			String pass = "root";
			Connection con = DriverManager.getConnection(url, uname, pass);
			String query = " select  * from student ";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet re = pstm.executeQuery();
			if (re.next()) {
				System.out.println(re.getString(1) + "/" + re.getString(2) + "/" + re.getString(3) + "/"
						+ re.getString(4));;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	public static  void allMethod() throws IOException {
		
			System.out.println("which you want to choose  Insert :Upadate :delete:fetch");
			String str=br.readLine();
			switch(str) {
			case "Insert":
				CrudJdbc.insertdata();
				break;
			case "Update":
				CrudJdbc.updateData();
				break;
			case "delete":
				CrudJdbc.deleteData();
				break;
			case "fetch":
				CrudJdbc.fetchData();
				break;
				default:
					System.out.println("not match any query");
			}
			System.out.println("run this program y or not");
			String str1=br.readLine();
			if(str1.equalsIgnoreCase("y") | str1.equalsIgnoreCase("Y")) {
			
			CrudJdbc.allMethod();
			}
			else if(str1.equalsIgnoreCase("n") |str1.equalsIgnoreCase("N")){
				System.out.println("Thanks ");
			}
		
		}
	
	public static void main(String args[]) throws IOException {
		CrudJdbc.allMethod();
	}

}
