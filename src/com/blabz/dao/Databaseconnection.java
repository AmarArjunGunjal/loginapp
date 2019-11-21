package com.blabz.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.blabz.model.ForgetModel;
import com.blabz.model.Registrationmodel;

/**
 * @author : Amar A. Gunjal
 * @purpose: Here the database connectivity is done.
 *
 */
public class Databaseconnection {
	static Connection con;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/demo";
			String uname = "root";
			String pass = "password";
			con = DriverManager.getConnection(url, uname, pass);
			System.out.println("Connected");
		} catch (Exception e) {
			// TODO: handle exception
		}

		return con;
	}

	/**
	 * @param reg:its the object of the registration model and the entered data into
	 *                registration page that data is stored into the reg.
	 * @return: values which is entered on registration page.
	 * @throws SQLException
	 */
	public int add(Registrationmodel reg) throws SQLException {
		int values = 0;
		con = getConnection();
		PreparedStatement preparedStatement = con.prepareStatement("insert into logininfo2 values(?,?,?,?)");
		preparedStatement.setString(1, reg.getName());
		preparedStatement.setString(2, reg.getEmail());
		preparedStatement.setString(3, reg.getPhone());
		preparedStatement.setString(4, reg.getPassword());

		values = preparedStatement.executeUpdate();
		System.out.println(values + "rows affected");

		return values;
	}

	/**
	 * @param name:user     enterred name while login
	 * @param password:user entered password while login.
	 * @return i
	 * @throws SQLException
	 */
	public static int login(String name, String password) throws SQLException {
		int i = 0;
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement("select * from logininfo2");

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String username = rs.getString("name");
				String passwordd = rs.getString("pass");
					name.trim();
							password.trim();
				if (username.equals(name) && passwordd.equalsIgnoreCase(password)) {
					i = 1;

				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;

	}

	/**
	 * @param forgetModel=its object of forget model which is pojo. in that object,
	 *                        the values which is entered for check that the email
	 *                        is correct or not
	 * @param value
	 * @return i
	 */
	public static int Forget(ForgetModel forgetModel, String value) {
		int i = 0;
		try {
			PreparedStatement preparedStatement = getConnection().prepareStatement("select * from logininfo2");

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				String email = rs.getString("email");

				if (email.equals(value)) {
					i = 1;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

	/**
	 * @param newpassword:the user entered password which he want to change
	 * @param emailv:here     the email address that user want to change the
	 *                        password
	 * @return i
	 * @throws SQLException
	 */
	public static int newPassword(String newpassword, String emailv) throws SQLException {

		int i = 0;
		try {
			PreparedStatement preparedStatement = getConnection()
					.prepareStatement("update logininfo2 set pass=? where email=?");
			preparedStatement.setString(1, newpassword);
			preparedStatement.setString(2, emailv);
			int value = preparedStatement.executeUpdate();
			con.commit();
			if (value > 0) {
				i++;
				System.out.println(i);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return i;

	}

	/**
	 * @param name :its store the name of user which is login
	 * @return arraylist
	 * @throws SQLException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static ArrayList show(String name) throws SQLException {
		ArrayList al = new ArrayList();
		PreparedStatement preparedStatement = getConnection().prepareStatement("select * from logininfo2 where name=?");
		preparedStatement.setString(1, name);
		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String name1 = rs.getString("name");
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			System.out.println(email);
			System.out.println(phone);
			al.add(name1);
			al.add(email);
			al.add(phone);
		}
		return (ArrayList) al;

	}
}
