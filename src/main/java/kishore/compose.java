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
import java.sql.Statement;
@WebServlet("/compose")
public class compose extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			HttpSession session = request.getSession();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kishore","root","Karuppusamy@123");
			String fmail = (String)session.getAttribute("str");
			String tmail = request.getParameter("tmail");
			String mess = request.getParameter("message");
			String query = "select * from Accountinfo where email=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,tmail);
			ResultSet rs = ps.executeQuery();
			rs.next();
			String cpass = rs.getString("email");
			if(cpass.equals(tmail))
			{
				query = "insert into sent values (?,?,?)";
				ps = con.prepareStatement(query);
				ps.setString(1,fmail);
				ps.setString(2,tmail); 
				ps.setString(3,mess);
				ps.executeUpdate();
				query = "insert into receive values (?,?,?)";
				ps = con.prepareStatement(query);
				ps.setString(1,tmail);
				ps.setString(2,fmail); 
				ps.setString(3,mess);
				ps.executeUpdate();
				RequestDispatcher rd= request.getRequestDispatcher("MailHomePage.jsp");
				rd.forward(request, response);
				ps.close();
			}
			con.close();
		}
		catch  (SQLException | ClassNotFoundException e) 
		{
			request.setAttribute("error","ENTERED RECEIPIENT MAIL ID NOT FOUND");
			RequestDispatcher rd= request.getRequestDispatcher("Compose.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		}
	}
}
