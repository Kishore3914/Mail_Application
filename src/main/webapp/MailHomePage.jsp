<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="style.css">
	<style type="text/css">
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
	<title>Home-<%out.println(str);%></title>
	<div class="container">
		<form action="Inbox">
            <button>Inbox</button><br>
        </form>
        <form action="Sent">
            <button>Sent</button><br>
        </form>
        <a href="Compose.jsp"><button>Compose</button></a>
        <br>
		<form action="Logout">
			<button>Logout</button>
		</form>
	</div>
</body>
</html>