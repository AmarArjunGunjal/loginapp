package com.blabz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blabz.dao.Databaseconnection;
import com.blabz.model.NewPasswordModel;

/**
 * Servlet implementation class NewPassword
 */
/**
 * @author : Amar A.Gunjal
 * @since : 15/11/2019
 * @purpose : If user forgot the password and match the entered email then to
 *          reset the password its ask for entered the password and confirm
 *          password and if password and confirm password are match then its
 *          store the new password to the database.
 */
@WebServlet("/forget")

public class NewPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public NewPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String password = request.getParameter("password");
		String confirm_password = request.getParameter("cpassword");
		System.out.println(password);
		System.out.println(confirm_password);
		NewPasswordModel newPasswordModel = new NewPasswordModel();
		newPasswordModel.setPassword(password);
		newPasswordModel.setConfirmpassword(confirm_password);
		HttpSession ses = request.getSession(false);
		// emailv: the user which want to forget the password that user email address is
		// stored into the emailv by using seesion
		String emailv = (String) ses.getAttribute("email");

		Databaseconnection db = new Databaseconnection();
		if (password.equals(confirm_password)) {
			try {
				int value = db.newPassword(confirm_password, emailv);
				System.out.println(confirm_password);
				// System.out.println(value);
				if (value == 0) {
					// response.sendRedirect("login.jsp");
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Password Changed');");
					out.println("location='login.jsp';");
					out.println("</script>");

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

				System.out.println(e);
			}

		} else {
			// response.sendRedirect("login.jsp");

			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Enter Same Data');");
			out.println("location='login.jsp';");
			out.println("</script>");
		}
		// doGet(request, response);
	}

}
