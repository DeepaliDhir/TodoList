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
<h3> Todo List </h3>
<p>
TodoList section is to view the complete list of Todo's which will allow the user to to perform creating a row using Add button ,Deleting a row using delte button , updating a row using update button and once the task is completed completing the task using Complete button
 </p>
 <br>
 <table class="table table-striped table-bordered table-hover">
           <tbody>
        <c:forEach  items="${todos}" var="tester">
            <tr>
                <td>${tester.item}</td>
                <td>
                <a href="/todo/delete-todo?todoitem=${tester.item}" class="btn btn-danger">Delete</a>
                <a href="/todo/update-todo?updateitem=${tester.item}" class="btn btn-success">Update</a>
                <a href="/todo/completed-todo?completeitem=${tester.item}" class="btn btn-success">Completed</a>
                </td>
            </tr>
        </c:forEach>
      </tbody>
  </table>
  <a class="btn btn-success" href="/todo/add-todo">Add</a>
  </div>
  <br>
  <br>
  <br>
  
  <div class="container">
    <h3> Completed List</h3>
  <p>Completed List section will show the task which are completed</p>
     <br>
 <table class="table table-striped table-bordered table-hover">
     
      <tbody>
        <c:forEach  items="${todosd}" var="donel">
            <tr>
                <td>${donel.item}</td>
                <td>
              
                </td>
            </tr>
        </c:forEach>
      </tbody>
  </table>
 
  </div>
  
  
   <div class="container">
   <h3> Pending List </h3>
   <p>Pending List section shows the tasks which are still pending  </p>
   <br>
 <table class="table table-striped table-bordered table-hover">
     
      <tbody>
        <c:forEach  items="${todosp}" var="pendingl">
            <tr>
                <td>${pendingl.item}</td>
                <td>
              
                </td>
            </tr>
        </c:forEach>
      </tbody>
  </table>
  
  </div>
  
  <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>