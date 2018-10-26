package org.student.App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/profile")
public class Profile extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.jsp");
		}else{
			
			String email=(String)session.getAttribute("email");
			
			out.print("<span style='float:right'>Hi, "+email+"</span>");
			
			out.print("<h1>Your Details</h1>");
		
			try{
				Connection con=ConProvider.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from school.studentregd  where email=?");
				ps.setString(1,email);
				ResultSet rs=ps.executeQuery();
				out.print("<table border='1' style='width:700px;'>");
				out.print("<tr style='background-color:grey;color:white'><td>ID</td><td>Name</td></tr>");
				while(rs.next()){
					out.print("<tr><td>"+rs.getString("id")+"</td><td>"+rs.getString("name")+"</a></td></tr>");
				}
				out.print("</table>");
				out.print("<tr><td><a href='LogoutStudent'>LOGOUT</a></td></tr>");

				con.close();
			}catch(Exception e){out.print(e);}
		}
		
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
}
