<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!Doctype html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="style.css">
    <style type="text/css">
    	body{
    		 background-color: #0000ff;
    	}
    </style>
</head>
<body>
    <title>Login or Register</title><br><br>
    <div class="container">
	    <form action="Signin" method="post">
	        <input type="Email" placeholder="Email" name="email" required><br><br>
	        <input type="Password" placeholder="Password" name="pass" required><br><br>
	        <span>${error}<br></span>
	        <button>Sign In</button>
	    </form>
	    <p>Create account</p>
	    <a href="signup.jsp"><button>Sign Up</button></a>
    </div>
</body>
</html>
