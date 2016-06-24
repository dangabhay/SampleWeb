<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Prime Number Generator</title>
</head>
<body>
<h3>This page helps generate prime numbers</h3>
<form action="primeNo" method="post">
	Enter the seed: <input type="textbox" name="seed" /><br/>
	Enter how many prime numbers are needed: <input type="textbox" name="count" /> <br/>
	Prime numbers to be: <input type="radio" name="separation" value="comma" checked>comma </input>
		<input type="radio" name="separation" value="newline">newline </input> separated
	<input name="Submit" type="submit" value="Submit" />
</form>
</body>
</html>