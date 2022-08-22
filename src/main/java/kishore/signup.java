package kishore;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SignUp")
public class signup extends HttpServlet 
{
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kishore","root","Karuppusamy@123");
			String name = request.getParameter("name");
			String email = request.getParameter("mail");
			String pass = request.getParameter("passwd");
			String cpass = request.getParameter("cpass");
			String num = request.getParameter("phno");
			String query = "insert into Accountinfo values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,email); 
			ps.setString(3,pass);
			ps.setString(4,num);
			if(pass.equals(cpass))
			{
				ps.executeUpdate();
				RequestDispatcher rd= request.getRequestDispatcher("signin.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("error","YOUR PASSWORD AND CONFRIMPASSWORD MUST BE SAME");
				RequestDispatcher rd= request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
			}
			ps.close();
			con.close();
		} 
		catch (SQLException | ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block "select * from Accountinfo where email=?"
			e.printStackTrace();
		}
	}
}