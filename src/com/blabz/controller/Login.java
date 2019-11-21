package com.blabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blabz.dao.Databaseconnection;

/**
 * Servlet implementation class Login
 */
/**
 * @author Amar A.Gunjal
 * @since:14/11/2019
 * @purpose:If the login data is matched then its redirect to the welcome page
 *
 */
@SuppressWarnings("serial")
@WebServlet("/Login")
public class Login extends HttpServlet {

	@SuppressWarnings({ "rawtypes", "static-access" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		System.out.println(name);
		System.out.println(password);
		
		Databaseconnection db = new Databaseconnection();
		try {
			int login = db.login(name, password);
			
			System.out.println(login);
			if (login > 0) {
				ArrayList list = db.show(name);
				// here take the login user data into the list by requesting the session
				System.out.println(list);
				HttpSession ses = request.getSession();
				ses.setAttribute("value", list);
				response.sendRedirect("welcome.jsp?list");
			} else {
				// to show the alert box
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('User or password incorrect');");
				
				out.println("location='login.jsp';");
				out.println("</script>");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
