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
    <title>Create an Account</title>
    <form action="SignUp">
        <input type="text" placeholder="Name" name="name" required><br>
        <input type="Email" placeholder="Email" name="mail" required><br>
        <input type="Password" placeholder="Password" name="passwd" required>
        <p>Re-enter your password</p>
        <input type="Password" placeholder="Confrim Password" name="cpass" required><br>
        <input type="number" placeholder="Phone Number" name="phno">
        <span>${error}<br></span>
        <button>Sign Up</button>
    </form>
    <p>Login to Existing Account</p>
    <a href="signin.jsp"><button>Sign In</button></a>
</body>
</html>
    