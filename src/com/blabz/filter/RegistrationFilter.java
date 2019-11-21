package com.blabz.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: Amar A. Gunjal
 * @since :17/11/2019
 * @purpose: Apply the regex for registration page
 *
 */
@WebFilter("/Registration")

public class RegistrationFilter implements Filter {
	HttpServletResponse response;
	HttpServletRequest request;

	/**
	 * Default constructor.
	 */
	public RegistrationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String name = request.getParameter("name");
		String phone = request.getParameter("phoneno");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rpassword = request.getParameter("rpassword");
		PrintWriter out = response.getWriter();
		if (nameFilter(name) != true) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Entered name is not in format');");
			out.println("location='register.jsp';");
			out.println("</script>");
		} else if (phoneFilter(phone) != true) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Enter Valid Phone Number');");
			out.println("location='register.jsp';");
			out.println("</script>");
		} else if (emailFilter(email) != true) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Enter Valid email id');");
			out.println("location='register.jsp';");
			out.println("</script>");
		} else if (passwordFilter(password) != true) {
			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Enter Valid password');");
			out.println("location='register.jsp';");
			out.println("</script>");
		} else if (rpasswordFilter(password, rpassword) != true) {

			response.setContentType("text/html");
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Entered password doese not match');");
			out.println("location='register.jsp';");
			out.println("</script>");
		} else {

			chain.doFilter(request, response);
			System.out.println("filter");
		} 

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	public boolean phoneFilter(String phone) throws IOException {
		Pattern patternphone = Pattern.compile("(0/91)?[7-9][0-9]{9}");
		Matcher matcher = patternphone.matcher(phone);
		if (matcher.matches() == true) {
			return true;
		} else {  
			return false;
		}

	}

	public boolean nameFilter(String name) throws IOException {

		System.out.println("name");
		String pat = "^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$";
		Pattern patternName = Pattern.compile(pat);
		Matcher matcher = patternName.matcher(name);
		if (matcher.matches() == true) {
			name.trim();
			return true;
		} else {
			return false;
		}

	}

	public boolean emailFilter(String email) throws IOException {
		Pattern patternEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		Matcher matcher = patternEmail.matcher(email);
		if (matcher.matches() == true) {
			email.trim();
			return true;
		} else {
			return false;

		}

	}

	public boolean passwordFilter(String password) throws IOException {
		Pattern patternPassword = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");

		Matcher matcher = patternPassword.matcher(password);
		if (matcher.matches() == true) {
			password.trim();	
			return true;
			
		} else {
			return false;
		}

	}

	public boolean rpasswordFilter(String rpassword, String password) {
		if (password.equals(rpassword)) {
			return true;
		} else {
			return false;
		}
	}

}
