package com.blabz.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blabz.dao.Databaseconnection;
import com.blabz.model.Registrationmodel;

/**
 * Servlet implementation class Registration
 */
/**
 * @author: Amar A. Gunjal
 * @since : 15/11/2019
 * @purpose :While any new user want to register then it register here and
 *          stores the data into the database.
 *
 */
@WebServlet("/Registration")

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String phone = request.getParameter("phoneno");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
		System.out.println(password);
		System.out.println(rpassword);

		Registrationmodel reg = new Registrationmodel();
		reg.setName(name);
		reg.setPhone(phone);
		reg.setEmail(email);
		reg.setPassword(password);
		reg.setRpassword(rpassword);

		Databaseconnection db = new Databaseconnection();
		try {
			int value = db.add(reg);
			if (value > 0) {
				response.sendRedirect("login.jsp");
			} else {
				System.out.println("Enter Data Correctly");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
