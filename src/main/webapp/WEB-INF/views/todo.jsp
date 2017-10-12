<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

 <form:form method="post" commandName="todo">
 <div class="container">
 	<fieldset class="form-group">
    <h2><form:label path="item">Todo Name</form:label></h2>
     <form:input path="item" type="text" class="form-control"  required="required"/>
     <form:errors path="item" cssClass="text-warning"></form:errors>
     </fieldset>
     <br>
      <input class="btn btn-success" type="submit" value="Submit"/>
   </div>   
  </form:form>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>