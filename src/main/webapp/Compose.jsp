<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
	<style type="text/css">
		input[type=Email]{
			background-color: #eee;
			padding: 14px 15px;
		    margin: 8px 0;
		    width: 80%;
		    border-radius:20px;
		}
		textarea{
			background-color: #eee;
			padding: 14px 15px;
		    margin: 8px 0;
		    border-radius:20px;
		}
    	body{
    		 background-color: #0000ff;
    	}
	</style>
</head>
<body>
	<%session = request.getSession();%>
	<%
		response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
		response.setHeader("pragma","no-cache");
		response.setHeader("Expires","0");
		if(session.getAttribute("str")== null && session.getAttribute("valid")!="admin")
		{
			RequestDispatcher rd= request.getRequestDispatcher("signin.jsp");
			rd.forward(request, response);
		}
	%>
	<%String str = (String)session.getAttribute("str");%>
	<title>Compose-<%out.println(str);%></title>
	<form action="compose" id = "userform">
		<input type="Email" placeholder="To" name="tmail" required><br><br>
		<textarea rows="10" cols="100" name="message" placeholder="Type your messsge here"></textarea><br>
		<span>${error}<br></span>
		<button>Send</button><br>
	</form>
	<a href="MailHomePage.jsp"><button>Back</button></a><br>
	<form action="Logout">
			<button>Logout</button><br>
	</form>
</body>
</html>