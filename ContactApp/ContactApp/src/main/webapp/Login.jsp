<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body style="background-color:#d9e6f2"> 
			<fmt:setLocale value="${currentlocale}" />
			<fmt:setBundle basename="messages"/>
			<h3 align="center">User Login </h3>
				</br>
					<div>
						<form action="j_security_check" method="GET"><center>
							<input type="text"  name="j_username" placeholder= "username"></br></br> 
							<input type="password"  name="j_password" placeholder= "password"></br></br> 
							<input type="submit" value="Login">
							<input type="reset" value="reset"></br></br>
						</form>
							<a href="j_security_check?j_username=guest&j_password=guest">skip</a></center>
					</div>
		</body>
</body>
</html>