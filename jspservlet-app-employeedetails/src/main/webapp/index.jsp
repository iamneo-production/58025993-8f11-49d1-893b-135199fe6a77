<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>AddEmpDetails</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>employeeID</td>
     <td><input type="text" name="employeeID" /></td>
    </tr>
    <tr>
     <td>employeeName</td>
     <td><input type="text" name="employeeName" /></td>
    </tr>
    <tr>
     <td>employeeRole</td>
     <td><input type="text" name="employeeRole" /></td>
    </tr>
    <tr>
     <td>employeesalary</td>
     <td><input type="text" name="employeesalary" /></td>
    </tr>
    <tr>
     
   </table>
   <input type="submit" value="Submit" />
  </form>
 </div>
</body>
</html>