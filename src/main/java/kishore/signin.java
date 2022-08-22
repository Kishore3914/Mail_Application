package kishore;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Signin")
public class signin extends HttpServlet 
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kishore","root","Karuppusamy@123");
			String mail = request.getParameter("email");
			String pass = request.getParameter("pass");
			String query = "select * from Accountinfo where email=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,mail);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String cpass = rs.getString("Passwd");
			if(cpass.equals(pass))
			{
				//request.setAttribute("mail", mail);
				HttpSession session = request.getSession();
				session.setAttribute("str",mail);
				RequestDispatcher rd= request.getRequestDispatcher("MailHomePage.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("error","INVALID MAILID OR PASSWORD");
				RequestDispatcher rd= request.getRequestDispatcher("signin.jsp");
				rd.include(request, response);
			}
			ps.close();
			con.close();
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			request.setAttribute("error","INVALID MAILID OR PASSWORD");
			RequestDispatcher rd= request.getRequestDispatcher("signin.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
		
	}
}
