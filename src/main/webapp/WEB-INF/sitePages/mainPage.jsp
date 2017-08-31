<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log-in Page</title>
</head>
<body>

<div>
	<form:form method="POST" modelAttribute="loginInfo" action="homePage">
		<table>
			<tr>
				<td><form:errors path="wrongUserOrPass"/></td>
			</tr>
			<tr>	
				<td><form:label path="userName">User Name:</form:label> </td>
				<td><form:input id="usernamesField" name="userName" path="userName"/></td>
				<td><form:errors path="userName" /> </td>
			</tr>
			
			<tr>	
				<td><form:label path="passWord">Password:</form:label> </td>
				<td><form:password id="passwordsField" name="passWord" path="passWord"/> </td>
				<td><form:errors path="passWord" /> </td>
			</tr>
			
			<tr>
				<td><form:button type="submit" value="Submit">Log In </form:button>  </td>
				<td><a href=<c:url value="/registrationPage"/>>Sign Up</a>
			</tr>

		</table>
	
	</form:form>

</div>

</body>
</html>