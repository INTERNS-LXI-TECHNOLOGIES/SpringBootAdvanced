<!DOCTYPE html>
<html>
<head>
	<title>Contact login</title>
</head>
<body>
<form action="j_security_check" method="POST"><center>
	<input type="text" name="j_username" placeholder="Enter username"></br></br>
	<input type="password" name="j_password" placeholder="Enter password">
	<input type="submit" value="Login" name="submit">
</form>
<a href="j_security_check?j_username=guest&j_password=guest">skip</a>
</body>
</html>