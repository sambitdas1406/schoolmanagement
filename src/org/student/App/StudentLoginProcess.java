package org.student.App;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginStudent")
public class StudentLoginProcess  extends HttpServlet 

{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(StudentLoginDao.validate(email, password)){
			out.print("you are successfully logged in!");
			request.getSession().setAttribute("login", "true");
			request.getSession().setAttribute("email", email);
			//response.sendRedirect("profile.jsp");
			response.sendRedirect("profile");
			
		}else{
			out.print("<p>Sorry, username or password error</p>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
		out.close();
	}
}
