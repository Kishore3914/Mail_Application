package kishore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Sent")
public class Sent extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			HttpSession session = request.getSession();
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kishore","root","Karuppusamy@123");
			String str = (String)session.getAttribute("str");
			String query = "select * from sent where Sentby=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,str);
			ResultSet rs = ps.executeQuery();
			ArrayList<String>sentmail = new ArrayList();
			ArrayList<String>sentmes = new ArrayList();
			while(rs.next())
			{
				sentmail.add(rs.getString("Receiveby"));
				sentmes.add(rs.getString("message"));
			}
			request.setAttribute("sentmail",sentmail);
			request.setAttribute("sentmsg",sentmes);
			RequestDispatcher rd= request.getRequestDispatcher("Sent.jsp");
			rd.forward(request, response);
			ps.close();
			con.close();
		}
		catch (ClassNotFoundException | SQLException e )
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}