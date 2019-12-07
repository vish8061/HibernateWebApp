<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateServlet" method="post">
<label>Enter ID to See the Record:</label>
<input type="number" name="c_id" required/>
<input type="hidden" name="method" value="view" />
<input type="submit" value="Submit"/>
</form>
</body>
</html>