<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Page</title>


<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<spring:url value="/resources/core/js/jsfunctions.js" var="functionJs"/>
<script src="${functionJs}"></script>




</head>
<body>

<div>

	<form:form method="POST" action="createUser" modelAttribute="registreInfo">
	
		<table>
			<tr>
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input id="firstName" path="firstName"/>
				<td><form:errors path="firstName" />			
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input id="lastName" path="lastName"/>
				<td><form:errors path="lastName" />			
			</tr>
			<tr>
				<td><form:label path="passWord">Password</form:label></td>
				<td><form:password id="passWord" path="passWord"/>
				<td><form:errors path="passWord" />		
				<td><p id="errorPass"> </p></td>	
			</tr>
			<tr>
				<td><form:label path="verificationPassword">Repeat Password</form:label></td>
				<td><form:password id="verificationPassword" path="verificationPassword" onchange="myFunction()" />
				<td><form:errors path="verificationPassword" />	
				<td><p id="errorPassvery"> </p></td>		
			</tr>
			<tr>
				<td><form:label path="email">E-mail</form:label></td>
				<td><form:input id="email" path="email"/>
				<td><form:errors path="email" />			
			</tr>
			<tr>
				<td><form:label path="telePhone">Telephone no.</form:label></td>
				<td><form:input id="telePhone" path="telePhone"/>
				<td><form:errors path="telePhone" />			
			</tr>
			<tr>
				<td><form:button type="submit" value="Submit">Create Account</form:button>			
			</tr>							
		
		</table>	
	
	</form:form>

</div>

</body>
</html>