package com.blabz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blabz.dao.Databaseconnection;
import com.blabz.model.ForgetModel;

/**
 * Servlet implementation class Forget
 */
/**
 * @author:Amar A. Gunjal
 * @since :14/11/2019 purpose:It's check that on forget password window that
 *        entered email is correct or not if its correct then it will going onto
 *        the next page
 */
@WebServlet("/Forgot Password")
public class Forget extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Forget() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Here check that if entered email is match with the database then it sends to
	 * the next page
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
	
		
		String value = email;
		// creating object of POJO class
		ForgetModel forgetModel = new ForgetModel();
		forgetModel.setEmail(email);
		
		Databaseconnection db = new Databaseconnection();
		int result = db.Forget(forgetModel, value);
		HttpSession ses = request.getSession();
		ses.setAttribute("email", value);

		if (result > 0) {

			response.sendRedirect("forget.jsp");

		} else {
			// its shows the alert box with message
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('User is not existing');");
			out.println("location='forgot.jsp';");
			out.println("</script>");
		}

	}

}
