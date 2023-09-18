package jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CrudOpration {
	
		public static BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		public static void insertData() throws Exception {

			Class.forName("com.mysql.cj.jdbc.Driver");
			String urlString = "jdbc:mysql://localhost:3306/PuneUnivecity";
			String usernameString = "root";
			String passString = "root";
			Connection connection = DriverManager.getConnection(urlString, usernameString, passString);
			String queryString = "insert into Students(name,age,gender) values(?,?,?)";
			PreparedStatement pStatement = connection.prepareStatement(queryString);
			System.out.println("enter your name ");
			String name = bReader.readLine();
			System.out.println("enter age");
			String age = bReader.readLine();
			System.out.println("enter gender");
			String gender = bReader.readLine();
			pStatement.setString(1, name);
			pStatement.setString(2, age);
			pStatement.setString(3, gender);
			
			pStatement.executeUpdate();
			
			connection.close();
		}

		public static void updateData() throws Exception{

			
				Class.forName("com.mysql.cj.jdbc.Driver");

				String urlString = "jdbc:mysql://localhost:3306/PuneUnivecity";
				String usernameString = "root";
				String passString = "root";
				Connection connection = DriverManager.getConnection(urlString, usernameString, passString);
				String qeryString = "update students set name=? where id=?";
				PreparedStatement preparedStatement = connection.prepareStatement(qeryString);
				System.out.println("Enter  replace name ");
				String name = bReader.readLine();
				System.out.println("Enter id ");
				String id = bReader.readLine();
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, id);
				preparedStatement.executeUpdate();
				System.out.println("success full query");
			
		}

		public static void delteData() throws Exception {

			
				Class.forName("com.mysql.cj.jdbc.Driver");
				String urlString = "jdbc:mysql://localhost:3306/PuneUnivecity";
				String usernameString = "root";
				String passString = "root";
				Connection connection = DriverManager.getConnection(urlString, usernameString, passString);
				String queryString = "delete from Students where id=?";
				PreparedStatement pStatement = connection.prepareStatement(queryString);
				System.out.println("enter id for delete ");
				String id = bReader.readLine();
				pStatement.setString(1, id);
				
				pStatement.executeUpdate();
		
		}

		public static void fetchData() throws Exception{

				Class.forName("com.mysql.cj.jdbc.Driver");
				String urlString = "jdbc:mysql://localhost:3306/PuneUnivecity";
				String usernameString = "root";
				String passString = "root";
				Connection connection = DriverManager.getConnection(urlString, usernameString, passString);
				String fetString = "select * from Students";
				PreparedStatement pStatement = connection.prepareStatement(fetString);
				ResultSet rSet = pStatement.executeQuery();
					while (rSet.next()) {
					System.out.println(rSet.getInt("id") + " \t" + rSet.getString("name") + " \t" + rSet.getString("age")
							+ " \t" + rSet.getString("gender"));
				}
				connection.close();
		}

		public static void allMethod() throws Exception {

			System.out.println("what do you want insert/update/delete/fetch");
			String ch = bReader.readLine();

			switch (ch) {
			case "insert":
				CrudOpration.insertData();
				break;
			case "update":
				CrudOpration.updateData();
				break;
			case "delete":
				CrudOpration.delteData();
				break;
			case "fetch":
				CrudOpration.fetchData();
				break;
			default:
				System.out.println(" Invalid query");
				break;

			}
			System.out.println("run this program agin y/n");
			String ch1 = bReader.readLine();
			if (ch1.equalsIgnoreCase("y") | ch1.equalsIgnoreCase("Y")) {
				CrudOpration.allMethod();

			} else if (ch1.equalsIgnoreCase("n") | ch1.equalsIgnoreCase("N")) {
				System.out.println("okay no Problem");

			}
		}

		public static void main(String[] args) throws Exception {
			CrudOpration.allMethod();
		}
	}

