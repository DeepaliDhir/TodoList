<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home</title>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<div class="container">
 <table class="table table-striped">
      <thead>
        <tr>
            <td>
          <h3> Todo List </h3>
            </td>
            
        </tr>
      </thead>
      <tbody>
        <c:forEach  items="${todos}" var="tester">
            <tr>
                <td>${tester.item}</td>
                <td>
                <a href="/todo/delete-todo?todoitem=${tester.item}" class="btn btn-danger">Delete</a>
                <a href="/todo/update-todo?updateitem=${tester.item}" class="btn btn-success">Update</a>
                </td>
            </tr>
        </c:forEach>
      </tbody>
  </table>
  
  
  <a class="btn btn-success" href="/todo/add-todo">Add</a>
  </div>
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>