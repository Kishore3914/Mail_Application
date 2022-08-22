package kishore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Inbox")
public class Inbox extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		try 
		{
			HttpSession session = request.getSession();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kishore","root","Karuppusamy@123");
			String str = (String)session.getAttribute("str");
			String query = "select * from receive where Receiveby=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,str);
			ResultSet rs = ps.executeQuery();
			ArrayList<String>receivemail = new ArrayList<>();
			ArrayList<String>receivemes = new ArrayList<>();
			while(rs.next())
			{
				receivemail.add(rs.getString("Sentby"));
				receivemes.add(rs.getString("message"));
			}
			request.setAttribute("receivemail",receivemail);
			request.setAttribute("receivemsg",receivemes);
			RequestDispatcher rd= request.getRequestDispatcher("Inbox.jsp");
			rd.forward(request, response);
			ps.close();
			con.close();
		}
		catch (SQLException | ClassNotFoundException e) 
		{
			RequestDispatcher rd= request.getRequestDispatcher("MailHomePage.jsp");
			rd.forward(request, response);
			// TODO Auto-generated catch block "select * from Accountinfo where email=?"
			//e.printStackTrace();
		}
	}
}